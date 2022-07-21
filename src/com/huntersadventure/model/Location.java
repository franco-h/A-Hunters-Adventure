package com.huntersadventure.model;

import java.util.List;
import java.util.Objects;

public class Location {

    String name;
    String description;
    List<String> items;

    public Location() {
    }

    public Location(String name, String description, List<String> items) {
        this.name = name;
        this.description = description;
        this.items = items;
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

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getName(), location.getName()) && Objects.equals(getDescription(), location.getDescription()) && Objects.equals(getItems(), location.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getItems());
    }
}
