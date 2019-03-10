package com.github.arkadiuss2.cavetravel.engine.commands;

public abstract class AbstractCommand implements Command {

    private String[] splitInput;

    public String[] getSplitInput() {
        return splitInput;
    }

    @Override
    public void setInputCommand(String[] splitInput) {
        this.splitInput = splitInput;
    }

}
