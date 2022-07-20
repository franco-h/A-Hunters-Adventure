package com.huntersadventure.model.character;

public class Character {
    /*
    Character is a superclass that is used to create subclasses of each character.
    - It has the following attributes
    - String name;
     */
    String name;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
