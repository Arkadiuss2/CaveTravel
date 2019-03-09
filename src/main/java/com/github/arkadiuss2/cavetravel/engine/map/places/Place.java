package com.github.arkadiuss2.cavetravel.engine.map.places;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.domain.character.monsters.FrogMonster;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Place {

    public Place(){
    }

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
