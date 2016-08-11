package com.thoughtworks.tictactoe.tfoster;

import java.io.PrintStream;

public class TicTacToeGame {

    public static final String FIRST_PLAYER_MARKER = "X";
    public static final String SECOND_PLAYER_MARKER = "O";

    private PrintStream printStream;
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    public TicTacToeGame(PrintStream printStream, Board board, Player firstPlayer, Player secondPlayer) {
        this.printStream = printStream;
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        board.initialize();
        board.show();
        doRound(firstPlayer, FIRST_PLAYER_MARKER);
        doRound(secondPlayer, SECOND_PLAYER_MARKER);
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
}
