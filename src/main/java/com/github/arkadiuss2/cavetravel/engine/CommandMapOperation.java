package com.github.arkadiuss2.cavetravel.engine;

import com.github.arkadiuss2.cavetravel.engine.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.map.commands.Direction;

import java.util.List;

public class CommandMapOperation {


    private List<Command<Direction>> commandsList;

    public CommandMapOperation(List<Command<Direction>> commandsList) {
        this.commandsList = commandsList;
    }

    public Direction executePlayerNextMapMove() {
        return CommandWindowOperator.getCommand(commandsList).execute();
    }


}
