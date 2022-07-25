package com.huntersadventure.gameobjects;

import java.util.List;

public class Location extends Prop {

    List<String> items;

    public Location() {
    }

    public Location(String name, String description, List<String> items) {
        super(name, description);
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Location: " +
                "name='" + name +
                ", items=" + items +'\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
