package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.cmd.commands.HelpCommand;
import com.github.arkadiuss2.cavetravel.engine.cmd.commands.NewCommand;
import com.github.arkadiuss2.cavetravel.engine.map.commands.BotGoCommand;
import com.github.arkadiuss2.cavetravel.engine.map.commands.LeftGoCommand;
import com.github.arkadiuss2.cavetravel.engine.map.commands.RightGoCommand;
import com.github.arkadiuss2.cavetravel.engine.map.commands.TopGoCommand;
import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.StoryTeller;

import java.util.ArrayList;
import java.util.List;

public class CaveFactory {


    public List<Command> getCmdCommandList() {
        List<Command> commands = new ArrayList<>();
        commands.add(getNewCommand());

        //todo WARN:find better solution for this (reference to this.list into list object)
        commands.add(getHelpCommand(commands));
        return commands;
    }


    public List<Command> getMapCommandList() {
        List<Command> commands = new ArrayList<>();

        //todo WARN:find better solution for this (reference to this.list into list object)
        commands.add(getHelpCommand(commands));
        commands.add(getTopGoCommand());
        commands.add(getBotGoCommand());
        commands.add(getRightGoCommand());
        commands.add(getLeftGoCommand());

        return commands;
    }

    public Engine getEngine() {
        return new Engine(getMapCommandList(), getStoryTeller());
    }

    public StoryTeller getStoryTeller() {
        return new StoryTeller();
    }

    public Command getHelpCommand(List<Command> commands) {
        return new HelpCommand(commands);
    }

    public Command getNewCommand() {
        return new NewCommand(getEngine());
    }

    public Command getTopGoCommand() {
        return new TopGoCommand();
    }

    public Command getBotGoCommand() {
        return new BotGoCommand();
    }

    public Command getRightGoCommand() {
        return new RightGoCommand();
    }

    public Command getLeftGoCommand() {
        return new LeftGoCommand();
    }


}
