package com.github.arkadiuss2.cavetravel.engine.map.commands;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.commands.Command;
import com.github.arkadiuss2.cavetravel.engine.commands.CommandCategory;

public abstract class AbstractGoCommand implements Command {

    private Engine engine;

    public AbstractGoCommand(Engine engine) {
        this.engine = engine;
    }

    protected boolean isGoCommand(String[] splitInput) {
        return "go".equals(splitInput[0]) &&
                splitInput.length == 2 &&
                Direction.getDirection(splitInput[1]).isPresent();
    }

    @Override
    public abstract boolean isMatched(String[] splitInput);

    @Override
    public abstract CommandCategory getCategory();

    @Override
    public abstract void execute();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
