package com.huntersadventure.gameobjects;

import java.util.List;

public class Characters extends Prop{

    private int health;
    private int damage;
    private int shield;
    private List<String> inventory;
    private Location location;

    public Characters() {
    }

    // NPC Constructor
    public Characters(String name, String description, List<String> inventory, Location location) {
        super(name, description);
        this.inventory = inventory;
        this.location = location;
    }
    // Player Constructor
    public Characters(String name, int health, int damage, int shield, List<String> inventory, Location location) {
        super(name);
        this.health = health;
        this.damage = damage;
        this.shield = shield;
        this.inventory = inventory;
        this.location = location;
    }

    // Enemy Constructor
    public Characters(String name, String description, int health, int damage, int shield, Location location) {
        super(name, description);
        this.health = health;
        this.damage = damage;
        this.shield = shield;
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
        final StringBuffer sb = new StringBuffer("Characters: ");
        sb.append(" name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", health=").append(health);
        sb.append(", damage=").append(damage);
        sb.append(", shield=").append(shield);
        sb.append(", inventory=").append(inventory);
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}
