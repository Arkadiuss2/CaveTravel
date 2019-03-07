package com.github.arkadiuss2.cavetravel.engine;

import com.github.arkadiuss2.cavetravel.engine.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;

import java.util.List;

public class CommandMapOperation {


    private List<Command> commandsList;

    public CommandMapOperation(List<Command> commandsList) {
        this.commandsList = commandsList;
    }

    public void executePlayerNextMapMove() {
        CommandWindowOperator.getCommand(commandsList).execute();
    }


}
