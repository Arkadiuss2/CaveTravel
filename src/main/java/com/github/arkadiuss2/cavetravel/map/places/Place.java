package com.github.arkadiuss2.cavetravel.map.places;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;

import java.util.List;

public interface Place {

    String getDescription();

    List<CharacterI> getCharacters();

    void addCharacter(CharacterI player);

    void removeCharacter(CharacterI character);
}
