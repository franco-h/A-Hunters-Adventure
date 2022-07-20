package com.huntersadventure.model.character;

import java.util.ArrayList;
import java.util.Objects;

public class Player<Item> extends Character {
    // Extend Character class
    // Add the following attributes:
    // - Int health;
    // - Int damage;
    // - Int shield;
    // - ArrayList<Item> inventory;

    private int health;
    private int damage;
    private int shield;
    private ArrayList<Item> inventory;

    // No-arg constructor
    public Player() {
    }

    public Player(String name, int health, int damage, int shield) {
        super(name);
        this.health = health;
        this.damage = damage;
        this.shield = shield;
        this.inventory = new ArrayList<Item>();
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

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player<?> player = (Player<?>) o;
        return getHealth() == player.getHealth() && getDamage() == player.getDamage() && getShield() == player.getShield() && Objects.equals(getInventory(), player.getInventory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHealth(), getDamage(), getShield(), getInventory());
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", shield=" + shield +
                ", inventory=" + inventory +
                '}';
    }
}