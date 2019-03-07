package com.github.arkadiuss2.cavetravel.engine.commands;

public interface Command {

    String getCommandName();

    boolean isMatched(String[] splitInput);

    CommandCategory getCategory();

    void execute();
}
