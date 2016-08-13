package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;

public class Game {

    private PrintStream printStream;
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    private Player currentPlayer;

    public Game(PrintStream printStream, Board board, Player firstPlayer, Player secondPlayer) {
        this.printStream = printStream;
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        board.initialize();
        board.show();
        currentPlayer = firstPlayer;

        while(!board.isFull())
            doTurn();

        printStream.println("Game is a draw");
    }

    public void doTurn() {
        currentPlayer.takeTurn();
        swapPlayers();
        board.show();
    }

    private void swapPlayers() {
        if(currentPlayer == firstPlayer)
            currentPlayer = secondPlayer;
        else
            currentPlayer = firstPlayer;
    }

}
