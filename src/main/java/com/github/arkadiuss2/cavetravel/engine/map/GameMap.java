package com.github.arkadiuss2.cavetravel.engine.map;

import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class    GameMap {

    public static final int MAX_WIDTH = 100;
    public static final int MAX_HEIGHT = 100;

    private Place[][] places;

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
        checkLimits(position.getX(), position.getY());
        return places[position.getX()][position.getY()];
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameMap gameMap = (GameMap) o;
        return Arrays.deepEquals(places, gameMap.places);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(places);
    }

    @Override
    public String toString() {
        return "GameMap{" +
                "places=" + Arrays.deepToString(places) +
                '}';
    }
}
