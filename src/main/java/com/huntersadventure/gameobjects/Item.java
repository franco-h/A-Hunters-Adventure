package com.huntersadventure.gameobjects;

public class Item extends Prop {

    private int value;

    public Item() {
    }

    // Regular Item
    public Item(String name, String description) {
        super(name, description);
    }

    // Item with damage or cost value
    public Item(String name, String description, int value) {
        super(name, description);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
