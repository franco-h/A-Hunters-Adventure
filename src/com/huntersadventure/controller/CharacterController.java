package com.huntersadventure.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.huntersadventure.jsonparser.Json;
import com.huntersadventure.model.Character;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Character Controller not yet in use. Below contains just an example.
 */

public class CharacterController {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void startGame() throws IOException {
        System.out.println("Welcome to the game!");
        // run help() to get a list of commands
        help();
        String input;
        String output;

        // Prompt for input until the user enters "quit". If the user enters quit, the game will exit.
        System.out.println("Enter a command below.");
        while (!(input = in.readLine()).equals("quit")) {
            System.out.println("Enter a command below.");
            System.out.println(">");
            input = in.readLine();
            output = runCommand(input);
            System.out.println(output);
        }
    }

    private void help() {
        System.out.println("Here are the basic commands:");
        System.out.println("go [direction] - move in the specified direction");
        System.out.println("look - Read the description of the current room and the items available");
        System.out.println("get [item] - pick up the specified item");
        System.out.println("help - display commands available");
        System.out.println("quit - exit the game");
        System.out.println("-----------------------------------------------------");
    }

    public String runCommand(String inputstr) {
        return "not yet implemented";
    }

    private String parseCommand(List<String> wordlist) {
        return "not yet implemented";
    }


//        try {
//            JsonNode gtNode = Json.parse(new File("lib/locations/guardtower.json"));
//            JsonNode bsNode = Json.parse(new File("lib/locations/blacksmith.json"));
//            JsonNode ahNode = Json.parse(new File("lib/locations/abandonedhouse.json"));
//
//            Location guardTower = Json.fromJson(gtNode, Location.class);
//            Location blackSmith = Json.fromJson(bsNode, Location.class);
//            Location abandonedHouse = Json.fromJson(ahNode, Location.class);
//
//            JsonNode playerNode = Json.parse(new File("lib/characters/player.json"));
//            Player player = Json.fromJson(playerNode, Player.class);
//
//            System.out.println(guardTower);
//            System.out.println(player);
//            player.setLocation(guardTower);
//
//            String gtItem = guardTower.getItems().get(1);
//            System.out.println(gtItem);
//
//
//            player.getInventory().add(gtItem);
//            if (player.getInventory().contains(gtItem)) {
//                guardTower.getItems().remove(1);
//            }
//            System.out.println();
//            System.out.println(guardTower);
//            System.out.println(blackSmith);
//            System.out.println(abandonedHouse);
//            System.out.println();
//            System.out.println(player);
//            System.out.println(player.getLocation());
//
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
}
