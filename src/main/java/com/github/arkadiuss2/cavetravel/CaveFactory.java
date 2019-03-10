package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.application.cmd.CommandWindowOperator;
import com.github.arkadiuss2.cavetravel.application.cmd.ConsoleInput;
import com.github.arkadiuss2.cavetravel.application.cmd.Input;
import com.github.arkadiuss2.cavetravel.application.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.application.engine.commands.cmd.*;
import com.github.arkadiuss2.cavetravel.application.engine.commands.game.StatisticCommand;
import com.github.arkadiuss2.cavetravel.application.engine.commands.game.map.BotGoCommand;
import com.github.arkadiuss2.cavetravel.application.engine.commands.game.map.LeftGoCommand;
import com.github.arkadiuss2.cavetravel.application.engine.commands.game.map.RightGoCommand;
import com.github.arkadiuss2.cavetravel.application.engine.commands.game.map.TopGoCommand;
import com.github.arkadiuss2.cavetravel.application.engine.core.Engine;
import com.github.arkadiuss2.cavetravel.application.engine.core.SimpleEngine;
import com.github.arkadiuss2.cavetravel.application.fight_engine.FightEngine;
import com.github.arkadiuss2.cavetravel.application.fight_engine.SimpleFightEngine;
import com.github.arkadiuss2.cavetravel.application.story_teller.SimpleStoryTeller;
import com.github.arkadiuss2.cavetravel.application.story_teller.StoryTeller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Simple Factory instead of IOC framework - no external lib can be used.
 */
public class CaveFactory {

    private final FightEngine fightEngine = new SimpleFightEngine();
    private final StoryTeller storyTeller = new SimpleStoryTeller();
    private List<Command> playCommands;
    private List<Command> menuCommands;
    private Engine engine;


    public List<Command> getMenuCommandList() {
        if (menuCommands == null) {
            menuCommands = new ArrayList<>();
            menuCommands.add(getNewCommand());
            menuCommands.add(getLoadCommand());
            menuCommands.add(getSaveCommand());
            menuCommands.add(getExitCommand());
        }
        return menuCommands;
    }

    public List<Command> getGameCommandList() {
        if (playCommands == null) {
            playCommands = new ArrayList<>();

            playCommands.add(getTopGoCommand());
            playCommands.add(getBotGoCommand());
            playCommands.add(getRightGoCommand());
            playCommands.add(getLeftGoCommand());
            playCommands.add(getStatisticCommand());
        }
        return playCommands;
    }

    public Engine getSimpleEngine() {
        if (engine == null) {
            engine = new SimpleEngine(getSimpleStoryTeller(), getSimpleFightEngine());
        }
        return engine;
    }


    public FightEngine getSimpleFightEngine() {
        return fightEngine;
    }

    public StoryTeller getSimpleStoryTeller() {
        return storyTeller;
    }

    public Command getHelpCommand(List<Command> commandsNames) {
        List<String> commandNames = commandsNames.stream().map(Command::getCommandName).collect(Collectors.toList());
        return new HelpCommand(commandNames);
    }

    public Command getNewCommand() {
        return new NewCommand(getConsoleInput(),getSimpleEngine());
    }

    public Command getTopGoCommand() {
        return new TopGoCommand(getSimpleEngine());
    }

    public Command getBotGoCommand() {
        return new BotGoCommand(getSimpleEngine());
    }

    public Command getRightGoCommand() {
        return new RightGoCommand(getSimpleEngine());
    }

    public Command getLeftGoCommand() {
        return new LeftGoCommand(getSimpleEngine());
    }


    public Command getLoadCommand() {
        return new LoadCommand(engine);
    }

    public Command getSaveCommand() {
        return new SaveCommand(engine);
    }

    public GameState getActiveGameState() {
        GameState activeGameState = new GameState();
        List<Command> commandsActiveState = new ArrayList<>();
        commandsActiveState.addAll(getMenuCommandList());
        commandsActiveState.addAll(getGameCommandList());

        Command helpCommand = getHelpCommand(commandsActiveState);
        commandsActiveState.add(helpCommand);
        activeGameState.setCommands(commandsActiveState);
        return activeGameState;
    }

    public GameState getMenuGameState() {
        GameState menuState = new GameState();

        List<Command> commandsMenuState = new ArrayList<>(getMenuCommandList());
        commandsMenuState.add(getHelpCommand(getMenuCommandList()));
        menuState.setCommands(commandsMenuState);
        return menuState;
    }

    public Command getStatisticCommand() {
        return new StatisticCommand(getSimpleEngine());
    }

    public Command getExitCommand() {
        return new ExitCommand();
    }

    public CommandWindowOperator geCommandWindowOperator() {
        return new CommandWindowOperator(getConsoleInput());
    }

    private Input getConsoleInput() {
        return new ConsoleInput();
    }

}
