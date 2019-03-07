package com.github.arkadiuss2.cavetravel.domain.places.scary;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.domain.character.monsters.FrogMonster;
import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

import java.util.ArrayList;
import java.util.List;

public class ScaryPlace implements Place {

    private List<CharacterI> characters = new ArrayList<>();

    public ScaryPlace() {
        addCharacter(new FrogMonster());
//        addCharacter(new FrogMonster());
    }

    @Override
    public String getDescription() {
        return "Scary Place.";
    }

    @Override
    public List<CharacterI> getCharacters() {
        return characters;
    }

    @Override
    public void addCharacter(CharacterI character) {
        characters.add(character);
    }

    @Override
    public void removeCharacter(CharacterI character) {
        characters.remove(character);
    }

}
