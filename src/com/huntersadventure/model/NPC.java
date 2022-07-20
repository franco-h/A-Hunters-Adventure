package com.huntersadventure.model;

import java.util.ArrayList;

public class NPC extends Character {

    private ArrayList<Item> questItem;

    public NPC() {
    }

    public NPC(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                '}';
    }
}
