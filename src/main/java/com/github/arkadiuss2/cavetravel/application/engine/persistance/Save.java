package com.github.arkadiuss2.cavetravel.application.engine.persistance;

import com.github.arkadiuss2.cavetravel.domain.places.scary.ScaryPlace;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Save {


    public static void saveData(String fileName, GameData gameData) throws JAXBException {

        JAXBContext ctx = JAXBContext.newInstance(GameData.class, ScaryPlace.class);

        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(gameData, new File(fileName + ".xml"));

    }
}
