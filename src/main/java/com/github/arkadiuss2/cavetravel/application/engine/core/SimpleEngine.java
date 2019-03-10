package com.github.arkadiuss2.cavetravel.application.engine.core;


import com.github.arkadiuss2.cavetravel.application.engine.exception.WrongEngineStateException;
import com.github.arkadiuss2.cavetravel.application.engine.map.places.Place;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;
import com.github.arkadiuss2.cavetravel.application.fight_engine.FightEngine;
import com.github.arkadiuss2.cavetravel.application.fight_engine.FightResult;
import com.github.arkadiuss2.cavetravel.application.story_teller.StoryTeller;
import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;

import static com.github.arkadiuss2.cavetravel.application.engine.map.MapPosition.EMPTY;

public class SimpleEngine implements Engine {

    public static final WrongEngineStateException WRONG_ENGINE_STATE_EXCEPTION = new WrongEngineStateException("GameData properties were not properly set!");

    private GameData gameData;

    private FightEngine fightEngine;

    private StoryTeller storyTeller;

    public SimpleEngine(StoryTeller storyTeller, FightEngine fightEngine) {
        this.storyTeller = storyTeller;
        this.fightEngine = fightEngine;
    }

    @Override
    public GameData starNewGame(GameData gameData) {
        this.gameData = gameData;

        if (isGameDataSet()) {
            System.out.println("Game Started..");
            playLevel();
        } else {
            throw WRONG_ENGINE_STATE_EXCEPTION;
        }
        return gameData;
    }

    @Override
    public void loadGame(GameData gameData) {
        this.gameData = gameData;
        if (!isGameDataSet()) {
            throw WRONG_ENGINE_STATE_EXCEPTION;
        }
    }


    @Override
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


    @Override
    public GameData goTop() {
        gameData.getPlayerPosition().setY(gameData.getPlayerPosition().getY() + 1);
        return playLevel();
    }

    @Override
    public GameData goBot() {
        gameData.getPlayerPosition().setY(gameData.getPlayerPosition().getY() - 1);
        return playLevel();
    }

    @Override
    public GameData goLeft() {
        gameData.getPlayerPosition().setX(gameData.getPlayerPosition().getX() - 1);
        return playLevel();
    }

    @Override
    public GameData goRight() {
        gameData.getPlayerPosition().setX(gameData.getPlayerPosition().getX() + 1);
        return playLevel();
    }

    @Override
    public GameData getGameData() {
        return gameData;
    }

}


