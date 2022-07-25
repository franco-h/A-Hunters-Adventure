package com.huntersadventure.game;

import com.fasterxml.jackson.databind.JsonNode;
import com.huntersadventure.gameobjects.Location;
import com.huntersadventure.jsonparser.Json;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Character Controller not yet in use. Below contains just an example.
 */

public class GameController {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

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

    public void startGame() throws IOException {
        System.out.println("Welcome to the game!");
        // run help() to get a list of commands
        help();
        String input;
        String output;

        // Prompt for input until the user enters "quit". If the user enters quit, the game will exit.
        do {
            System.out.println("Enter a command below.");
            System.out.println(">");
            input = in.readLine();
            output = runCommand(input);
            System.out.println(output);
        } while (!(input = in.readLine()).equals("quit"));
    }

    private void help() {
        System.out.println("Here are the basic commands:");
        System.out.println("go [direction] - move in the specified direction");
        System.out.println("look - Read the description of the current room and the items available");
        System.out.println("get [item] - pick up the specified item");
        System.out.println("help - display commands available");
        System.out.println("quit - exit the game and return to menu");
        System.out.println("-----------------------------------------------------");
    }

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

    private String parseCommand(List<String> wordlist) throws IOException {
        String message;
        if (wordlist.size () == 1) {
            message = processSingleCommand(wordlist);
        } else if (wordlist .size () == 2) {
            message = processTwoCommand(wordlist);
        } else {
            message = "Invalid command.";
        }
        return message;
    }

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
                    // Back to Main.java
                    GameLogic.startPrompt();
                    break;
                case "look":
                    // TODO: Read description of the room and items available.
                    message = "look()";
                    break;
                default:
                    message = commandOne + " (not yet implemented)";
                    break;
            }
        }
        return message;
    }

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
                return "You go north.";
            } else if (commandTwo.equals("south")) {
                return "You go south.";
            } else if (commandTwo.equals("west")) {
                return "You go west.";
            } else if (commandTwo.equals("east")) {
                return "You go east.";
            } else {
                message = "Invalid direction.";
            }
        }

        // TODO: Implement player's function to get or use items
        if (commandOne.equals("get")) {
            if (items.contains(commandTwo)) {
                return "You pick up the " + commandTwo + ".";
            } else {
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
}

//    List<Location> map = new ArrayList<>();
//
//    public void generateMap() throws IOException {
//        JsonNode gtNode = Json.parse(new File("lib/locations/guardtower.json"));
//        JsonNode tgNode = Json.parse(new File("lib/locations/towngate.json"));
//        JsonNode bsNode = Json.parse(new File("lib/locations/blacksmith.json"));
//        JsonNode ahNode = Json.parse(new File("lib/locations/abandonedhouse.json"));
//
//        Location guardTower = Json.fromJson(gtNode, Location.class);
//        Location blackSmith = Json.fromJson(bsNode, Location.class);
//        Location abandonedHouse = Json.fromJson(ahNode, Location.class);
//        Location townGate = Json.fromJson(tgNode, Location.class);
//
//        map.add(townGate);
//        map.add(blackSmith);
//        map.add(guardTower);
//        map.add(abandonedHouse);
//    }
