package com.github.arkadiuss2.cavetravel.engine;

import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;

public class CharacterGenerator {

    public static PlayerCharacter generatePlayer(String name) {
        return new PlayerCharacter(name);
    }
}
