package com.github.arkadiuss2.cavetravel.engine.map.commands;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;

import java.util.Optional;

public class RightGoCommand extends AbstractGoCommand {

    public RightGoCommand(Engine engine) {
        super(engine);
    }

    @Override
    public String getCommandName() {
        return "go right";
    }

    @Override
    public boolean isMatched() {
        return isGoCommand(getSplitInput()) && isRight(getSplitInput()[1]);
    }

    private boolean isRight(String value) {
        Optional<Direction> direction = Direction.getDirection(value);
        return direction.isPresent() && Direction.RIGHT == direction.get();
    }

    @Override
    public GameData execute() {
        System.out.println("You went RIGHT");
        return getEngine().goRight();
    }


}
