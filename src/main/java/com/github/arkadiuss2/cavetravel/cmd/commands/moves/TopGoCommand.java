package com.github.arkadiuss2.cavetravel.cmd.commands.moves;

import com.github.arkadiuss2.cavetravel.cmd.commands.CommandCategory;

import java.util.Optional;

import static com.github.arkadiuss2.cavetravel.cmd.commands.moves.Direction.TOP;
import static com.github.arkadiuss2.cavetravel.cmd.commands.moves.Direction.getDirection;

public class TopGoCommand extends AbstractGoCommand {

    @Override
    public boolean isMatched(String[] splitInput) {
        return isGoCommand(splitInput) && isTop(splitInput[1]);
    }

    private boolean isTop(String value) {
        Optional<Direction> direction = getDirection(value);
        return direction.isPresent() && TOP == direction.get();
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
