package com.huntersadventure.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player extends Character {

    private int health;
    private int damage;
    private int shield;
    private List<String> inventory;
    private Location location;

    public Player() {
    }

    public Player(String name, int health, int damage, int shield, List<String> inventory, Location location) {
        super(name);
        this.health = health;
        this.damage = damage;
        this.shield = shield;
        this.inventory = inventory;
        this.location = location;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", shield=" + shield +
                ", inventory=" + inventory +
                ", location=" + location +
                '}';
    }

}
