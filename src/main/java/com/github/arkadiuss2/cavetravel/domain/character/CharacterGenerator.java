package com.github.arkadiuss2.cavetravel.domain.character;

import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;

public class CharacterGenerator {

    public static PlayerCharacter generatePlayer(String name) {
        PlayerCharacter playerCharacter = new PlayerCharacter(name);
        playerCharacter.getStrength().setValue(50);
        playerCharacter.getHp().setMaxValue(50);
        playerCharacter.getHp().setCurrentValue(50);
        return playerCharacter;
    }
}
