package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.engine.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;

public class Start {

    public static void main(String[] args) {

        CaveFactory caveFactory = new CaveFactory();

        startGame(caveFactory);
    }

    private static void startGame(CaveFactory caveFactory) {

        GameState actualGameState = caveFactory.getMenuGameState();

        welcomeMessage();
        displayOptions();

        GameData gameData;
        do {
            gameData = CommandWindowOperator.getCommand(actualGameState.getCommands()).execute();
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
