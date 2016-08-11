package com.thoughtworks.tictactoe.tfoster;

import java.io.BufferedReader;
import java.io.IOException;

public class TicTacToePlayer {

    private BufferedReader reader;

    public TicTacToePlayer(BufferedReader reader) {
        this.reader = reader;
    }

    public int makeChoice() {
        String playerInput = "";
        try {
            playerInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(playerInput);
    }
}
