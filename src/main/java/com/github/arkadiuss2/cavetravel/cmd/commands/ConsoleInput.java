package com.github.arkadiuss2.cavetravel.cmd.commands;

import com.github.arkadiuss2.cavetravel.domain.commands.Move;

import java.util.Optional;
import java.util.Scanner;

import static com.github.arkadiuss2.cavetravel.domain.commands.Move.*;

public class ConsoleInput {

    public static String getRawInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public static Optional<Move> getMapInput() {
        String rawInput = getRawInput();
        String[] split = rawInput.split(" ");
        String secondWord = split[1];

        Optional<Move> result = Optional.empty();

        System.out.println(secondWord);
        if (split.length == 2) {
            if ("go".equals(split[0])) {
                switch (secondWord) {
                    case "top": {
                        result = Optional.of(TOP);
                        break;
                    }
                    case "bot": {
                        result = Optional.of(BOT);
                        break;
                    }
                    case "bottom": {
                        result = Optional.of(BOT);
                        break;
                    }
                    case "right": {
                        result = Optional.of(RIGHT);
                        break;
                    }
                    case "left": {
                        result = Optional.of(LEFT);
                        break;
                    }
                }
            }
        }

        return result;
    }


    public static Command getMenuInput() {
        String rawInput = getRawInput();
        Command result;

        switch (rawInput) {
            case "help": {
                result = new HelpCommand();
                break;
            }
            case "new": {
                result = new NewCommand();
                break;
            }
            case "load": {
                result = new LoadCommand();
                break;
            }
            default: {
                result = new UnsupportedCommand();
            }
        }

        return result;
    }


}
