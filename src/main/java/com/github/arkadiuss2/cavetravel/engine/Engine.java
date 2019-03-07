package com.github.arkadiuss2.cavetravel.engine;


import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.engine.exception.WrongEngineStateException;
import com.github.arkadiuss2.cavetravel.engine.map.Map;
import com.github.arkadiuss2.cavetravel.engine.map.MapGenerator;
import com.github.arkadiuss2.cavetravel.engine.map.MapPosition;
import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

import static com.github.arkadiuss2.cavetravel.engine.cmd.ConsoleInput.getRawInput;
import static com.github.arkadiuss2.cavetravel.engine.map.MapPosition.EMPTY;

public class Engine {

    private MapPosition playerPosition = EMPTY;
    private PlayerCharacter player;
    private Map map;

    private FightEngine fightEngine;


    private StoryTeller storyTeller;
    private CommandMapOperation commandMapOperation;

    public Engine(CommandMapOperation commandMapOperation, StoryTeller storyTeller, FightEngine fightEngine) {
        this.commandMapOperation = commandMapOperation;
        this.storyTeller = storyTeller;
        this.fightEngine = fightEngine;
    }

    public void starNewGame() {

        PlayerCharacter player = CharacterGenerator.generatePlayer(getRawInput());
        setPlayer(player);
        setMap(MapGenerator.generateMap(10, 10));
        setPlayerPosition(MapPosition.position(0, 0));

        if (isEngineSet()) {
            System.out.println("Game Started..");
            playLevel();
        } else {
            throw new WrongEngineStateException("Engine properties were not properly set!");
        }
    }


    public void playLevel() {

        Place place = map.getPlace(playerPosition);

        storyTeller.tellStory(place);

        FightResult fightResult = fightEngine.fight(player, place.getCharacters());

        System.out.println(fightResult);

        nextMove(fightResult);
    }

    private void nextMove(FightResult fightResult) {
        if (FightResult.Summary.WIN == fightResult.getSummary()) {
            commandMapOperation.executePlayerNextMapMove();
        } else if (FightResult.Summary.LOSE == fightResult.getSummary()) {
            System.out.println("Game ends!");
        }
    }


    private boolean isEngineSet() {
        return playerPosition != EMPTY && player != null && map != null;
    }


    public void setPlayerPosition(MapPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }

    public void setMap(Map map) {
        this.map = map;
    }


    public void goTop() {
        playerPosition = MapPosition.position(playerPosition.getX(), playerPosition.getY() + 1);
        playLevel();
    }

    public void goBot() {
        playerPosition = MapPosition.position(playerPosition.getX(), playerPosition.getY() - 1);
        playLevel();
    }

    public void goLeft() {
        playerPosition = MapPosition.position(playerPosition.getX() - 1, playerPosition.getY());
        playLevel();
    }

    public void goRight() {
        playerPosition = MapPosition.position(playerPosition.getX() + 1, playerPosition.getY());
        playLevel();
    }


}


