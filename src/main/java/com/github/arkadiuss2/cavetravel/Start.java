package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.engine.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;

import java.util.Optional;

public class Start {

    private static boolean hasGameStarted;

    public static void main(String[] args) {

        CaveFactory caveFactory = new CaveFactory();

        startGame(caveFactory);
    }

    private static void startGame(CaveFactory caveFactory) {

        welcomeMessage();
        displayOptions();

        do {
            Optional<Command> first = CommandWindowOperator.getPlayerInputCommand(caveFactory.getCmdCommandList());

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



}
