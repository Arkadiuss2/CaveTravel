package com.github.arkadiuss2.cavetravel.engine.map.commands;

import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

import java.util.Optional;

public class TopGoCommand extends AbstractGoCommand {

    @Override
    public String getCommandName() {
        return "go top";
    }

    @Override
    public boolean isMatched(String[] splitInput) {
        return isGoCommand(splitInput) && isTop(splitInput[1]);
    }

    private boolean isTop(String value) {
        Optional<Direction> direction = Direction.getDirection(value);
        return direction.isPresent() && Direction.TOP == direction.get();
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("You went TOP");
    }


}
