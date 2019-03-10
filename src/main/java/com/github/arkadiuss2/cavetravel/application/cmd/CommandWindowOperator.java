package com.github.arkadiuss2.cavetravel.application.cmd;

import com.github.arkadiuss2.cavetravel.application.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.application.engine.commands.cmd.HelpCommand;

import java.util.List;
import java.util.Optional;


public class CommandWindowOperator {

    private Input input;

    public CommandWindowOperator(Input input) {
        this.input = input;
    }

    public Command getCommand(List<Command> commandList) {
        Command command;
        do {
            command = getValidCommand(commandList);

            if (command instanceof HelpCommand) {
                command.execute();
            }

        } while (command instanceof HelpCommand);

        return command;
    }


    private Command getValidCommand(List<Command> commandList) {
        Optional<Command> playerInputCommand;
        boolean isAbsent;
        do {
            playerInputCommand = getInputCommand(commandList);

            isAbsent = !playerInputCommand.isPresent();

            if (isAbsent) {
                System.out.println("Command not found type 'help' to get all available commands");
            }
        } while (isAbsent);

        return playerInputCommand.get();
    }

    private Optional<Command> getInputCommand(List<Command> commandList) {
        String[] splitInput = input.getSplitInput();

        return commandList
                .stream()
                .filter(command -> {
                    command.setInputCommand(splitInput);
                    return command.isMatched();
                })
                .findFirst();
    }


}
