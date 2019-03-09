package com.github.arkadiuss2.cavetravel.engine.persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.github.arkadiuss2.cavetravel.engine.persistance.GameDataTest.createExampleGameData;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveTest {


    private GameData gameData;


    @BeforeEach
    public void initial() {
        gameData = createExampleGameData();
    }


    @Test
    public void shouldCompareGameData() throws JAXBException, IOException {

        //given
        //when
        Save.saveData("TestSave", gameData);
        File originalFile = new File("TestSave.xml");
        File compareFile = new File("src/test/resources/CompareSaveGameData.xml");
        //then

        //hard way - cannot use external lib for comparision
        byte[] originalFileBytes = Files.readAllBytes(getPath(originalFile));
        byte[] compareFileBytes = Files.readAllBytes(getPath(compareFile));

        assertTrue(Arrays.equals(originalFileBytes, compareFileBytes));
    }

    private Path getPath(File originalFile) {
        return FileSystems.getDefault().getPath(originalFile.getAbsolutePath());
    }

}
