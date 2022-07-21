package com.huntersadventure.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.huntersadventure.jsonparser.Json;
import com.huntersadventure.model.Character;
import com.huntersadventure.model.Location;
import com.huntersadventure.model.Monster;
import com.huntersadventure.model.Player;

import java.io.File;
import java.io.IOException;

public class CharacterController {
    public static void main(String[] args) {

        try {
            JsonNode node = Json.parse(new File("lib/locations/guardtower.json"));
            Location location = Json.fromJson(node,
                    Location.class);

            System.out.println(location);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
