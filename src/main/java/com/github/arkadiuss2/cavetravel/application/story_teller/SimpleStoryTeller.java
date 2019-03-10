package com.github.arkadiuss2.cavetravel.application.story_teller;

import com.github.arkadiuss2.cavetravel.application.engine.map.MapPosition;
import com.github.arkadiuss2.cavetravel.application.engine.map.places.Place;

public class SimpleStoryTeller implements StoryTeller {

    @Override
    public void tellStory(Place place, MapPosition playerPosition) {
        System.out.println("On map you are on: " + playerPosition);
        System.out.println("You look at the place and see:" + place.getDescription());
        System.out.println("In this place there are characters:");
        place.getCharacters().forEach(System.out::println);
    }
}
