package com.huntersadventure.client;

import com.huntersadventure.controller.CharacterController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/*
 /
 / HELPER METHODS AND BASIC BEGINNING GAME LOGIC
 /
 */
public class GameLogic {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void startPrompt() throws IOException {
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
            startGame();
        } else if (input.equals("n")) {
            startGame();
        } else {
            System.out.println("Invalid input. Please try again.");
            startPrompt();
        }
    }

    public static void startGame() throws IOException {
        System.out.println("Do you wish to start the game? y/n");
        CharacterController controller = new CharacterController();

        String input = in.readLine();
        if (input.equals("y")) {
            controller.startGame();
        } else if (input.equals("n")) {
            System.out.println("Thank you for playing!");
            System.exit(0);
        } else {
            System.out.println("Invalid input. Please try again.");
            startGame();
        }
    }

    public static void quitGame() throws IOException {
        System.out.println("Do you wish to quit the game? y/n");
        String input = in.readLine();
        if (input.equals("y")) {
            System.out.println("Thank you for playing!");
            System.exit(0);
        } else if (input.equals("n")) {
            startGame();
        } else {
            System.out.println("Invalid input. Please try again.");
            quitGame();
        }
    }

    public static void welcomeBanner(){
        System.out.println("                                                                                                                                                                                   \n" +
                " @@@@@@      @@@  @@@  @@@  @@@  @@@  @@@  @@@@@@@  @@@@@@@@  @@@@@@@   @@@   @@@@@@       @@@@@@   @@@@@@@   @@@  @@@  @@@@@@@@  @@@  @@@  @@@@@@@  @@@  @@@  @@@@@@@   @@@@@@@@  \n" +
                "@@@@@@@@     @@@  @@@  @@@  @@@  @@@@ @@@  @@@@@@@  @@@@@@@@  @@@@@@@@   @@  @@@@@@@      @@@@@@@@  @@@@@@@@  @@@  @@@  @@@@@@@@  @@@@ @@@  @@@@@@@  @@@  @@@  @@@@@@@@  @@@@@@@@  \n" +
                "@@!  @@@     @@!  @@@  @@!  @@@  @@!@!@@@    @@!    @@!       @@!  @@@  @!   !@@          @@!  @@@  @@!  @@@  @@!  @@@  @@!       @@!@!@@@    @@!    @@!  @@@  @@!  @@@  @@!       \n" +
                "!@!  @!@     !@!  @!@  !@!  @!@  !@!!@!@!    !@!    !@!       !@!  @!@       !@!          !@!  @!@  !@!  @!@  !@!  @!@  !@!       !@!!@!@!    !@!    !@!  @!@  !@!  @!@  !@!       \n" +
                "@!@!@!@!     @!@!@!@!  @!@  !@!  @!@ !!@!    @!!    @!!!:!    @!@!!@!        !!@@!!       @!@!@!@!  @!@  !@!  @!@  !@!  @!!!:!    @!@ !!@!    @!!    @!@  !@!  @!@!!@!   @!!!:!    \n" +
                "!!!@!!!!     !!!@!!!!  !@!  !!!  !@!  !!!    !!!    !!!!!:    !!@!@!          !!@!!!      !!!@!!!!  !@!  !!!  !@!  !!!  !!!!!:    !@!  !!!    !!!    !@!  !!!  !!@!@!    !!!!!:    \n" +
                "!!:  !!!     !!:  !!!  !!:  !!!  !!:  !!!    !!:    !!:       !!: :!!             !:!     !!:  !!!  !!:  !!!  :!:  !!:  !!:       !!:  !!!    !!:    !!:  !!!  !!: :!!   !!:       \n" +
                ":!:  !:!     :!:  !:!  :!:  !:!  :!:  !:!    :!:    :!:       :!:  !:!           !:!      :!:  !:!  :!:  !:!   ::!!:!   :!:       :!:  !:!    :!:    :!:  !:!  :!:  !:!  :!:       \n" +
                "::   :::     ::   :::  ::::: ::   ::   ::     ::     :: ::::  ::   :::       :::: ::      ::   :::   :::: ::    ::::     :: ::::   ::   ::     ::    ::::: ::  ::   :::   :: ::::  \n" +
                " :   : :      :   : :   : :  :   ::    :      :     : :: ::    :   : :       :: : :        :   : :  :: :  :      :      : :: ::   ::    :      :      : :  :    :   : :  : :: ::   \n" +
                "                                                                                                                                                                                   ");
    }

    public static void clearCons() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    public static void printBreak(int n) {
        for (int i = 0; i < n; i++)
            System.out.println("-");
        System.out.println();
    }
}
