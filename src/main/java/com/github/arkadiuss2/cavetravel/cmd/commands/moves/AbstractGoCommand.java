package com.github.arkadiuss2.cavetravel.cmd.commands.moves;

import com.github.arkadiuss2.cavetravel.cmd.commands.Command;
import com.github.arkadiuss2.cavetravel.cmd.commands.CommandCategory;

import static com.github.arkadiuss2.cavetravel.cmd.commands.moves.Direction.getDirection;

public abstract class AbstractGoCommand implements Command {


    protected boolean isGoCommand(String[] splitInput) {
        return "go".equals(splitInput[0]) &&
                splitInput.length == 2 &&
                getDirection(splitInput[1]).isPresent();
    }

    @Override
    public abstract boolean isMatched(String[] splitInput);

    @Override
    public abstract CommandCategory getCategory();

    @Override
    public abstract void execute();
}
