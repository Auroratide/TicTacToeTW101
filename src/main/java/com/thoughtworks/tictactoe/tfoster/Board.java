package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;
import java.util.List;

public class Board {

    public static final String SEPARATOR = "|";
    public static final String ROW_SEPARATOR = "-----";
    private PrintStream printStream;
    private List<String> slots;

    public Board(PrintStream printStream, List<String> slots) {
        this.printStream = printStream;
        this.slots = slots;
    }

    public void initialize() {
        slots.clear();
        for(int i = 1; i <= 9; ++i)
            slots.add(String.valueOf(i));
    }

    public void show() {
        String toShow = String.format("%s" + SEPARATOR + "%s" + SEPARATOR + "%s" + "\n" +
                                        ROW_SEPARATOR + "\n" +
                                      "%s" + SEPARATOR + "%s" + SEPARATOR + "%s" + "\n" +
                                        ROW_SEPARATOR + "\n" +
                                      "%s" + SEPARATOR + "%s" + SEPARATOR + "%s", slots.toArray());

        printStream.println(toShow);
    }

    public void mark(int slot, String letter) {
        slots.set(slot - 1, letter);
    }

    public boolean isTaken(int slot, String validTokens) {
    //  validTokens represents tokens that can be construed as occupying a square.
    //  For Tic Tac Toe, this is probably "XO"; allows Board to not be bound to X and O exclusively
        return validTokens.contains(slots.get(slot - 1));
    }
}
