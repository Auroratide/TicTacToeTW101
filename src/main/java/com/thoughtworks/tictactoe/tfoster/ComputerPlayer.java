package com.thoughtworks.tictactoe.tfoster;

public class ComputerPlayer implements Player {

    private String name;
    private String marker;
    private Board board;

    public ComputerPlayer(String name, String marker, Board board) {
        this.name = name;
        this.marker = marker;
        this.board = board;
    }

    @Override
    public void takeTurn() {
        int slot = 1;
        while(board.isTaken(slot))
            ++slot;
        board.mark(slot, marker);
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public String name() {
        return name;
    }
}
