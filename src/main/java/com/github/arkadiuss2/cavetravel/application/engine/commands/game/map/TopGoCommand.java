package com.github.arkadiuss2.cavetravel.application.engine.commands.game.map;

import com.github.arkadiuss2.cavetravel.application.engine.core.Engine;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;

import java.util.Optional;

public class TopGoCommand extends AbstractGoCommand {

    public TopGoCommand(Engine engine) {
        super(engine);
    }

    @Override
    public String getCommandName() {
        return "go top";
    }

    @Override
    public boolean isMatched() {
        return isGoCommand(getSplitInput()) && isTop(getSplitInput()[1]);
    }

    private boolean isTop(String value) {
        Optional<Direction> direction = Direction.getDirection(value);
        return direction.isPresent() && Direction.TOP == direction.get();
    }

    @Override
    public GameData execute() {
        System.out.println("You went TOP");
        return getSimpleEngine().goTop();
    }


}
