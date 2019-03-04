package com.github.arkadiuss2.cavetravel.domain.character;

import com.github.arkadiuss2.cavetravel.domain.character.powers.BarValue;
import com.github.arkadiuss2.cavetravel.domain.character.skill.Strength;

public interface CharacterI {

    BarValue getHp();

    void setHp(BarValue hp);

    BarValue getMp();

    void setMp(BarValue mp);

    Strength getStrength();

    void setStrength(Strength strength);

    BarValue getLevel();

    void setLevel(BarValue level);

    BarValue getExperience();

    void setExperience(BarValue experience);
}
