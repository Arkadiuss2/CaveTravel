package com.github.arkadiuss2.cavetravel.domain.places.scary;

import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Scary")
public class ScaryPlace extends Place {

    public ScaryPlace() {
    }

    @Override
    public String getDescription() {
        return "Scary Place.";
    }

}
