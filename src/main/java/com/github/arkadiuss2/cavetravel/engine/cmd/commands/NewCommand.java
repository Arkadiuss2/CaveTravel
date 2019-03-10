package com.github.arkadiuss2.cavetravel.engine.cmd.commands;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;

public class NewCommand extends AbstractCommand {

    private Engine engine;

    public NewCommand(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getCommandName() {
        return "new";
    }

    @Override
    public boolean isMatched() {
        return getSplitInput().length == 1 && "new".equals(getSplitInput()[0]);
    }

    @Override
    public GameData execute() {
        System.out.println("Starting new game..");
        System.out.println("What is your name Wanderer?");

        return engine.starNewGame();
    }


}
