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
        slots.add("1");
        slots.add("2");
        slots.add("3");
        slots.add("4");
        slots.add("5");
        slots.add("6");
        slots.add("7");
        slots.add("8");
        slots.add("9");
    }

    public void show() {
        printStream.println(slots.get(0) + SEPARATOR + slots.get(1) + SEPARATOR + slots.get(2));
        printStream.println(ROW_SEPARATOR);
        printStream.println(slots.get(3) + SEPARATOR + slots.get(4) + SEPARATOR + slots.get(5));
        printStream.println(ROW_SEPARATOR);
        printStream.println(slots.get(6) + SEPARATOR + slots.get(7) + SEPARATOR + slots.get(8));
    }

    public void mark(int slot, String letter) {
        slots.set(slot - 1, letter);
    }
}
