package com.github.arkadiuss2.cavetravel.engine.persistance;

import com.github.arkadiuss2.cavetravel.domain.places.scary.ScaryPlace;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Load {


    public static GameData loadData(String fileToLoad) throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(GameData.class, ScaryPlace.class);

        Unmarshaller unmarshaller = ctx.createUnmarshaller();


        Object loadFile = unmarshaller.unmarshal(new File(fileToLoad + ".xml"));
        return (GameData) loadFile;

    }

}
