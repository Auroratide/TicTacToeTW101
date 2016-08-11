package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;
import java.util.List;

public class Board {

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

    public void showBoard() {
        printStream.println("1|2|3");
        printStream.println("-----");
        printStream.println("4|5|6");
        printStream.println("-----");
        printStream.println("7|8|9");
    }

    public void mark(int slot, String letter) {

    }
}
