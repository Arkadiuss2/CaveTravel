package com.github.arkadiuss2.cavetravel.application.cmd;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInput implements Input {

    private InputStream in = System.in;

    @Override
    public String getRawInput() {
        Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }

    @Override
    public String[] getSplitInput() {
        String rawInput = getRawInput().trim().toLowerCase();
        return rawInput.split(" ");
    }


}
