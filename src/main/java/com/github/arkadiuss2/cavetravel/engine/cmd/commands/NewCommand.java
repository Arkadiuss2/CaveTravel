package com.github.arkadiuss2.cavetravel.engine.cmd.commands;

import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.engine.CharacterGenerator;
import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;
import com.github.arkadiuss2.cavetravel.engine.map.MapGenerator;
import com.github.arkadiuss2.cavetravel.engine.map.MapPosition;

import static com.github.arkadiuss2.cavetravel.engine.cmd.ConsoleInput.getRawInput;

public class NewCommand implements Command {

    private Engine engine;

    public NewCommand(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getCommandName() {
        return "new";
    }

    @Override
    public boolean isMatched(String[] splitInput) {
        return splitInput.length == 1 && "new".equals(splitInput[0]);
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public void execute() {
        System.out.println("Starting new game..");
        System.out.println("What is your name Wanderer?");

        PlayerCharacter player = CharacterGenerator.generatePlayer(getRawInput());

        engine.setPlayer(player);
        engine.setMap(MapGenerator.generateMap(10,10));
        engine.setPlayerPosition(MapPosition.position(0,0));

        engine.starNewGame();
    }


}
