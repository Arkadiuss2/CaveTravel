package com.github.arkadiuss2.cavetravel.engine;


import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.engine.exception.WrongEngineStateException;
import com.github.arkadiuss2.cavetravel.engine.map.GameMap;
import com.github.arkadiuss2.cavetravel.engine.map.MapGenerator;
import com.github.arkadiuss2.cavetravel.engine.map.MapPosition;
import com.github.arkadiuss2.cavetravel.engine.map.commands.Direction;
import com.github.arkadiuss2.cavetravel.engine.map.places.Place;

import static com.github.arkadiuss2.cavetravel.engine.cmd.ConsoleInput.getRawInput;
import static com.github.arkadiuss2.cavetravel.engine.map.MapPosition.EMPTY;

public class Engine {

    private MapPosition playerPosition = EMPTY;
    private PlayerCharacter player;
    private GameMap gameMap;

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
        setGameMap(MapGenerator.generateMap(10, 10));
        setPlayerPosition(new MapPosition(0, 0));

        if (isEngineSet()) {
            System.out.println("Game Started..");
            playLevel();
        } else {
            throw new WrongEngineStateException("Engine properties were not properly set!");
        }
    }


    public void playLevel() {

        Place place = gameMap.getPlace(playerPosition);

        storyTeller.tellStory(place, playerPosition);

        FightResult fightResult = fightEngine.fight(player, place.getCharacters());

        System.out.println(fightResult);

        nextMove(fightResult);
    }

    private void nextMove(FightResult fightResult) {
        if (FightResult.Summary.WIN == fightResult.getSummary()) {
            Direction direction = commandMapOperation.executePlayerNextMapMove();
            goTo(direction);
        } else if (FightResult.Summary.LOSE == fightResult.getSummary()) {
            System.out.println("Game ends!");
        }
    }

    private void goTo(Direction direction) {
        switch (direction) {
            case TOP: {
                goTop();
                break;
            }
            case LEFT: {
                goLeft();
                break;
            }
            case RIGHT: {
                goRight();
                break;
            }
            case BOT: {
                goBot();
            }
        }
    }


    private boolean isEngineSet() {
        return playerPosition != EMPTY && player != null && gameMap != null;
    }


    public void setPlayerPosition(MapPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    public void goTop() {
        playerPosition.setY(playerPosition.getY() + 1);
        playLevel();
    }

    public void goBot() {
        playerPosition.setY(playerPosition.getY() - 1);
        playLevel();
    }

    public void goLeft() {
        playerPosition.setX(playerPosition.getX() - 1);
        playLevel();
    }

    public void goRight() {
        playerPosition.setX(playerPosition.getX() + 1);
        playLevel();
    }


}


