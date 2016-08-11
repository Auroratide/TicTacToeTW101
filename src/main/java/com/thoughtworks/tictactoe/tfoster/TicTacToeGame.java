package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;

public class TicTacToeGame {

    public static final String FIRST_PLAYER_MARKER = "X";
    public static final String SECOND_PLAYER_MARKER = "O";

    private PrintStream printStream;
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    private Player currentPlayer;
    private String currentMarker;

    public TicTacToeGame(PrintStream printStream, Board board, Player firstPlayer, Player secondPlayer) {
        this.printStream = printStream;
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        board.initialize();
        board.show();

    //  This is very smelly.  Needs refactoring, but it's 5:30 now.
    //  Probably should offboard the marker information to player.
        currentPlayer = firstPlayer;
        currentMarker = FIRST_PLAYER_MARKER;

        while(!board.isFull(FIRST_PLAYER_MARKER + SECOND_PLAYER_MARKER)) {
            doRound(currentPlayer, currentMarker);
            swapPlayers();
            swapMarkers();
        }

        printStream.println("Game is a draw");
    }

    public void doRound(Player player, String marker) {
        int playerSlotChoice = player.makeChoice();
        while(board.isTaken(playerSlotChoice, FIRST_PLAYER_MARKER + SECOND_PLAYER_MARKER)) {
            printStream.println("Location already taken");
            playerSlotChoice = player.makeChoice();
        }

        board.mark(playerSlotChoice, marker);
        board.show();
    }

    private void swapPlayers() {
        if(currentPlayer == firstPlayer)
            currentPlayer = secondPlayer;
        else
            currentPlayer = firstPlayer;
    }

    private void swapMarkers() {
        if(currentMarker.equals(FIRST_PLAYER_MARKER))
            currentMarker = SECOND_PLAYER_MARKER;
        else
            currentMarker = FIRST_PLAYER_MARKER;
    }
}
