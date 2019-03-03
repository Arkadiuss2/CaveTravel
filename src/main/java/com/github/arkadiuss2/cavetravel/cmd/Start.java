package com.github.arkadiuss2.cavetravel.cmd;

import com.github.arkadiuss2.cavetravel.cmd.commands.*;

import java.util.Scanner;

public class Start {

    private static boolean hasGameStarted;

    public static void main(String[] args) {

        welcomeMessage();
        displayOptions();
        do {
            Command inputCommand = getInput();
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


    private static String getRawInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }


    private static Command getInput() {
        String rawInput = getRawInput();
        Command result;

        switch (rawInput) {
            case "help": {
                result = new HelpCommand();
                break;
            }
            case "new": {
                result = new NewCommand();
                break;
            }
            case "load": {
                result = new LoadCommand();
                break;
            }
            default: {
                result = new UnsupportedCommand();
            }
        }

        return result;

    }


}
