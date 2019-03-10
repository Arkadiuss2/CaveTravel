package com.github.arkadiuss2.cavetravel.application.engine.commands.cmd;

import com.github.arkadiuss2.cavetravel.application.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;

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
        printAllCommands(commandsNames);
        return new GameData();
    }

    public void printAllCommands(List<String> commands) {
        System.out.print("Available commands: ");

        for (int i = 0; i < commands.size(); i++) {
            if (i == 0) {
                System.out.print(commands.get(i));
            } else {
                System.out.print(", " + commands.get(i));
            }
        }
        System.out.println();

    }

}
