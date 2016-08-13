package com.thoughtworks.tictactoe;

import com.thoughtworks.tictactoe.tfoster.Board;
import com.thoughtworks.tictactoe.tfoster.Game;
import com.thoughtworks.tictactoe.tfoster.Player;

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
        Player firstPlayer = new Player(markers.get(0), board, printStream, new BufferedReader(new InputStreamReader(System.in)));
        Player secondPlayer = new Player(markers.get(1), board, printStream, new BufferedReader(new InputStreamReader(System.in)));
        Game game = new Game(printStream, board, firstPlayer, secondPlayer);
        game.play();
    }
}
