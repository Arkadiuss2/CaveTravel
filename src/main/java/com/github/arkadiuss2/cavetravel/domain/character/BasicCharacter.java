package com.github.arkadiuss2.cavetravel.domain.character;

import com.github.arkadiuss2.cavetravel.domain.character.powers.BarValue;
import com.github.arkadiuss2.cavetravel.domain.character.powers.DefaultBarValue;
import com.github.arkadiuss2.cavetravel.domain.character.powers.HealthPowerValue;
import com.github.arkadiuss2.cavetravel.domain.character.skill.Strength;

public abstract class BasicCharacter implements CharacterI {

    private HealthPowerValue hp;
    private BarValue mp = new DefaultBarValue();
    private Strength strength = new Strength();
    private BarValue level = new DefaultBarValue();
    private BarValue experience = new DefaultBarValue();


    public BasicCharacter() {
        prepareDefaultValues();
    }

    public void prepareDefaultValues() {
        setHp(new HealthPowerValue(100, 100));
        setMp(new DefaultBarValue(100, 100));

        Strength strength = new Strength();
        strength.setValue(5);
        setStrength(strength);
    }

    @Override
    public HealthPowerValue getHp() {
        return hp;
    }

    @Override
    public void setHp(HealthPowerValue hp) {
        this.hp = hp;
    }

    @Override
    public BarValue getMp() {
        return mp;
    }

    @Override
    public void setMp(BarValue mp) {
        this.mp = mp;
    }

    @Override
    public Strength getStrength() {
        return strength;
    }

    @Override
    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    @Override
    public BarValue getLevel() {
        return level;
    }

    @Override
    public void setLevel(BarValue level) {
        this.level = level;
    }

    @Override
    public BarValue getExperience() {
        return experience;
    }

    @Override
    public void setExperience(BarValue experience) {
        this.experience = experience;
    }
}
