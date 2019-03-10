package com.github.arkadiuss2.cavetravel.engine;


import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.engine.exception.WrongEngineStateException;
import com.github.arkadiuss2.cavetravel.engine.map.MapGenerator;
import com.github.arkadiuss2.cavetravel.engine.map.MapPosition;
import com.github.arkadiuss2.cavetravel.engine.map.places.Place;
import com.github.arkadiuss2.cavetravel.engine.persistance.GameData;

import static com.github.arkadiuss2.cavetravel.engine.cmd.ConsoleInput.getRawInput;
import static com.github.arkadiuss2.cavetravel.engine.map.MapPosition.EMPTY;

public class Engine {

    public static final WrongEngineStateException WRONG_ENGINE_STATE_EXCEPTION = new WrongEngineStateException("GameData properties were not properly set!");


    private GameData gameData;

    private FightEngine fightEngine;

    private StoryTeller storyTeller;

    public Engine(StoryTeller storyTeller, FightEngine fightEngine) {
        this.storyTeller = storyTeller;
        this.fightEngine = fightEngine;
    }

    public GameData starNewGame() {

        initialization();

        if (isGameDataSet()) {
            System.out.println("Game Started..");
            playLevel();
        } else {
            throw WRONG_ENGINE_STATE_EXCEPTION;
        }
        return gameData;
    }

    public void loadGame(GameData gameData) {
        this.gameData = gameData;
        if (!isGameDataSet()) {
            throw WRONG_ENGINE_STATE_EXCEPTION;
        }
    }

    private void initialization() {

        gameData = new GameData();
        gameData.setPlayer(CharacterGenerator.generatePlayer(getRawInput()));
        gameData.setGameMap(MapGenerator.generateMap(10, 10));
        gameData.setPlayerPosition(new MapPosition(0, 0));

    }

    public GameData playLevel() {

        Place place = gameData.getGameMap().getPlace(gameData.getPlayerPosition());

        storyTeller.tellStory(place, gameData.getPlayerPosition());

        FightResult fightResult = fightEngine.fight(gameData.getPlayer(), place.getCharacters());

        collectFightStuff(gameData.getPlayer(), fightResult);

        place.setFightResult(fightResult);

        System.out.println(fightResult);

        return gameData;
    }

    private void collectFightStuff(PlayerCharacter player, FightResult fightResult) {
        //todo implement all collecting stuff, implement lvl up player.
        player.getExperience().addCurrentValue(fightResult.getExp());
    }

    private boolean isGameDataSet() {
        return gameData.getPlayerPosition() != EMPTY && gameData.getPlayer() != null && gameData.getGameMap() != null;
    }


    public GameData goTop() {
        gameData.getPlayerPosition().setY(gameData.getPlayerPosition().getY() + 1);
        return playLevel();
    }

    public GameData goBot() {
        gameData.getPlayerPosition().setY(gameData.getPlayerPosition().getY() - 1);
        return playLevel();
    }

    public GameData goLeft() {
        gameData.getPlayerPosition().setX(gameData.getPlayerPosition().getX() - 1);
        return playLevel();
    }

    public GameData goRight() {
        gameData.getPlayerPosition().setX(gameData.getPlayerPosition().getX() + 1);
        return playLevel();
    }

    public GameData getGameData() {
        return gameData;
    }

}


