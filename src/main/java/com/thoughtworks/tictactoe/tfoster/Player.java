package com.thoughtworks.tictactoe.tfoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private String name;
    private String marker;
    private Board board;
    private PrintStream printStream;
    private BufferedReader reader;

    public Player(String name, String marker, Board board, PrintStream printStream, BufferedReader reader) {
        this.name = name;
        this.marker = marker;
        this.board = board;
        this.printStream = printStream;
        this.reader = reader;
    }

    public void takeTurn() {

        printStream.println("Input the number of the slot where you want your mark");

        int playerSlotChoice = getPlayerInput();
        while(board.isTaken(playerSlotChoice)) {
            printStream.println("Location already taken");
            playerSlotChoice = getPlayerInput();
        }

        board.mark(playerSlotChoice, marker);
    }

    private int getPlayerInput() {
        printStream.print("> ");

        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean hasWon() {
        return board.hasThreeInARow(marker) || board.hasThreeInAColumn(marker) || board.hasThreeInADiagonal(marker);
    }

    public String name() {
        return name;
    }
}
