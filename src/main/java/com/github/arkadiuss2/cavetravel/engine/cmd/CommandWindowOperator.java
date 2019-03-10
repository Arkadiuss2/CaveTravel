package com.github.arkadiuss2.cavetravel.engine.cmd;

import com.github.arkadiuss2.cavetravel.engine.cmd.commands.HelpCommand;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;

import java.util.List;
import java.util.Optional;

import static com.github.arkadiuss2.cavetravel.engine.cmd.ConsoleInput.getSplitInput;

public class CommandWindowOperator {

    private CommandWindowOperator() {
    }

    public static Command getCommand(List<Command> commandList) {
        Command command;
        do {
            command = getValidCommand(commandList);

            if (command instanceof HelpCommand) {
                command.execute();
            }

        } while (command instanceof HelpCommand);

        return command;
    }

    public static void printAllCommands(List<String> commands) {
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


    private static Command getValidCommand(List<Command> commandList) {
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

    private static Optional<Command> getInputCommand(List<Command> commandList) {
        String[] splitInput = getSplitInput();

        return commandList
                .stream()
                .filter(command -> {
                    command.setInputCommand(splitInput);
                    return command.isMatched();
                })
                .findFirst();
    }


}
