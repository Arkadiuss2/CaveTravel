package com.github.arkadiuss2.cavetravel.cmd.commands.moves;

import com.github.arkadiuss2.cavetravel.cmd.commands.CommandCategory;

import java.util.Optional;

import static com.github.arkadiuss2.cavetravel.cmd.commands.moves.Direction.*;

public class BotGoCommand extends AbstractGoCommand {

    @Override
    public boolean isMatched(String[] splitInput) {
        return isGoCommand(splitInput) && isBot(splitInput[1]);
    }

    private boolean isBot(String value) {
        Optional<Direction> direction = getDirection(value);
        return direction.isPresent() && BOT == direction.get();
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("You went BOT");
    }


}
