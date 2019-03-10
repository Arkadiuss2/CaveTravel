package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.FightEngine;
import com.github.arkadiuss2.cavetravel.engine.StoryTeller;
import com.github.arkadiuss2.cavetravel.engine.cmd.commands.*;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.commands.StatisticCommand;
import com.github.arkadiuss2.cavetravel.engine.map.commands.BotGoCommand;
import com.github.arkadiuss2.cavetravel.engine.map.commands.LeftGoCommand;
import com.github.arkadiuss2.cavetravel.engine.map.commands.RightGoCommand;
import com.github.arkadiuss2.cavetravel.engine.map.commands.TopGoCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Simple Factory instead of IOC framework - no external lib can be used.
 */
public class CaveFactory {

    private final FightEngine fightEngine = new FightEngine();
    private final StoryTeller storyTeller = new StoryTeller();
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

    public Engine getEngine() {
        if (engine == null) {
            engine = new Engine(getStoryTeller(), getFightEngine());
        }
        return engine;
    }


    public FightEngine getFightEngine() {
        return fightEngine;
    }

    public StoryTeller getStoryTeller() {
        return storyTeller;
    }

    public Command getHelpCommand(List<Command> commandsNames) {
        List<String> commandNames = commandsNames.stream().map(command -> command.getCommandName()).collect(Collectors.toList());
        return new HelpCommand(commandNames);
    }

    public Command getNewCommand() {
        return new NewCommand(getEngine());
    }

    public Command getTopGoCommand() {
        return new TopGoCommand(getEngine());
    }

    public Command getBotGoCommand() {
        return new BotGoCommand(getEngine());
    }

    public Command getRightGoCommand() {
        return new RightGoCommand(getEngine());
    }

    public Command getLeftGoCommand() {
        return new LeftGoCommand(getEngine());
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
        List<Command> commandsMenuState = new ArrayList<>();

        commandsMenuState.addAll(getMenuCommandList());
        commandsMenuState.add(getHelpCommand(getMenuCommandList()));
        menuState.setCommands(commandsMenuState);
        return menuState;
    }

    public Command getStatisticCommand() {
        return new StatisticCommand(getEngine());
    }

    public Command getExitCommand(){
        return new ExitCommand();
    }

}
