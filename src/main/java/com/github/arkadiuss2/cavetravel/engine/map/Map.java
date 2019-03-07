package com.github.arkadiuss2.cavetravel.engine.map;

import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

public class Map {

    public static final int MAX_WIDTH = 100;
    public static final int MAX_HEIGHT = 100;

    private Place[][] places;
    private MapPosition playerPosition = MapPosition.EMPTY;


    public Place[][] getPlaces() {
        return places;
    }


    private void checkLimits(int width, int height) {
        if (width > MAX_WIDTH) {
            throw new UnsupportedMapException("Width can be max=" + MAX_WIDTH);
        } else if (height > MAX_HEIGHT) {
            throw new UnsupportedMapException("Height can be max=" + MAX_HEIGHT);
        }
    }


    public void setPlaces(Place[][] places) {
        this.places = places;
    }


    public Place getPlace(MapPosition position) {
        return places[position.getX()][position.getY()];
    }


    public void placePlayerInto(CharacterI character, MapPosition position) {
        if (playerPosition != MapPosition.EMPTY) {
            getPlace(position).removeCharacter(character);
        }
        playerPosition = position;
        getPlace(position).addCharacter(character);
    }

}
