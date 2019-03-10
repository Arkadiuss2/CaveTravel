package com.github.arkadiuss2.cavetravel.application.engine.commands.cmd;

import com.github.arkadiuss2.cavetravel.application.engine.core.Engine;
import com.github.arkadiuss2.cavetravel.application.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.Save;

import javax.xml.bind.JAXBException;

public class SaveCommand extends AbstractCommand {

    private Engine engine;

    public SaveCommand(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getCommandName() {
        return "save gameName";
    }


    @Override
    public boolean isMatched() {
        return getSplitInput().length == 2 && "save".equals(getSplitInput()[0]);
    }

    @Override
    public GameData execute() {
        GameData gameData = engine.getGameData();
        try {
            Save.saveData(getSplitInput()[1], gameData);
        } catch (JAXBException e) {
            throw new UnsupportedOperationException("Error while saving: ", e);
        }
        System.out.println("Game Saved!");
        return gameData;
    }


}
