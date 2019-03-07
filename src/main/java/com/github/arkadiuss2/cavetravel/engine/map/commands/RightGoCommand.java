package com.github.arkadiuss2.cavetravel.engine.map.commands;

import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

import java.util.Optional;

public class RightGoCommand extends AbstractGoCommand {

    @Override
    public String getCommandName() {
        return "go right";
    }

    @Override
    public boolean isMatched(String[] splitInput) {
        return isGoCommand(splitInput) && isRight(splitInput[1]);
    }

    private boolean isRight(String value) {
        Optional<Direction> direction = Direction.getDirection(value);
        return direction.isPresent() && Direction.RIGHT == direction.get();
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("You went RIGHT");
    }


}
