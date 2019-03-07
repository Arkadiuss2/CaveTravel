package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.engine.cmd.CommandWindowOperator;

public class Start {

//    private static boolean hasGameStarted;

    public static void main(String[] args) {

        CaveFactory caveFactory = new CaveFactory();

        startGame(caveFactory);
    }

    private static void startGame(CaveFactory caveFactory) {

        welcomeMessage();
        displayOptions();

        do {
            CommandWindowOperator.getCommand(caveFactory.getCmdCommandList()).execute();
        } while (true);
    }

    private static void welcomeMessage() {
        System.out.println("Hello Wanderer!");
    }

    private static void displayOptions() {
        System.out.println("Type: 'help' for commands");
        System.out.println("Write what do you want to do:");
    }


}
