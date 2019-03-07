package com.github.arkadiuss2.cavetravel.engine.map;

import com.github.arkadiuss2.cavetravel.domain.character.monsters.FrogMonster;
import com.github.arkadiuss2.cavetravel.domain.places.scary.ScaryPlace;
import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

public class MapGenerator {


    public static Map generateMap(int width, int height) {


        Place[][] places = new Place[width][height];

        for (int i = 0; i < width; i++) {
            for (int z = 0; z < height; z++) {
                Place place = new ScaryPlace();
                place.addCharacter(new FrogMonster());
                places[i][z] = place;
            }
        }

        Map map = new Map();
        map.setPlaces(places);
        return map;

    }
}
