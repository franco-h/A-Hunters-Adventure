package com.huntersadventure.game;

import com.fasterxml.jackson.databind.JsonNode;
import com.huntersadventure.gameobjects.Characters;
import com.huntersadventure.gameobjects.Direction;
import com.huntersadventure.gameobjects.Location;
import com.huntersadventure.jsonparser.Json;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Character Controller not yet in use. Below contains just an example.
 */

public class GameController {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Characters p1 = new Characters();
    List<Location> townMap = new ArrayList<>();
    ArrayList<String> playerInventory = new ArrayList<>();

    List<String> commands = new ArrayList<>(Arrays.asList(
            "look", "help", "quit"));

    List<String> preparatoryCommands = new ArrayList<>(Arrays.asList(
            "get", "go", "use"));

    List<String> direction = new ArrayList<>(Arrays.asList(
            "north", "south", "west", "east"));

    // TODO: Retrieve items from JSON file and store in a list.
    // Items in the room or from NPCs
    List<Location> items = new ArrayList<>();

    public GameController() throws IOException {
    }

    public void run() throws IOException {
        generateMap();
        createPlayer(townMap);
        startPrompt();
        startGame();
    }

    public void generateMap() throws IOException {
        JsonNode gtNode = Json.parse(new File("src/main/resources/locations/guardtower.json"));
        JsonNode tgNode = Json.parse(new File("src/main/resources/locations/towngate.json"));
        JsonNode bsNode = Json.parse(new File("src/main/resources/locations/blacksmith.json"));
        JsonNode ahNode = Json.parse(new File("src/main/resources/locations/abandonedhouse.json"));
        JsonNode innNode = Json.parse(new File("src/main/resources/locations/inn.json"));

        Location inn = Json.fromJson(innNode, Location.class);
        Location blackSmith = Json.fromJson(bsNode, Location.class);
        Location guardTower = Json.fromJson(gtNode, Location.class);
        Location abandonedHouse = Json.fromJson(ahNode, Location.class);
        Location townGate = Json.fromJson(tgNode, Location.class);

        // Location index: 0
        townMap.add(inn);
        // Location index: 1
        townMap.add(blackSmith);
        // Location index: 2
        townMap.add(guardTower);
        // Location index: 3
        townMap.add(abandonedHouse);
        // Location index: 4
        townMap.add(townGate);
        System.out.println(townMap);
    }


    /**
     * Create Player still in progress
     */
    public void createPlayer(List<Location> map) throws IOException {
        List<String> startInv = new ArrayList<>();
        System.out.println("What is your name?");
        String name = in.readLine();
        p1.setName(name);
        p1.setHealth(10);
        p1.setDamage(10);
        p1.setShield(10);
        p1.setInventory(startInv);
        p1.setLocation(map.get(0));
    }

    public void startPrompt() throws IOException {
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Welcome to the Hunter's Adventure!");
            System.out.println("Do you want to see the instructions? (y/n)");
            String input = in.readLine();
            if (input.equals("y")) {
                System.out.println("----------THE STORY SO FAR----------");
                System.out.println("For eons humanity itself has been under attack from malevolent entities, vicious creatures, and the very forces of evil itself. Once nearly wiped out from existence,\n" +
                        "they were saved from extinction by the actions of other brave humans that not only stood against these evils, but actively searched for it in order to destroy it. \n" +
                        "These hunters have remained steadfast in their defiance over centuries, however evil never rests. \n" +
                        "You are one of these hunters.\n\n" +
                        "After tracking a particularly vicious creature, you find yourself in an unfamiliar town, plagued with a recent string of brutal attacks and mysterious vanishings.\n" +
                        "Determined to find a link to the prey you're hunting, you decide to stay at the local inn, only to find yourself stuck as the town guards shut the gates, \n" +
                        "blocking off entry or exit from any visitors or residents. Determined to end its reign of terror, it is up to you to find items, weapons, and \n" +
                        "eventually destroy the creature that's been terrorizing the local town - whatever the cost...");
                System.out.println("--------------------");
            } else if (input.equals("n")) {
                keepGoing = false;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public void startGame() throws IOException {
        System.out.println("Welcome to the game!");
        // run help() to get a list of commands
        help();
        String output;
        String input;
        // Prompt for input until the user enters "quit". If the user enters quit, the game will exit.
        do {
            System.out.println("Enter a command below.");
            System.out.println(">");
            input = in.readLine();
            output = runCommand(input);
            System.out.println(output);
        } while (!input.equals("quit"));
    }

    private void help() {
        System.out.println("Here are the basic commands:");
        System.out.println("go [direction] - move in the specified direction");
        System.out.println("look - Read the description of the current room and the items available");
        System.out.println("get [item] - pick up the specified item");
        System.out.println("help - display commands available");
        System.out.println("quit - exit the game and return to menu");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
    }

    /**
     * Fixes any case(toLowerCase()) or whitespace(trim()) issues
     * Checks for valid user input
     */
    public String runCommand(String inputString) throws IOException {
        List<String> userInputs;
        String output = "ok";
        String lowerCaseInput = inputString.trim().toLowerCase();
        if (lowerCaseInput.equals("")) {
            output = "Please enter a command.";
        } else {
            userInputs = userInputs(lowerCaseInput);
            output = parseCommand(userInputs);
        }
        return output;
    }


    private static List<String> userInputs(String lowerCaseInput) {
        String delims = "[ \t,.:;?!\"']+";
        String[] words = lowerCaseInput.split(delims);

        List<String> strlist = new ArrayList<>(Arrays.asList(words));
        return strlist;
    }


    /**
     * parseCommand checks wordlist size and calls processSingleCommand,
     * processTwoCommand or lets user know their wordlist is invalid
     */
    private String parseCommand(List<String> wordlist) throws IOException {
        String message;
        if (wordlist.size () == 1) {
            message = processSingleCommand(wordlist);
        } else if (wordlist .size () == 2) {
            if (wordlist.get(0).equals("grab") || wordlist.get(0).equals("take")) {
                wordlist.set(0, "get");
            }
            message = processTwoCommand(wordlist);
        } else if (wordlist.size() == 3) {
            if (wordlist.get(0).equals("pick") && wordlist.get(1).equals("up")) {
                wordlist.set(0, "get");
                wordlist.set(1, wordlist.get(2));
            }
            message = processTwoCommand(wordlist);
        } else {
            message = "Invalid command.";
        }
        return message;
    }

    /**
     * processSingleCommand takes in an input as a List
     * and checks String 0 for keywords allowed in List<String> commands
     */
    private String processSingleCommand(List<String> wordlist) throws IOException {
        String commandOne;
        String message = "";

        commandOne = wordlist.get(0);
        if (!commands.contains(commandOne)) {
            message = commandOne + " is not a known verb! ";
        } else {
            switch (commandOne) {
                case "help":
                    help();
                    break;
                case "quit":
                    break;
                case "look":

                    message = "You are in the " + p1.getLocation().getName() + ". This is the " +
                            p1.getLocation().getDescription() + ".\n" +
                            "Items available: " + p1.getLocation().getItems();

                    break;
                default:
                    message = commandOne + " (not yet implemented)";
                    break;
            }
        }
        return message;
    }

    /**
     * processTwoCommand takes in two word input as a List
     * and checks String 0 and 1 for prep command and location
     */
    private String processTwoCommand(List<String> wordlist) {
        String commandOne;
        String commandTwo;
        String message = "";
        commandOne = wordlist.get(0);
        commandTwo = wordlist.get(1);
        if (!preparatoryCommands.contains(commandOne)) {
            message = commandOne + " is not a valid preparatory command.";
        }
        // TODO: Implement player's function to move between rooms
        if (commandOne.equals("go")) {
            if (commandTwo.equals("north")) {
                goN();
                message = "Your current location is the " + p1.getLocation().getName();
            } else if (commandTwo.equals("south")) {
                goS();
                message = "Your current location is the " + p1.getLocation().getName();
            } else if (commandTwo.equals("west")) {
                goW();
                message = "Your current location is the " + p1.getLocation().getName();
            } else if (commandTwo.equals("east")) {
                goE();
                message = "Your current location is the " + p1.getLocation().getName();
            } else {
                message = "Invalid direction.";
            }
        }

        // TODO: Testing p1.item
            if (commandOne.equals("get")) {
                if (p1.getLocation().getItems().contains(commandTwo)) {
                    p1.setInventory(Collections.singletonList(commandTwo));
                    p1.getLocation().setItems(p1.getLocation().getItems().stream()
                            .filter(item -> !item.equals(commandTwo))
                            .collect(Collectors.toList()));

                    System.out.println(p1.getInventory());
                    return "You pick up the " + commandTwo + ".";
                }
                else {
                    message = "There is no " + commandTwo + " here.";
                }

        } else if (commandOne.equals("use")) {
            if (items.contains(commandTwo)) {
                return "You use the " + commandTwo + ".";
            } else {
                message = "There is no " + commandTwo + " here.";
            }
        }
        return message;
    }

    public void movePlayer(Characters player, Location location) {
        player.setLocation(location);
    }

    public int moveTo(Characters player, Direction direction) {
        Location location = player.getLocation();
        int exit;

        switch (direction) {
            case NORTH:
                exit = location.getNorth();
                break;
            case SOUTH:
                exit = location.getSouth();
                break;
            case WEST:
                exit = location.getWest();
                break;
            case EAST:
                exit = location.getEast();
                break;
            default:
                exit = Direction.NOEXIT;
                break;
        }
        if (exit != Direction.NOEXIT) {
            movePlayer(player, townMap.get(exit));
        }
        return exit;
    }

    public void movePlayerTo(Direction direction) {
        if (moveTo(p1,direction) == Direction.NOEXIT) {
            System.out.println("No Exit");
        }
    }

    private void goN() {
        movePlayerTo(Direction.NORTH);
    }

    private void goS() {
        movePlayerTo(Direction.SOUTH);
    }

    private void goW() {
        movePlayerTo(Direction.WEST);
    }

    private void goE() {
        movePlayerTo(Direction.EAST);
    }

    public void clearCons() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    public void printBreak(int n) {
        for (int i = 0; i < n; i++)
            System.out.println("-");
        System.out.println();
    }


/**
 * Change banner to be read in
 */

//    public void welcomeBanner(){
//        System.out.println("                                                                                                                                                                                   \n" +
//                " @@@@@@      @@@  @@@  @@@  @@@  @@@  @@@  @@@@@@@  @@@@@@@@  @@@@@@@   @@@   @@@@@@       @@@@@@   @@@@@@@   @@@  @@@  @@@@@@@@  @@@  @@@  @@@@@@@  @@@  @@@  @@@@@@@   @@@@@@@@  \n" +
//                "@@@@@@@@     @@@  @@@  @@@  @@@  @@@@ @@@  @@@@@@@  @@@@@@@@  @@@@@@@@   @@  @@@@@@@      @@@@@@@@  @@@@@@@@  @@@  @@@  @@@@@@@@  @@@@ @@@  @@@@@@@  @@@  @@@  @@@@@@@@  @@@@@@@@  \n" +
//                "@@!  @@@     @@!  @@@  @@!  @@@  @@!@!@@@    @@!    @@!       @@!  @@@  @!   !@@          @@!  @@@  @@!  @@@  @@!  @@@  @@!       @@!@!@@@    @@!    @@!  @@@  @@!  @@@  @@!       \n" +
//                "!@!  @!@     !@!  @!@  !@!  @!@  !@!!@!@!    !@!    !@!       !@!  @!@       !@!          !@!  @!@  !@!  @!@  !@!  @!@  !@!       !@!!@!@!    !@!    !@!  @!@  !@!  @!@  !@!       \n" +
//                "@!@!@!@!     @!@!@!@!  @!@  !@!  @!@ !!@!    @!!    @!!!:!    @!@!!@!        !!@@!!       @!@!@!@!  @!@  !@!  @!@  !@!  @!!!:!    @!@ !!@!    @!!    @!@  !@!  @!@!!@!   @!!!:!    \n" +
//                "!!!@!!!!     !!!@!!!!  !@!  !!!  !@!  !!!    !!!    !!!!!:    !!@!@!          !!@!!!      !!!@!!!!  !@!  !!!  !@!  !!!  !!!!!:    !@!  !!!    !!!    !@!  !!!  !!@!@!    !!!!!:    \n" +
//                "!!:  !!!     !!:  !!!  !!:  !!!  !!:  !!!    !!:    !!:       !!: :!!             !:!     !!:  !!!  !!:  !!!  :!:  !!:  !!:       !!:  !!!    !!:    !!:  !!!  !!: :!!   !!:       \n" +
//                ":!:  !:!     :!:  !:!  :!:  !:!  :!:  !:!    :!:    :!:       :!:  !:!           !:!      :!:  !:!  :!:  !:!   ::!!:!   :!:       :!:  !:!    :!:    :!:  !:!  :!:  !:!  :!:       \n" +
//                "::   :::     ::   :::  ::::: ::   ::   ::     ::     :: ::::  ::   :::       :::: ::      ::   :::   :::: ::    ::::     :: ::::   ::   ::     ::    ::::: ::  ::   :::   :: ::::  \n" +
//                " :   : :      :   : :   : :  :   ::    :      :     : :: ::    :   : :       :: : :        :   : :  :: :  :      :      : :: ::   ::    :      :      : :  :    :   : :  : :: ::   \n" +
//                "                                                                                                                                                                                   ");
//    }
}
