package com.github.arkadiuss2.cavetravel.engine.persistance;

import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;
import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.domain.character.skill.Strength;
import com.github.arkadiuss2.cavetravel.domain.places.scary.ScaryPlace;
import com.github.arkadiuss2.cavetravel.domain.character.CharacterGenerator;
import com.github.arkadiuss2.cavetravel.application.engine.map.GameMap;
import com.github.arkadiuss2.cavetravel.application.engine.map.MapGenerator;
import com.github.arkadiuss2.cavetravel.application.engine.map.places.Place;

import java.util.List;


public class GameDataTest {

    public static final int WAYNE_STRENGTH = 1000;
    public static final String JOHN_WAYNE = "john wayne";

    public static GameData createExampleGameData() {
        GameData data = new GameData();
        GameMap gameMap = MapGenerator.generateMap(2, 2);
        Place[][] places = gameMap.getPlaces();

        ScaryPlace noMonsterPlace = new ScaryPlace();

        List<CharacterI> characters = noMonsterPlace.getCharacters();
        characters.clear();

        places[1][1] = noMonsterPlace;

        data.setGameMap(gameMap);

        PlayerCharacter player = CharacterGenerator.generatePlayer(JOHN_WAYNE);
        Strength strength = new Strength();
        strength.setValue(WAYNE_STRENGTH);
        player.setStrength(strength);

        data.setPlayer(player);
        return data;
    }
}
