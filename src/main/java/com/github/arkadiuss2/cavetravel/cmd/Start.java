package com.github.arkadiuss2.cavetravel.cmd;

import com.github.arkadiuss2.cavetravel.cmd.commands.Command;

import java.util.List;
import java.util.Optional;

import static com.github.arkadiuss2.cavetravel.CaveFactory.*;
import static com.github.arkadiuss2.cavetravel.cmd.commands.ConsoleInput.getSplitInput;

public class Start {

    private static boolean hasGameStarted;

    public static void main(String[] args) {

        welcomeMessage();
        displayOptions();
        System.out.println();
        do {
            Optional<Command> first = getMatchedCommand(getCommandList());

            if (first.isPresent()) {
                first.get().execute();
            } else {
                System.out.println("Command not found type 'help' to see all commands");
            }

        } while (!hasGameStarted);
    }

    private static void welcomeMessage() {
        System.out.println("Hello Wanderer!");
    }

    private static void displayOptions() {
        System.out.println("Type: 'help' for commands");
        System.out.println("Write what do you want to do:");
    }

    public static Optional<Command> getMatchedCommand(List<Command> commandList) {
        String[] splitInput = getSplitInput();

        return commandList
                .stream()
                .filter(command -> command.isMatched(splitInput))
                .findFirst();
    }

}
