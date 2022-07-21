package com.huntersadventure.model;

import java.util.List;
import java.util.Objects;

public class Location {
    /*
    - It has the following attributes
    - String name;
    - String description;
    - Item item;
    - Object exit;
     */
    String name;
    String description;
    List<String> items;
    Object exit;

    public Location() {
    }

    public Location(String name, String description, List<String> items, Object exit) {
        this.name = name;
        this.description = description;
        this.items = items;
        this.exit = exit;
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

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Object getExit() {
        return exit;
    }

    public void setExit(Object exit) {
        this.exit = exit;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                ", exit=" + exit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getName(), location.getName()) && Objects.equals(getDescription(), location.getDescription()) && Objects.equals(items, location.items) && Objects.equals(getExit(), location.getExit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), items, getExit());
    }
}
