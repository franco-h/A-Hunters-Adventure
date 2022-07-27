package com.huntersadventure.gameobjects;

import java.util.List;

public class Location extends Prop {

    private List<String> items;
    private int north;
    private int south;
    private int west;
    private int east;

    public Location() {
    }

    public Location(String name, String description, List<String> items, int north, int south, int west, int east) {
        super(name, description);
        this.items = items;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public int getNorth() {
        return north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getSouth() {
        return south;
    }

    public void setSouth(int south) {
        this.south = south;
    }

    public int getWest() {
        return west;
    }

    public void setWest(int west) {
        this.west = west;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
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
