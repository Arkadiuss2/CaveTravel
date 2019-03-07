package com.github.arkadiuss2.cavetravel.engine.map.places;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;

import java.util.List;

public interface Place {

    String getDescription();

    List<CharacterI> getCharacters();

    void addCharacter(CharacterI player);

    void removeCharacter(CharacterI character);
//
//    List<Command> getAvailableMoves();
//
//    default Optional<CharacterI> getPlayer(List<CharacterI> characters) {
//        return characters.stream().filter(characterI -> characterI instanceof PlayerCharacter).findFirst();
//    }

}
