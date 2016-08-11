package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;

public class Board {

    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
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
