package com.huntersadventure.model;

import java.util.ArrayList;
import java.util.Objects;

public class Player extends Character {

    private int health;
    private int damage;
    private int shield;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player() {
    }

    public Player(String name, int health, int damage, int shield) {
        super(name);
        this.health = health;
        this.damage = damage;
        this.shield = shield;
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", shield=" + shield +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getHealth() == player.getHealth() && getDamage() == player.getDamage() && getShield() == player.getShield();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHealth(), getDamage(), getShield());
    }
}
