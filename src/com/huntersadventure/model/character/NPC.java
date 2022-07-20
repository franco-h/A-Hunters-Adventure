package com.huntersadventure.model.character;

import com.huntersadventure.model.item.Item;

import java.util.ArrayList;
import java.util.Objects;

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