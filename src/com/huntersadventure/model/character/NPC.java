package com.huntersadventure.model.character;

import java.util.ArrayList;
import java.util.Objects;

// Extend Character class
public class NPC<Item> extends Character {
    private ArrayList<Item> questItem;
    // Extend Character class
    // Add the following attributes:
    // - Item questitem;


    public NPC() {
    }

    public NPC(String name, Item questItem) {
        super(name);
        this.questItem = new ArrayList<Item>();
    }

    public ArrayList<Item> getQuestItem() {
        return questItem;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                ", questItem=" + questItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC<?> npc = (NPC<?>) o;
        return Objects.equals(getQuestItem(), npc.getQuestItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestItem());
    }
}