package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;

public class Board {

    public static final String COL_SEPARATOR = "|";
    public static final String ROW_SEPARATOR = "-----";
    private Collection<String> markers;
    private PrintStream printStream;
    private List<String> slots;

    public Board(Collection<String> markers, PrintStream printStream, List<String> slots) {
        this.markers = markers;
        this.printStream = printStream;
        this.slots = slots;
    }

    public void initialize() {
        slots.clear();
        for(int i = 1; i <= 9; ++i)
            slots.add(String.valueOf(i));
    }

    public void show() {
        String toShow = String.format("%s" + COL_SEPARATOR + "%s" + COL_SEPARATOR + "%s" + "\n" +
                                        ROW_SEPARATOR + "\n" +
                                      "%s" + COL_SEPARATOR + "%s" + COL_SEPARATOR + "%s" + "\n" +
                                        ROW_SEPARATOR + "\n" +
                                      "%s" + COL_SEPARATOR + "%s" + COL_SEPARATOR + "%s", slots.toArray());

        printStream.println(toShow);
    }

    public void mark(int slot, String letter) {
        slots.set(slot - 1, letter);
    }

    public boolean isTaken(int slot) {
        return markers.contains(slots.get(slot - 1));
    }

    public boolean isFull() {
        for(int i = 0; i < slots.size(); ++i)
            if(!isTaken(i + 1))
                return false;
        return true;
    }

    public boolean hasThreeInARow(String marker) {
        for(int i = 0; i <= 2; ++i) {
            if(slots.get(3 * i).equals(marker) &&
                    slots.get(3 * i + 1).equals(marker) &&
                    slots.get(3 * i + 2).equals(marker))
                return true;
        }
        return false;
    }
}
