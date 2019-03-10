package com.github.arkadiuss2.cavetravel.application.engine.commands.game.map;

import com.github.arkadiuss2.cavetravel.application.engine.core.Engine;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;

import java.util.Optional;

public class LeftGoCommand extends AbstractGoCommand {

    public LeftGoCommand(Engine engine) {
        super(engine);
    }

    @Override
    public String getCommandName() {
        return "go left";
    }

    @Override
    public boolean isMatched() {
        return isGoCommand(getSplitInput()) && isLeft(getSplitInput()[1]);
    }


    private boolean isLeft(String value) {
        Optional<Direction> direction = Direction.getDirection(value);
        return direction.isPresent() && Direction.LEFT == direction.get();
    }

    @Override
    public GameData execute() {
        System.out.println("You went LEFT");
        return getSimpleEngine().goLeft();
    }


}
