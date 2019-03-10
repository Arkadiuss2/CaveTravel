package com.github.arkadiuss2.cavetravel.domain.character;

import com.github.arkadiuss2.cavetravel.domain.character.powers.BarValue;
import com.github.arkadiuss2.cavetravel.domain.character.powers.DefaultBarValue;
import com.github.arkadiuss2.cavetravel.domain.character.powers.HealthPowerValue;
import com.github.arkadiuss2.cavetravel.domain.character.skill.Strength;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BasicCharacter implements CharacterI {

    private HealthPowerValue hp;

    @XmlElement(type = DefaultBarValue.class)
    private BarValue mp = new DefaultBarValue();

    private Strength strength = new Strength();

    @XmlElement(type = DefaultBarValue.class)
    private BarValue level = new DefaultBarValue(100,1);

    @XmlElement(type = DefaultBarValue.class)
    private BarValue experience = new DefaultBarValue(1000,0);


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicCharacter that = (BasicCharacter) o;
        return Objects.equals(hp, that.hp) &&
                Objects.equals(mp, that.mp) &&
                Objects.equals(strength, that.strength) &&
                Objects.equals(level, that.level) &&
                Objects.equals(experience, that.experience);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hp, mp, strength, level, experience);
    }

    @Override
    public String toString() {
        return "{" +
                "hp=" + hp +
                ", mp=" + mp +
                ", strength=" + strength +
                ", level=" + level +
                ", experience=" + experience +
                '}';
    }
}
