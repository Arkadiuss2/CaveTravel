package com.github.arkadiuss2.cavetravel.application.engine.map.places;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.domain.character.monsters.FrogMonster;
import com.github.arkadiuss2.cavetravel.application.fight_engine.FightResult;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Place {

    private FightResult fightResult;

    @XmlElement(name = "monster", type = FrogMonster.class)
    private ArrayList<CharacterI> characterList = new ArrayList<>();

    public String getDescription() {
        return null;
    }

    public List<CharacterI> getCharacters() {
        return characterList;
    }

    public void addCharacter(CharacterI characterI) {
        characterList.add(characterI);
    }


    public void removeCharacter(CharacterI character) {
        characterList.remove(character);
    }

    public Optional<FightResult> getFightResult() {
        if (fightResult == null) {
            return Optional.empty();
        }
        return Optional.of(fightResult);
    }

    public void setFightResult(FightResult fightResult) {
        this.fightResult = fightResult;
    }

    @Override
    public String toString() {
        return "Place{" +
                "characterList=" + characterList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(characterList, place.characterList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterList);
    }
}
