package com.github.arkadiuss2.cavetravel.cmd.commands;

public class HelpCommand implements Command {

    @Override
    public boolean isMatched(String[] splitInput) {
        return (splitInput.length == 1 && "help".equals(splitInput[0]));

    }

    @Override
    public CommandCategory getCategory() {
        return null;
    }

    public void execute() {
        System.out.println("Say 'new' to start a new game");
        System.out.println("Say 'load gameName' to load a game");
        System.out.println("Say 'save gameName' to save a game");
    }


}
