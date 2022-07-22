package com.huntersadventure.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.huntersadventure.jsonparser.Json;
import com.huntersadventure.model.*;
import com.huntersadventure.model.Character;

import java.io.File;
import java.io.IOException;

/**
 * Character Controller not yet in use. Below contains just an example.
 */

public class CharacterController {
    public static void main(String[] args) {

        try {
            JsonNode gtNode = Json.parse(new File("lib/locations/guardtower.json"));
            JsonNode bsNode = Json.parse(new File("lib/locations/blacksmith.json"));
            JsonNode ahNode = Json.parse(new File("lib/locations/abandonedhouse.json"));

            Location guardTower = Json.fromJson(gtNode, Location.class);
            Location blackSmith = Json.fromJson(bsNode, Location.class);
            Location abandonedHouse = Json.fromJson(ahNode, Location.class);

            JsonNode playerNode = Json.parse(new File("lib/characters/player.json"));
            Player player = Json.fromJson(playerNode, Player.class);

            System.out.println(guardTower);
            System.out.println(player);
            player.setLocation(guardTower);

            String gtItem = guardTower.getItems().get(1);
            System.out.println(gtItem);


            player.getInventory().add(gtItem);
            if (player.getInventory().contains(gtItem)) {
                guardTower.getItems().remove(1);
            }
            System.out.println();
            System.out.println(guardTower);
            System.out.println(blackSmith);
            System.out.println(abandonedHouse);
            System.out.println();
            System.out.println(player);
            System.out.println(player.getLocation());




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
