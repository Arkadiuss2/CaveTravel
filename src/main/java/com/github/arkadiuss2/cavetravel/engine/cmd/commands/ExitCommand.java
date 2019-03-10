package com.github.arkadiuss2.cavetravel.engine.cmd.commands;

import com.github.arkadiuss2.cavetravel.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;

public class ExitCommand extends AbstractCommand {
    @Override
    public String getCommandName() {
        return "exit";
    }

    @Override
    public boolean isMatched() {
        return getSplitInput().length == 1 && getCommandName().equals(getSplitInput()[0]);
    }

    @Override
    public GameData execute() {
        GameData gameData = new GameData();
        gameData.setGameEnded(true);
        return gameData;
    }
}
