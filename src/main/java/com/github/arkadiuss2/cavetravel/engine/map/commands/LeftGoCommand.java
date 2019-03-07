package com.github.arkadiuss2.cavetravel.engine.map.commands;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

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
    public boolean isMatched(String[] splitInput) {
        return isGoCommand(splitInput) && isLeft(splitInput[1]);
    }

    private boolean isLeft(String value) {
        Optional<Direction> direction = Direction.getDirection(value);
        return direction.isPresent() && Direction.LEFT == direction.get();
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("You went LEFT");
        getEngine().goLeft();
    }


}
