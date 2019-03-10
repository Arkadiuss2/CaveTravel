package com.github.arkadiuss2.cavetravel.application.engine.commands.cmd;

import com.github.arkadiuss2.cavetravel.application.cmd.Input;
import com.github.arkadiuss2.cavetravel.application.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.application.engine.core.Engine;
import com.github.arkadiuss2.cavetravel.application.engine.map.MapGenerator;
import com.github.arkadiuss2.cavetravel.application.engine.map.MapPosition;
import com.github.arkadiuss2.cavetravel.application.engine.persistance.GameData;
import com.github.arkadiuss2.cavetravel.domain.character.CharacterGenerator;

public class NewCommand extends AbstractCommand {

    private Input input;
    private Engine engine;


    public NewCommand(Input input, Engine engine) {
        this.input = input;
        this.engine = engine;
    }

    @Override
    public String getCommandName() {
        return "new";
    }

    @Override
    public boolean isMatched() {
        return getSplitInput().length == 1 && "new".equals(getSplitInput()[0]);
    }

    @Override
    public GameData execute() {
        System.out.println("Starting new game..");
        System.out.println("What is your name Wanderer?");

        GameData gameData = new GameData();
        gameData.setPlayer(CharacterGenerator.generatePlayer(input.getRawInput()));
        gameData.setGameMap(MapGenerator.generateMap(10, 10));
        gameData.setPlayerPosition(new MapPosition(0, 0));

        return engine.starNewGame(gameData);
    }


}
