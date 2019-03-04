package com.github.arkadiuss2.cavetravel.engine;

import com.github.arkadiuss2.cavetravel.map.Map;
import com.github.arkadiuss2.cavetravel.map.MapPosition;
import com.github.arkadiuss2.cavetravel.map.places.Place;

public class StoryTeller {

    private Map map;

    public StoryTeller(Map map) {
        this.map = map;
    }

    public void tellStory(MapPosition playerPosition) {
        Place place = map.getPlace(playerPosition);
        System.out.println("Position:" + playerPosition);
        System.out.println("You look at the place and see:" + place.getDescription());
        System.out.println("In this place there are characters:");
        place.getCharacters().forEach(characterI-> System.out.println(characterI));
    }
}
