package com.thoughtworks.tictactoe.tfoster;

public interface Player {
    void takeTurn();
    boolean hasWon();
    String name();
}
