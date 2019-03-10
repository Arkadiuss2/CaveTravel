package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.application.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.application.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;

public class Start {

    public static void main(String[] args) {

        CaveFactory caveFactory = new CaveFactory();

        startGame(caveFactory);
    }

    private static void startGame(CaveFactory caveFactory) {

        CommandWindowOperator commandWindowOperator = caveFactory.geCommandWindowOperator();
        GameState actualGameState = caveFactory.getMenuGameState();

        welcomeMessage();
        displayOptions();

        GameData gameData;
        do {
            Command command = commandWindowOperator.getCommand(actualGameState.getCommands());
            gameData = command.execute();

            if (gameData.isGameActive()) {
                actualGameState = caveFactory.getActiveGameState();
            } else {
                actualGameState = caveFactory.getMenuGameState();
            }

        } while (!gameData.isGameEnded());
    }

    private static void welcomeMessage() {
        System.out.println("Hello Wanderer!");
    }

    private static void displayOptions() {
        System.out.println("Type: 'help' for commands");
        System.out.println("Write what do you want to do:");
    }


}
