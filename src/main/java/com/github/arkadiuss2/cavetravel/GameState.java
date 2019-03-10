package com.github.arkadiuss2.cavetravel;

import com.github.arkadiuss2.cavetravel.application.engine.commands.Command;

import java.util.List;

public class GameState {

    private List<Command> commands;

    public GameState(){
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

}
