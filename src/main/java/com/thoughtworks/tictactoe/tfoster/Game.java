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
        beginGame();
        while(!board.isFull() && !currentPlayer.hasWon())
            doTurn();
        endGame();
    }

    private void doTurn() {
        currentPlayer.takeTurn();
        if(!currentPlayer.hasWon())
            swapPlayers();
        board.show();
    }

    private void beginGame() {
        board.initialize();
        currentPlayer = firstPlayer;
        board.show();
    }

    private void endGame() {
        if(currentPlayer.hasWon())
            printStream.println(currentPlayer.name() + " Wins!");
        else
            printStream.println("Game is a draw");
    }

    private void swapPlayers() {
        if(currentPlayer == firstPlayer)
            currentPlayer = secondPlayer;
        else
            currentPlayer = firstPlayer;
    }

}
