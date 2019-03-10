package com.github.arkadiuss2.cavetravel.application.engine.commands.game;

import com.github.arkadiuss2.cavetravel.application.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.application.engine.core.Engine;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;

public class StatisticCommand extends AbstractCommand {

    private Engine engine;

    public StatisticCommand(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getCommandName() {
        return "statistic";
    }

    @Override
    public boolean isMatched() {
        return getSplitInput().length == 1 && getCommandName().equals(getSplitInput()[0]);
    }

    @Override
    public GameData execute() {
        System.out.println("Game statistic:" + engine.getGameData());
        return engine.getGameData();
    }
}
