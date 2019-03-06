package com.github.arkadiuss2.cavetravel.cmd.commands;

public interface Command {

    boolean isMatched(String[] splitInput );

    CommandCategory getCategory();

    void execute();
}
