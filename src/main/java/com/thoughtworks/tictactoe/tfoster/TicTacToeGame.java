package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;

public class TicTacToeGame {

    private PrintStream printStream;
    private Board board;
    private TicTacToePlayer firstPlayer;
    private TicTacToePlayer secondPlayer;

    public TicTacToeGame(PrintStream printStream, Board board, TicTacToePlayer firstPlayer, TicTacToePlayer secondPlayer) {
        this.printStream = printStream;
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        board.initialize();
        board.show();
        doRound(firstPlayer);
    }

    public void doRound(TicTacToePlayer player) {
        int playerSlotChoice = player.makeChoice();
        board.mark(playerSlotChoice, "X");
        board.show();
    }
}
