package com.github.arkadiuss2.cavetravel.application.engine.core;

import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;

public interface Engine {

    GameData starNewGame(GameData gameData);

    void loadGame(GameData gameData);

    GameData playLevel();

    GameData goTop();

    GameData goBot();

    GameData goLeft();

    GameData goRight();

    GameData getGameData();
}
