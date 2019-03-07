package com.github.arkadiuss2.cavetravel.engine;


import com.github.arkadiuss2.cavetravel.domain.character.CharacterI;
import com.github.arkadiuss2.cavetravel.engine.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.exception.WrongEngineStateException;
import com.github.arkadiuss2.cavetravel.engine.map.Map;
import com.github.arkadiuss2.cavetravel.engine.map.MapPosition;
import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

import java.util.List;

import static com.github.arkadiuss2.cavetravel.engine.map.MapPosition.EMPTY;

public class Engine {

    private MapPosition playerPosition = EMPTY;
    private CharacterI player;
    private Map map;
    private List<Command> mapCommands;


    private StoryTeller storyTeller;

    public Engine(List<Command> mapCommands, StoryTeller storyTeller) {
        this.mapCommands = mapCommands;
        this.storyTeller = storyTeller;
    }

    public void starNewGame() {
        if (isEngineSet()) {
            System.out.println("Game Started..");
            playLevel();
        } else {
            throw new WrongEngineStateException("Engine properties were not properly set!");
        }
    }

    private boolean isEngineSet() {
        return playerPosition != EMPTY && player != null && map != null;
    }

    public void playLevel() {

        map.placePlayerInto(player, playerPosition);

        Place playerPlace = map.getPlace(playerPosition);

        storyTeller.tellStory(playerPlace);


        List<Command> availableMoves = playerPlace.getAvailableMoves();

        System.out.println("Available commands");
        CommandWindowOperator.printAllCommands(availableMoves);

        do {
            Command command = CommandWindowOperator.getValidInputCommand(availableMoves);
            command.execute();
            //todo change this
        } while (1 == 1);

    }

    public void setPlayerPosition(MapPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void setPlayer(CharacterI player) {
        this.player = player;
    }

    public void setMap(Map map) {
        this.map = map;
    }


}


