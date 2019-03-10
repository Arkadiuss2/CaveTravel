package com.github.arkadiuss2.cavetravel.application.engine.commands;

import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;

public interface Command {

    String getCommandName();

    void setInputCommand(String[] splitInput);

    boolean isMatched();

    GameData execute();

}
