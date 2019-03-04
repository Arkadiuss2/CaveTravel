package com.github.arkadiuss2.cavetravel.cmd.commands;

import com.github.arkadiuss2.cavetravel.domain.character.PlayerCharacter;
import com.github.arkadiuss2.cavetravel.engine.CharacterGenerator;
import com.github.arkadiuss2.cavetravel.engine.Engine;

import static com.github.arkadiuss2.cavetravel.cmd.commands.ConsoleInput.getRawInput;

public class NewCommand implements Command {


    @Override
    public void execute() {
        System.out.println("Starting new game..");
        System.out.println("What is your name Wanderer?");

        PlayerCharacter player = CharacterGenerator.generatePlayer(getRawInput());

        Engine engine = new Engine();
        engine.starNewGame(player);
    }


}
