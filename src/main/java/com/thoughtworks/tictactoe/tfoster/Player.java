package com.thoughtworks.tictactoe.tfoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private PrintStream printStream;
    private BufferedReader reader;

    public Player(PrintStream printStream, BufferedReader reader) {
        this.printStream = printStream;
        this.reader = reader;
    }

    public int makeChoice() {
        printStream.println("Input the number of the slot where you want your mark");
        printStream.print("> ");

        String playerInput = "";
        try {
            playerInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(playerInput);
    }
}
