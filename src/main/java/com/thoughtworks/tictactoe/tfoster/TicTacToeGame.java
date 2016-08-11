package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;

public class TicTacToeGame {

    private PrintStream printStream;
    private Board board;

    public TicTacToeGame(PrintStream printStream, Board board, TicTacToePlayer firstPlayer) {
        this.printStream = printStream;
        this.board = board;
    }

    public void play() {
        board.showBoard();
    }

}
