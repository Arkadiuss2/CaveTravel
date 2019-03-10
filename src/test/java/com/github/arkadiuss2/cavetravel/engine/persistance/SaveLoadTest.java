package com.github.arkadiuss2.cavetravel.engine.persistance;

import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.Load;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.Save;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveLoadTest {


    @Test
    public void shouldSaveThenLoadTest() throws JAXBException {

        GameData exampleGameData = GameDataTest.createExampleGameData();

        Save.saveData("savedFile", exampleGameData);

        GameData data = Load.loadData("savedFile");

        assertTrue(exampleGameData.equals(data));
    }

}
