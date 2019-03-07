package com.github.arkadiuss2.cavetravel.domain.character;

import com.github.arkadiuss2.cavetravel.domain.character.powers.BarValue;
import com.github.arkadiuss2.cavetravel.domain.character.powers.HealthPowerValue;
import com.github.arkadiuss2.cavetravel.domain.character.skill.Strength;

import java.util.List;
import java.util.Optional;

public interface CharacterI {

    String getName();

    HealthPowerValue getHp();

    void setHp(HealthPowerValue hp);

    BarValue getMp();

    void setMp(BarValue mp);

    Strength getStrength();

    void setStrength(Strength strength);

    BarValue getLevel();

    void setLevel(BarValue level);

    BarValue getExperience();

    void setExperience(BarValue experience);


}
