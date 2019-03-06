package com.github.arkadiuss2.cavetravel.cmd.commands.moves;

import com.github.arkadiuss2.cavetravel.cmd.commands.CommandCategory;

import java.util.Optional;

import static com.github.arkadiuss2.cavetravel.cmd.commands.moves.Direction.LEFT;
import static com.github.arkadiuss2.cavetravel.cmd.commands.moves.Direction.getDirection;

public class LeftGoCommand extends AbstractGoCommand {

    @Override
    public boolean isMatched(String[] splitInput) {
        return isGoCommand(splitInput) && isLeft(splitInput[1]);
    }

    private boolean isLeft(String value) {
        Optional<Direction> direction = getDirection(value);
        return direction.isPresent() && LEFT == direction.get();
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("You went LEFT");
    }


}
