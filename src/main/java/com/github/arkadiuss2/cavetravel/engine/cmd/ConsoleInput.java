package com.github.arkadiuss2.cavetravel.engine.cmd;

import java.util.Scanner;

public class ConsoleInput {

    public static String getRawInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim().toLowerCase();
    }

    public static String[] getSplitInput() {
        String rawInput = getRawInput();
        return rawInput.split(" ");
    }


}
