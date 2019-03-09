package com.github.arkadiuss2.cavetravel.engine.commands;

public interface Command<T> {

    String getCommandName();

    boolean isMatched(String[] splitInput);

    CommandCategory getCategory();

    T execute();
}
