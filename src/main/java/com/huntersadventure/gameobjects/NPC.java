package com.huntersadventure.gameobjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.huntersadventure.game.GameController;
import com.huntersadventure.jsonparser.Json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.huntersadventure.game.GameController.*;

public class NPC extends Characters {

    static Random r = new Random();
    private static boolean wasPrinted = false;


    public static void initBlacksmith() {
        try {
            ArrayList<String> dialogue = new ArrayList<>();
            dialogue.add("\"What is it?\"");
            dialogue.add("\"Don't suppose you're here to deal with the local pest problem are you?\"");
            dialogue.add("\"I'm sure you'd love a weapon wouldn't you Hunter? Too bad.\"");
            dialogue.add("\"Afraid the Town Guard has all of my wares reserved, Hunter. Perhaps you can get them to grant you access somehow.\"");

            Json json = new Json();
            int randomItem = r.nextInt(dialogue.size());
            String randomElement = dialogue.get(randomItem);
            JsonNode bsNode = json.parse(new File("src/main/resources/characters/blacksmith.json"));

            if (!wasPrinted) {
                String desc = bsNode.get("desc").textValue();
                System.out.println(desc);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("\"Due to the recent string of attacks, my sales have gone up tremendously. Unfortunately for you, all I have are these " + cyan + "arrows" + ANSI_RESET + " for now.\"");
                TimeUnit.MILLISECONDS.sleep(750);
                wasPrinted = true;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("The blacksmith strikes his anvil once again.\n" + randomElement);
                TimeUnit.MILLISECONDS.sleep(750);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initGuard() {
        try {
            ArrayList<String> dialogue = new ArrayList<>();
            dialogue.add("\"If you keep loitering here I'll make sure to have you arrested.\"");
            dialogue.add("\"Here to get yourself killed are you? \"");
            dialogue.add("\"Never did respect you Hunter types. Not that any of your kind have ever been able to earn it. \"");
            dialogue.add("\"My family was attacked when I was younger. Hunter's Guild didn't send anyone out till it was already over. Sickening.\"");
            dialogue.add("\"For the last time. Piss off.\"" + " The guard spits at you.");

            Json json = new Json();
            int randomItem = r.nextInt(dialogue.size());
            String randomElement = dialogue.get(randomItem);
            JsonNode bsNode = json.parse(new File("src/main/resources/characters/guard1.json"));

            if (!wasPrinted) {
                String desc = bsNode.get("desc").textValue();
                System.out.println(desc);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Nobody gets in or out of here without a " + cyan + "Badge" + ANSI_RESET +" Hunter. YOUR kind included.\"" + "he growls.");
                TimeUnit.MILLISECONDS.sleep(750);
                wasPrinted = true;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("The guard scowls. \n" + randomElement);
                TimeUnit.MILLISECONDS.sleep(750);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initRanger() {
        try {
            ArrayList<String> dialogue = new ArrayList<>();
            dialogue.add("\"It sickens me what's happened here. If only we got here sooner...\"");
            dialogue.add("\"This creature is the stuff of nightmares. We've never faced anything like this.\"");
            dialogue.add("\"I can't believe our town was finally attacked. We've had peace for so many years. \"");
            dialogue.add("\"Whatever this creature is, it must pay for what its done.\"");
            dialogue.add("\"Thank you for your assistance here, Hunter.\"");

            Json json = new Json();
            int randomItem = r.nextInt(dialogue.size());
            String randomElement = dialogue.get(randomItem);
            JsonNode bsNode = json.parse(new File("src/main/resources/characters/guard2.json"));

            if (!wasPrinted) {
                String desc = bsNode.get("desc").textValue();
                System.out.println(desc);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("\"Ahh a Hunter! Perfect timing. We're stretched thin while we investigate this attack, but there's an  " + yellow + "Abandoned Checkpoint" + ANSI_RESET +"\nwe need to retake down the way on the other path from a local bandit. Perhaps you can help us out?\"" + "he asks.");
                TimeUnit.MILLISECONDS.sleep(750);
                wasPrinted = true;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(randomElement);
                TimeUnit.MILLISECONDS.sleep(750);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initBandit(){
        try {
            ArrayList<String> dialogue = new ArrayList<>();
            dialogue.add("\"I've always wondered how much coin your lot carries around on you. I guess I'll have to kill you to find out for myself!\"" + "The bandit cackles.");
            dialogue.add("\"I imagine you must think you're pretty tough, but I promise you've never faced anyone like me\"");
            dialogue.add("\"Imagine that, a monster providing the perfect distraction for me to terrorize this little area. What luck!\"");
            dialogue.add("\"That's some worthwhile armor you have there Hunter. I may need to take it from your cold dead body for myself.\"");
            dialogue.add("\"Are you going to draw your weapon or stand there?\"");

            Json json = new Json();
            int randomItem = r.nextInt(dialogue.size());
            String randomElement = dialogue.get(randomItem);
            JsonNode bsNode = json.parse(new File("src/main/resources/characters/miniboss1.json"));

            if (!wasPrinted) {
                String desc = bsNode.get("desc").textValue();
                System.out.println(desc);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("\"Oh, a HUNTER! I don't suppose we could let this one slide could we? I hear there is some worthwhile treasure around here we could split...\"");
                TimeUnit.MILLISECONDS.sleep(750);
                dialogue.remove(0);
                wasPrinted = true;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(randomElement);
                TimeUnit.MILLISECONDS.sleep(750);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initFaceless(){
        try {
            Json json = new Json();
            JsonNode bsNode = json.parse(new File("src/main/resources/characters/miniboss2.json"));

            if (!wasPrinted) {
                String desc = bsNode.get("desc").textValue();
                System.out.println(desc);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("The creature raises it's great-axe, clearly willing to kill you regardless of its' own agony. It's time to put an end to it's suffering.");
                TimeUnit.MILLISECONDS.sleep(750);
                wasPrinted = true;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("There is no use trying to speak to it. It cannot respond.");
                TimeUnit.MILLISECONDS.sleep(750);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initManEater(){
        try {
            ArrayList<String> dialogue = new ArrayList<>();
            dialogue.add("The beast flails around violently, as if tormented by an invisible force. Dust and debris fill the air. It's wild attacks seemingly have no pattern to them.");
            dialogue.add("The beast narrows its eyes at you. It readies itself for a vicious attack!");


            Json json = new Json();
            int randomItem = r.nextInt(dialogue.size());
            String randomElement = dialogue.get(randomItem);
            JsonNode bsNode = json.parse(new File("src/main/resources/characters/finalboss.json"));

            if (!wasPrinted) {
                String desc = bsNode.get("desc").textValue();
                System.out.println(desc);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("The beast howls with rage upon seeing you. Among the echo you can almost hear the trail of a faint scream that sounds strangely human.");
                TimeUnit.MILLISECONDS.sleep(750);
                dialogue.remove(0);
                wasPrinted = true;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(randomElement);
                TimeUnit.MILLISECONDS.sleep(750);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}











