package com.github.arkadiuss2.cavetravel.cmd.commands.moves;

import java.util.Optional;

public enum Direction {
    TOP, BOT, RIGHT, LEFT;

    public static Optional<Direction> getDirection(String value) {

        Optional<Direction> result = Optional.empty();

        if (value == null) {
            return result;
        }

        switch (value) {
            case "top": {
                result = Optional.of(Direction.TOP);
                break;
            }
            case "bot": {
                result = Optional.of(Direction.BOT);
                break;
            }
            case "bottom": {
                result = Optional.of(Direction.BOT);
                break;
            }
            case "left": {
                result = Optional.of(Direction.LEFT);
                break;
            }
            case "right": {
                result = Optional.of(Direction.RIGHT);
                break;
            }
        }
        return result;
    }

}
