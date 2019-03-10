package com.github.arkadiuss2.cavetravel.engine.cmd.commands;

import com.github.arkadiuss2.cavetravel.engine.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;

import java.util.List;

public class HelpCommand extends AbstractCommand {

    private List<String> commandsNames;

    public HelpCommand(List<String> commandsNames) {
        this.commandsNames = commandsNames;
        commandsNames.add(getCommandName());
    }

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public boolean isMatched() {
        return getSplitInput().length == 1 && "help".equals(getSplitInput()[0]);
    }

    public GameData execute() {
        CommandWindowOperator.printAllCommands(commandsNames);
        return new GameData();
    }


}
