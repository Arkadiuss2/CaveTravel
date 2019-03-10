package com.github.arkadiuss2.cavetravel.engine.cmd.commands;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;
import com.github.arkadiuss2.cavetravel.engine.persistance.Load;

import javax.xml.bind.JAXBException;

public class LoadCommand extends AbstractCommand {

    private Engine engine;

    public LoadCommand(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getCommandName() {
        return "load GameName";
    }


    @Override
    public boolean isMatched() {
        return getSplitInput().length == 2 && "load".equals(getSplitInput()[0]);
    }


    @Override
    public GameData execute() {
        GameData data;
        try {
            data = Load.loadData(getSplitInput()[1]);
        } catch (JAXBException e) {
            throw new UnsupportedOperationException("Loading error= ", e);
        }
        engine.loadGame(data);
        System.out.println("Game loaded!");
        return data;
    }


}
