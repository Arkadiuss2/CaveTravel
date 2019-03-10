package com.github.arkadiuss2.cavetravel.application.engine.commands.game.map;

import com.github.arkadiuss2.cavetravel.application.engine.commands.AbstractCommand;
import com.github.arkadiuss2.cavetravel.application.engine.core.Engine;

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

    public Engine getSimpleEngine() {
        return engine;
    }


}
