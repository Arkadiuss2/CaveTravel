package com.github.arkadiuss2.cavetravel.engine.cmd.commands;

import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class LoadCommand<Void> implements Command<Void> {


    @Override
    public String getCommandName() {
        return "load";
    }

    @Override
    public boolean isMatched(String[] splitInput) {
        return splitInput.length == 2 && "load".equals(splitInput[0]);
    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    @Override
    public Void execute() {
        return null;
    }


}
