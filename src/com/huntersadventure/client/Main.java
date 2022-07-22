package com.huntersadventure.client;

import java.io.IOException;

public class Main extends GameLogic{
    public static void main(String[] args) throws IOException {
        welcomeBanner();  //ASCII art will be read in from text when resources folder is created
        startPrompt();  //Start prompt is very basic right now, not final version
    }
}
