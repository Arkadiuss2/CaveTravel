package com.github.arkadiuss2.cavetravel.domain.character.skill;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Strength implements Skill {

    @XmlElement
    private double value = 1;

    public double getSkillValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Strength strength = (Strength) o;
        return Double.compare(strength.value, value) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                '}';
    }
}
