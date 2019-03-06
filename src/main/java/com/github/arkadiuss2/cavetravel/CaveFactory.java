package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.cmd.commands.Command;
import com.github.arkadiuss2.cavetravel.cmd.commands.HelpCommand;
import com.github.arkadiuss2.cavetravel.cmd.commands.NewCommand;
import com.github.arkadiuss2.cavetravel.cmd.commands.moves.BotGoCommand;
import com.github.arkadiuss2.cavetravel.cmd.commands.moves.LeftGoCommand;
import com.github.arkadiuss2.cavetravel.cmd.commands.moves.RightGoCommand;
import com.github.arkadiuss2.cavetravel.cmd.commands.moves.TopGoCommand;

import java.util.ArrayList;
import java.util.List;

public class CaveFactory {

    public static List<Command> getCommandList() {
        List<Command> commands = new ArrayList<>();

        commands.add(getHelpCommand());
        commands.add(getNewCommand());
        commands.add(getTopGoCommand());
        commands.add(getBotGoCommand());
        commands.add(getRightGoCommand());
        commands.add(getLeftGoCommand());

        return commands;

    }

    public static Command getHelpCommand() {
        return new HelpCommand();
    }

    public static Command getNewCommand() {
        return new NewCommand();
    }

    public static Command getTopGoCommand() {
        return new TopGoCommand();
    }

    public static Command getBotGoCommand() {
        return new BotGoCommand();
    }

    public static Command getRightGoCommand() {
        return new RightGoCommand();
    }

    public static Command getLeftGoCommand() {
        return new LeftGoCommand();
    }

}
