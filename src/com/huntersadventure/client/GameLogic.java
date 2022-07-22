package src.com.huntersadventure.client;

import java.util.Scanner;


/*
 /
 / HELPER METHODS AND BASIC BEGINNING GAME LOGIC
 /
 */
public class GameLogic {

    static Scanner scanner = new Scanner(System.in);

    public static void clearCons() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    public static void printBreak(int n) {
        for (int i = 0; i < n; i++)
            System.out.println("-");
        System.out.println();
    }

    public static void inputToCont() {
        System.out.println("Press Any Key to Continue");
        scanner.next();
    }

    public static void startPrompt(){
        System.out.print("View story introduction? y/n \n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equals("yes") || choice.equals("YES") || choice.equals("y") || choice.equals("Y")) {
            clearCons();
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
        } else if(choice.equals("no") || choice.equals("NO") || choice.equals("n") || choice.equals("N")) {
            startGame();
        } else if(choice.equalsIgnoreCase("q") || choice.equalsIgnoreCase("quit")) {
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



    public static void startGame(){
        System.out.println("Do you wish to start the game? y/n");
        String ans = scanner.nextLine();
        if(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")) {
            System.out.println("placeholder text to confirm output");
        } else if (ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")) {
            System.out.println("the game will end now!");
            System.exit(0);
        }
    }

    public static void quitGame(){
        System.out.println("Do you wish to quit the game? y/n");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
            System.out.println("the game will end now!");
            System.exit(0);
        } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
            System.out.println("return placeholder");
        }
    }


}
