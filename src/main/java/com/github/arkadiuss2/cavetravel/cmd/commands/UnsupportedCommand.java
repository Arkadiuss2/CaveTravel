package com.github.arkadiuss2.cavetravel.cmd.commands;

public class UnsupportedCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Unrecognized command say 'help' to checkout all commands");
    }
}
