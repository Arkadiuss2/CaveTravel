package com.github.arkadiuss2.cavetravel.engine.map.commands;

import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

public abstract class AbstractGoCommand implements Command {


    protected boolean isGoCommand(String[] splitInput) {
        return "go".equals(splitInput[0]) &&
                splitInput.length == 2 &&
                Direction.getDirection(splitInput[1]).isPresent();
    }

    @Override
    public abstract boolean isMatched(String[] splitInput);

    @Override
    public abstract CommandCategory getCategory();

    @Override
    public abstract void execute();
}
