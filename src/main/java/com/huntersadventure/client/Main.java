package com.huntersadventure.client;

import com.huntersadventure.game.GameController;
import com.huntersadventure.game.TestController;

import java.io.IOException;

// Main Class should not extend another class.
public class Main {
    public static void main(String[] args) {

        try {
            GameController gameController = new GameController();
            gameController.run();
//            TestController testController = new TestController();
//
//            testController.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
