package com.github.arkadiuss2.cavetravel.engine;

import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;

public class CharacterGenerator {

    public static PlayerCharacter generatePlayer(String name) {
        PlayerCharacter playerCharacter = new PlayerCharacter(name);
        playerCharacter.getStrength().setValue(50);
        playerCharacter.getHp().setMaxValue(200);
        playerCharacter.getHp().setCurrentValue(200);
        return playerCharacter;
    }
}
