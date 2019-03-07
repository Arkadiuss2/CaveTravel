package com.github.arkadiuss2.cavetravel.engine.cmd.commands;

import com.github.arkadiuss2.cavetravel.engine.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

import java.util.List;

public class HelpCommand implements Command {

    private List<Command> commandList;

    public HelpCommand(List<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public boolean isMatched(String[] splitInput) {
        return (splitInput.length == 1 && "help".equals(splitInput[0]));

    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    public void execute() {
        CommandWindowOperator.printAllCommands(commandList);
    }


}
