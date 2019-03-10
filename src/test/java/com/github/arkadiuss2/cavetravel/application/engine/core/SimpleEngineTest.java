package com.github.arkadiuss2.cavetravel.application.engine.core;

import com.github.arkadiuss2.cavetravel.application.engine.exception.WrongEngineStateException;
import com.github.arkadiuss2.cavetravel.application.engine.map.MapGenerator;
import com.github.arkadiuss2.cavetravel.application.engine.map.MapPosition;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;
import com.github.arkadiuss2.cavetravel.application.fight_engine.FightEngine;
import com.github.arkadiuss2.cavetravel.application.fight_engine.FightResult;
import com.github.arkadiuss2.cavetravel.application.story_teller.StoryTeller;
import com.github.arkadiuss2.cavetravel.domain.character.CharacterGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class SimpleEngineTest {

    private Engine engine;
    private FightEngine fightEngine;
    private StoryTeller storyTeller;

    @BeforeEach
    public void init() {
        storyTeller = mock(StoryTeller.class);
        fightEngine = mock(FightEngine.class);

        FightResult fightResult = new FightResult();
        fightResult.setSummary(FightResult.Summary.WIN);

        when(fightEngine.fight(any(), any())).thenReturn(fightResult);

        engine = new SimpleEngine(storyTeller, fightEngine);
    }

    @Test
    public void shouldStartNewGame() {

        //given
        GameData initialGameData = new GameData();

        initialGameData.setGameMap(MapGenerator.generateMap(10, 10));
        initialGameData.setPlayer(CharacterGenerator.generatePlayer("John Wayne"));
        initialGameData.setPlayerPosition(new MapPosition(0, 0));

        //when
        GameData gameData = engine.starNewGame(initialGameData);
        //then
        assertTrue(gameData.isGameActive(), "game should be active");
        assertTrue(!gameData.isGameEnded(), "game should be active");
        verify(fightEngine, times(1)).fight(any(), any());
    }

    @Test
    public void shouldThrowExceptionAfterNewGameTest() {

        //given
        GameData initialGameData = new GameData();

        initialGameData.setGameMap(MapGenerator.generateMap(10, 10));
        initialGameData.setPlayer(CharacterGenerator.generatePlayer("John Wayne"));

        //when
        //then
        assertThrows(WrongEngineStateException.class, () -> engine.starNewGame(initialGameData));
    }

    @Test
    public void shouldMoveTopTest() {
        //given
        GameData initialGameData = getInitGameData();
        //when
        engine.starNewGame(initialGameData);
        engine.goTop();
        //then
        assertTrue(engine.getGameData().getPlayerPosition().getY() == 6);
    }

    @Test
    public void shouldMoveLeftTest() {
        //given
        GameData initialGameData = getInitGameData();
        //when
        engine.starNewGame(initialGameData);
        engine.goLeft();
        //then
        assertTrue(engine.getGameData().getPlayerPosition().getX() == 4);
    }

    @Test
    public void shouldMoveRightTest() {
        //given
        GameData initialGameData = getInitGameData();
        //when
        engine.starNewGame(initialGameData);
        engine.goRight();
        //then
        assertTrue(engine.getGameData().getPlayerPosition().getX() == 6);
    }

    @Test
    public void shouldMoveBotTest() {
        //given
        GameData initialGameData = getInitGameData();
        //when
        engine.starNewGame(initialGameData);
        engine.goBot();
        //then
        assertTrue(engine.getGameData().getPlayerPosition().getY() == 4);
    }

    @Test
    public void shouldLoadGameTest() {
        //given
        GameData initialGameData = getInitGameData();
        //when
        engine.loadGame(initialGameData);
        //then
        assertEquals(initialGameData, engine.getGameData());
    }
    @Test
    public void shouldThrowErrorWhileLoadingGameTest() {
        //given
        GameData initialGameData = getInitGameData();
        initialGameData.setPlayerPosition(MapPosition.EMPTY);
        //when
        //then
        assertThrows(WrongEngineStateException.class, () -> engine.loadGame(initialGameData));
    }


    private GameData getInitGameData() {
        GameData initialGameData = new GameData();

        initialGameData.setGameMap(MapGenerator.generateMap(10, 10));
        initialGameData.setPlayer(CharacterGenerator.generatePlayer("John Wayne"));

        MapPosition playerPosition = new MapPosition(5, 5);
        initialGameData.setPlayerPosition(playerPosition);
        return initialGameData;
    }


}
