package com.github.arkadiuss2.cavetravel.engine.commands;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;

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
