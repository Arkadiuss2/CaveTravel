package com.github.arkadiuss2.cavetravel.engine.map.commands;

import com.github.arkadiuss2.cavetravel.engine.Engine;
import com.github.arkadiuss2.cavetravel.engine.commands.AbstractCommand;

public abstract class AbstractGoCommand extends AbstractCommand {

    private Engine engine;

    public AbstractGoCommand(Engine engine) {
        this.engine = engine;
    }

    protected boolean isGoCommand(String[] splitInput) {
        return "go".equals(splitInput[0]) &&
                splitInput.length == 2 &&
                Direction.getDirection(splitInput[1]).isPresent();
    }

    public Engine getEngine() {
        return engine;
    }


}
