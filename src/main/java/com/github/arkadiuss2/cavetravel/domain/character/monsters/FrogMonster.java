package com.github.arkadiuss2.cavetravel.domain.character.monsters;

import com.github.arkadiuss2.cavetravel.domain.character.BasicCharacter;

public class FrogMonster extends BasicCharacter {

    @Override
    public String getName() {
        return "Frog Monster";
    }

    @Override
    public String toString() {
        return getName();
    }

}
