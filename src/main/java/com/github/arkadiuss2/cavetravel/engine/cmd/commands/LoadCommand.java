package com.github.arkadiuss2.cavetravel.engine.cmd.commands;

import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

public class LoadCommand implements Command {
    @Override
    public String getCommandName() {
        return "load";
    }

    @Override
    public boolean isMatched(String[] splitInput) {
        return false;
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public void execute() {

    }
}
