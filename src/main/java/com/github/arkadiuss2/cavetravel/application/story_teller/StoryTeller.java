package com.github.arkadiuss2.cavetravel.application.story_teller;

import com.github.arkadiuss2.cavetravel.application.engine.map.MapPosition;
import com.github.arkadiuss2.cavetravel.application.engine.map.places.Place;

public interface StoryTeller {
    void tellStory(Place place, MapPosition playerPosition);
}
