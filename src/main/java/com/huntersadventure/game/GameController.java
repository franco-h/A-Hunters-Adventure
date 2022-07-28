package com.huntersadventure.game;

import com.fasterxml.jackson.databind.JsonNode;
import com.huntersadventure.gameobjects.Characters;
import com.huntersadventure.gameobjects.Direction;
import com.huntersadventure.gameobjects.Item;
import com.huntersadventure.gameobjects.Location;
import com.huntersadventure.jsonparser.Json;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Character Controller not yet in use. Below contains just an example.
 */

public class GameController {
    public static final String ANSI_RESET = "\u001B[0m";  //resets text color back to default value.
    public static final String cyan = "\u001B[36m";
    public static final String yellow = "\u001B[33m";

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Characters p1 = new Characters();
    List<Location> townMap = new ArrayList<>();
    List<Item> gameItems = new ArrayList<>();
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
        generateItems();
        generateMap();
        createPlayer(townMap);
        startPrompt();
        startGame();
    }

    public void generateItems() {

        try {
            Json json = new Json();
            JsonNode badgeNode = json.parse(json.getResourceStream("/items/badge.json"));
            JsonNode silverNode = json.parse(json.getResourceStream("/items/arrows.json"));
            JsonNode boxNode = json.parse(json.getResourceStream("/items/locker.json"));
            JsonNode potionNode = json.parse(json.getResourceStream("/items/potion.json"));
            JsonNode mapNode = json.parse(json.getResourceStream("/items/map.json"));
            JsonNode bowNode = json.parse(json.getResourceStream("/items/bow.json"));
            JsonNode keyNode = json.parse(json.getResourceStream("/items/key.json"));
            JsonNode swordNode = json.parse(json.getResourceStream("/items/sword.json"));
            JsonNode shieldNode = json.parse(json.getResourceStream("/items/shield.json"));

            Item badge = json.fromJson(badgeNode, Item.class);
            Item arrows = json.fromJson(silverNode, Item.class);
            Item locker = json.fromJson(boxNode, Item.class);
            Item potion = json.fromJson(potionNode, Item.class);
            Item map = json.fromJson(mapNode, Item.class);
            Item bow = json.fromJson(bowNode, Item.class);
            Item key = json.fromJson(keyNode, Item.class);
            Item sword = json.fromJson(swordNode, Item.class);
            Item shield = json.fromJson(shieldNode, Item.class);

            gameItems.add(badge);
            gameItems.add(arrows);
            gameItems.add(locker);
            gameItems.add(potion);
            gameItems.add(map);
            gameItems.add(bow);
            gameItems.add(key);
            gameItems.add(sword);
            gameItems.add(shield);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateMap() {
        try {
            Json json = new Json();

            JsonNode gtNode = json.parse(json.getResourceStream("/locations/guardtower.json"));
            JsonNode tgNode = json.parse(json.getResourceStream("/locations/towngate.json"));
            JsonNode bsNode = json.parse(json.getResourceStream("/locations/blacksmith.json"));
            JsonNode ahNode = json.parse(json.getResourceStream("/locations/abandonedhouse.json"));
            JsonNode innNode = json.parse(json.getResourceStream("/locations/inn.json"));
            JsonNode farmNode = json.parse(json.getResourceStream("/locations/farmland.json"));
            JsonNode forestNode = json.parse(json.getResourceStream("/locations/forest.json"));
            JsonNode checkpointNode = json.parse(json.getResourceStream("/locations/checkpoint.json"));
            JsonNode dungeon1Node = json.parse(json.getResourceStream("/locations/dungeon1.json"));
            JsonNode dungeon2Node = json.parse(json.getResourceStream("/locations/dungeon2.json"));

            Location inn = json.fromJson(innNode, Location.class);
            Location blackSmith = json.fromJson(bsNode, Location.class);
            Location guardTower = json.fromJson(gtNode, Location.class);
            Location abandonedHouse = json.fromJson(ahNode, Location.class);
            Location townGate = json.fromJson(tgNode, Location.class);
            Location farmLand = json.fromJson(farmNode, Location.class);
            Location forest = json.fromJson(forestNode, Location.class);
            Location checkpoint = json.fromJson(checkpointNode, Location.class);
            Location dungeon1 = json.fromJson(dungeon1Node, Location.class);
            Location dungeon2 = json.fromJson(dungeon2Node, Location.class);

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
            // Location index: 5
            townMap.add(farmLand);
            // Location index: 6
            townMap.add(forest);
            // Location index: 7
            townMap.add(checkpoint);
            // Location index: 8
            townMap.add(dungeon1);
            // Location index: 9
            townMap.add(dungeon2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createPlayer(List<Location> map) {
        try {
            Json json = new Json();
            JsonNode playerNode = json.parse(json.getResourceStream("/characters/player.json"));

            p1 = json.fromJson(playerNode, Characters.class);
            p1.setLocation(map.get(0));
        } catch (IOException e) {
            e.printStackTrace();
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

    public void printBanner(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/resources/GameText/banner.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printIntro() {
        try {
            Json json = new Json();
            JsonNode introNode = json.parse(new File("src/main/resources/GameText/Intro.json"));
            for (JsonNode node : introNode.get("intro")) {
                System.out.println(node.fields().next().getValue().asText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    private String processSingleCommand(List<String> wordlist) {
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
                    StringBuilder inventory = new StringBuilder();

                    for (int i = 0; i < p1.getInventory().size(); i++) {
                        if (p1.getInventory().get(i).getName().equals("bow") || p1.getInventory().get(i)
                                .getName().equals("arrows")) {
                            inventory.append(i + 1).append(". ").append(p1.getInventory().get(i).getName())
                                    .append(" - ").append(p1.getInventory().get(i).getDescription())
                                    .append(" - Arrows remain: ").append(p1.getInventory()
                                            .get(i).getValue()).append("\n");
                        } else {
                            inventory.append(i + 1).append(". ").append(p1.getInventory().get(i)
                                    .getName()).append(" - ").append(p1.getInventory().get(i)
                                    .getDescription()).append("\n");
                        }
                    }

                    message = "You are in the " + p1.getLocation().getName() + ". This is the " +
                            p1.getLocation().getDescription() + ".\n" +
                            "Items available in the room: " + p1.getLocation().getItems() + "\n" +
                            "Player's current health: " + p1.getHealth() + "\n" +
                            "Player's inventory is as follow: \n" + inventory ;

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

        if (commandOne.equals("go")) {
            switch (commandTwo) {
                case "north":
                    goNorth();
                    message = "Your current location is the " + p1.getLocation().getName();
                    break;
                case "south":
                    goSouth();
                    message = "Your current location is the " + p1.getLocation().getName();
                    break;
                case "west":
                    goWest();
                    message = "Your current location is the " + p1.getLocation().getName();
                    break;
                case "east":
                    goEast();
                    message = "Your current location is the " + p1.getLocation().getName();
                    break;
                default:
                    message = "Invalid direction.";
                    break;
            }
        }

        if (commandOne.equals("get")) {

            if (commandTwo.equals("locker") && p1.getLocation().getItems().contains("locker")) {
                return "Hmmmmm. The locker is fixed to the wall, and you need a key to open it.";

            } else if (p1.getLocation().getItems().contains(commandTwo)) {
                for (Item item : gameItems) {
                    if (item.getName().equals(commandTwo)) {
                        p1.getInventory().add(item);
                        p1.getLocation().getItems().remove(commandTwo);

                        break;

                    } else {
                        message = "There is no match.";
                    }
                }
                return "You pick up the " + commandTwo + ".";
            } else {
                message = "There is no " + commandTwo + " here.";
            }
        }

        if (commandOne.equals("use")) {
            if (p1.getInventory().isEmpty()) {
                return "You have no items to use.";
            } else {
                for (Item item : p1.getInventory()) {
                    if (item.getName().equals(commandTwo)) {
                        if (commandTwo.equals("potion")) {
                            p1.setHealth(p1.getHealth() + item.getValue());
                            p1.getInventory().remove(item);
                            return "You use the potion and gain " + item.getValue() + " health.";
                        } else if (commandTwo.equals("arrows")) {
                            for (Item item2 : p1.getInventory()) {
                                if (item2.getName().equals("bow")) {
                                    item2.setValue(item2.getValue() + item.getValue());
                                    p1.getInventory().remove(item);
                                    return "You use the arrows and add them to the bow.";
                                }
                            }

                        } else if (commandTwo.equals("key") && p1.getLocation().getItems().contains("locker")) {
                            System.out.println("WoW! It is an armor that can protect you from the monsters!");

                        } else if (commandTwo.equals("map")) {
                            for (Location location : townMap) {
                                System.out.println(location.getName());
                            }
                            break;

                        } else if (commandTwo.equals("sword") || commandTwo.equals("bow")) {
                            return "You can only use the sword or the bow during combat.";

                        } else if (commandTwo.equals("shield")) {
                            p1.setShield(p1.getShield() + item.getValue());
                            p1.getInventory().remove(item);

                        } else {
                            return "You cannot use that item.";
                        }
                    } else {
                        message = "You do not have that item.";
                    }
                }
            }
        }

        if (commandOne.equals("drop")) {
            if (p1.getInventory().isEmpty()) {
                return "There is nothing to drop.";
            } else {
                for (Item item : p1.getInventory()) {
                    if (item.getName().equals(commandTwo)) {
                        p1.getLocation().getItems().add(commandTwo);
                        p1.getInventory().remove(item);
                        return "You drop the " + commandTwo + ".";
                    } else {
                        message = "You do not have that item.";
                    }
                }
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

    private void goNorth() {
        movePlayerTo(Direction.NORTH);
    }

    private void goSouth() {
        movePlayerTo(Direction.SOUTH);
    }

    private void goWest() {
        movePlayerTo(Direction.WEST);
    }

    private void goEast() {
        movePlayerTo(Direction.EAST);
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

}
