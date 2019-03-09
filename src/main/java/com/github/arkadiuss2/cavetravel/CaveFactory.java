package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.engine.CommandMapOperation;
import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.FightEngine;
import com.github.arkadiuss2.cavetravel.engine.StoryTeller;
import com.github.arkadiuss2.cavetravel.engine.cmd.commands.HelpCommand;
import com.github.arkadiuss2.cavetravel.engine.cmd.commands.NewCommand;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.map.commands.*;

import java.util.ArrayList;
import java.util.List;

public class CaveFactory {

    private final FightEngine fightEngine = new FightEngine();
    private final StoryTeller storyTeller = new StoryTeller();
    private List<Command<Direction>> mapCommands;
    private List<Command<Void>> cmdCommands;
    private Engine engine;

    public List<Command<Void>> getCmdCommandList() {
        if (cmdCommands == null) {
            cmdCommands = new ArrayList<>();
            cmdCommands.add(getNewCommand());

            //todo WARN:find better solution for this (reference to this.list into list object)
            cmdCommands.add(getHelpCommand(cmdCommands));
        }
        return cmdCommands;
    }


    public List<Command<Direction>> getMapCommandList() {
        if (mapCommands == null) {
            mapCommands = new ArrayList<>();

            //todo WARN:find better solution for this (reference to this.list into list object)
            mapCommands.add(getHelpCommand(mapCommands));
            mapCommands.add(getTopGoCommand());
            mapCommands.add(getBotGoCommand());
            mapCommands.add(getRightGoCommand());
            mapCommands.add(getLeftGoCommand());
        }
        return mapCommands;
    }

    public Engine getEngine() {
        if (engine == null) {
            engine = new Engine(getCommandMapOperation(), getStoryTeller(), getFightEngine());
        }
        return engine;
    }

    public CommandMapOperation getCommandMapOperation() {
        return new CommandMapOperation(getMapCommandList());
    }

    public FightEngine getFightEngine() {
        return fightEngine;
    }

    public StoryTeller getStoryTeller() {
        return storyTeller;
    }

    public <T> Command<T> getHelpCommand(List<Command<T>> commands) {
        return new HelpCommand(commands);
    }

    public Command<Void> getNewCommand() {
        return new NewCommand(getEngine());
    }

    public Command<Direction> getTopGoCommand() {
        return new TopGoCommand();
    }

    public Command<Direction> getBotGoCommand() {
        return new BotGoCommand();
    }

    public Command<Direction> getRightGoCommand() {
        return new RightGoCommand();
    }

    public Command<Direction> getLeftGoCommand() {
        return new LeftGoCommand();
    }


}
