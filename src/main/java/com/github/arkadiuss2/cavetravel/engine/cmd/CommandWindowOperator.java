package com.github.arkadiuss2.cavetravel.engine.cmd;

import com.github.arkadiuss2.cavetravel.engine.cmd.commands.HelpCommand;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;

import java.util.List;
import java.util.Optional;

import static com.github.arkadiuss2.cavetravel.engine.cmd.ConsoleInput.getSplitInput;

public class CommandWindowOperator {

    private CommandWindowOperator() {
    }

    public static <T> Command<T> getCommand(List<Command<T>> commandList) {
        Command<T> command;
        do {
            command = getValidCommand(commandList);

            if (command instanceof HelpCommand) {
                command.execute();
            }

        } while (command instanceof HelpCommand);

        return command;
    }

    public static void printAllCommands(List<Command> commandList) {
        System.out.print("Available commands: ");

        for (int i = 0; i < commandList.size(); i++) {
            if (i == 0) {
                System.out.print(commandList.get(i).getCommandName());
            } else {
                System.out.print(", " + commandList.get(i).getCommandName());
            }
        }
        System.out.println();

    }


    private static <T> Command<T> getValidCommand(List<Command<T>> commandList) {
        Optional<Command<T>> playerInputCommand;
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

    private static <T> Optional<Command<T>> getInputCommand(List<Command<T>> commandList) {
        String[] splitInput = getSplitInput();

        return commandList
                .stream()
                .filter(command -> command.isMatched(splitInput))
                .findFirst();
    }


}
