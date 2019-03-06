package com.github.arkadiuss2.cavetravel.cmd.commands;

public class LoadCommand implements Command {
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
