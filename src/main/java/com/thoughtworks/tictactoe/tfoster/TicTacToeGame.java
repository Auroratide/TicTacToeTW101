package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;

public class TicTacToeGame {

    private PrintStream printStream;

    public TicTacToeGame(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void play() {
        showBoard();
    }

    private void showBoard() {
        printStream.println("1|2|3");
        printStream.println("-----");
        printStream.println("4|5|6");
        printStream.println("-----");
        printStream.println("7|8|9");
    }
}
