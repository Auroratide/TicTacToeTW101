package com.thoughtworks.tictactoe;

import com.thoughtworks.tictactoe.tfoster.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        List<String> markers = new ArrayList<>();
        markers.add("X");
        markers.add("O");
        Board board = new Board(markers, printStream, new ArrayList<String>());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Player firstPlayer = new HumanPlayer("Player 1", markers.get(0), board, printStream, reader);
//        Player secondPlayer = new HumanPlayer("Player 2", markers.get(1), board, printStream, reader);
        Player secondPlayer = new ComputerPlayer("Computer", markers.get(1), board);
        Game game = new Game(printStream, board, firstPlayer, secondPlayer);
        game.play();
    }
}
