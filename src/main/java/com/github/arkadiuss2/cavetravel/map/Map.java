package com.github.arkadiuss2.cavetravel.map;

import com.github.arkadiuss2.cavetravel.map.scenarios.Place;

import java.util.List;

public class Map {

    private List<List<Place>> places;

    public List<List<Place>> getPlaces() {
        return places;
    }


    public void generateNewMap() {
        places = MapGenerator.generateMap(10, 10);
    }


}
