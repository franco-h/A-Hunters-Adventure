package com.huntersadventure.client;

import com.huntersadventure.controller.GameLogic;

import java.io.IOException;

public class Main extends GameLogic {
    public static void main(String[] args) {
        welcomeBanner();  //ASCII art will be read in from text when resources folder is created

        try {
            startPrompt();  //Start prompt is very basic right now, not final version
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
