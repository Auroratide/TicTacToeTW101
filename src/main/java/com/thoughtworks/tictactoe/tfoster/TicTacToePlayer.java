package com.thoughtworks.tictactoe.tfoster;

import java.io.BufferedReader;

public class TicTacToePlayer {

    private BufferedReader reader;

    public TicTacToePlayer(BufferedReader reader) {
        this.reader = reader;
    }

    public int makeChoice() {
        return 1;
    }
}
