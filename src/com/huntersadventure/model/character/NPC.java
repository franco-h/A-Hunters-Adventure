package com.huntersadventure.model.character;

import java.util.ArrayList;
import java.util.Objects;

public class NPC extends Character {

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