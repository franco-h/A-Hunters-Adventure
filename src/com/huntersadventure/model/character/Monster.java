package com.huntersadventure.model.character;

import java.util.Objects;

public class Monster extends Character {
    // Extend Character class
    // Add the following attributes:
    // - Int health;
    // - Int damage;
    // - Int shield;

    private int health;
    private int damage;
    private int shield;

    public Monster() {
    }

    public Monster(String name, int health, int damage, int shield) {
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
        return "Monster{" +
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
        Monster monster = (Monster) o;
        return getHealth() == monster.getHealth() && getDamage() == monster.getDamage() && getShield() == monster.getShield();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHealth(), getDamage(), getShield());
    }
}