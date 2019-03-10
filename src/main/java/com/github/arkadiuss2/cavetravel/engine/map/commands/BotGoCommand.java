package com.github.arkadiuss2.cavetravel.engine.map.commands;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;

import java.util.Optional;

public class BotGoCommand extends AbstractGoCommand {


    public BotGoCommand(Engine engine) {
        super(engine);
    }

    @Override
    public String getCommandName() {
        return "go bot";
    }

    @Override
    public boolean isMatched() {
        return isGoCommand(getSplitInput()) && isBot(getSplitInput()[1]);
    }


    private boolean isBot(String value) {
        Optional<Direction> direction = Direction.getDirection(value);
        return direction.isPresent() && Direction.BOT == direction.get();
    }

    @Override
    public GameData execute() {
        System.out.println("You went BOT");
        return getEngine().goBot();

    }


}
