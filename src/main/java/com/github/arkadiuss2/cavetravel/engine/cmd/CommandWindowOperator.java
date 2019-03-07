package com.github.arkadiuss2.cavetravel.engine.cmd;

import com.github.arkadiuss2.cavetravel.engine.commands.Command;

import java.util.List;
import java.util.Optional;

import static com.github.arkadiuss2.cavetravel.engine.cmd.ConsoleInput.getSplitInput;

public class CommandWindowOperator {

    private CommandWindowOperator() {
    }

    public static Command getValidInputCommand(List<Command> commandList) {
        Optional<Command> playerInputCommand;
        boolean isAbsent;
        do {
            playerInputCommand = getPlayerInputCommand(commandList);
            isAbsent = !playerInputCommand.isPresent();
            if(isAbsent){
                System.out.println("Command not found type 'help' to get all available commands");
            }
        } while (isAbsent);

        return playerInputCommand.get();
    }

    public static Optional<Command> getPlayerInputCommand(List<Command> commandList) {
        String[] splitInput = getSplitInput();

        return commandList
                .stream()
                .filter(command -> command.isMatched(splitInput))
                .findFirst();
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


}
