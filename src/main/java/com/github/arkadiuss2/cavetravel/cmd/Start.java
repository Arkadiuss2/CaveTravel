package com.github.arkadiuss2.cavetravel.cmd;

import com.github.arkadiuss2.cavetravel.cmd.commands.Command;

import static com.github.arkadiuss2.cavetravel.cmd.commands.ConsoleInput.getMenuInput;

public class Start {

    private static boolean hasGameStarted;

    public static void main(String[] args) {

        welcomeMessage();
        displayOptions();
        do {
            Command inputCommand = getMenuInput();
            inputCommand.execute();
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
