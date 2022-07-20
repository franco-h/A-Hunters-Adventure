package com.huntersadventure.model.item;

public class Item {
    /*
    Item is a superclass that is used to create subclasses of items.
    - It has the following attributes
    - String name;
    - String description;
     */
    String name;
    String description;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}