package com.github.arkadiuss2.cavetravel.domain.character;

public class PlayerCharacter extends BasicCharacter {

    private String name;

    public PlayerCharacter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wanderer " + getName();
    }
}

