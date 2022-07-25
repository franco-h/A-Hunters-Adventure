package com.huntersadventure.gameobjects;

public class Prop {

    String name;
    String description;

    public Prop() {
    }

    public Prop(String name) {
        this.name = name;
    }

    public Prop(String name, String description) {
        this.name = name;
        this.description = description;
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


}
