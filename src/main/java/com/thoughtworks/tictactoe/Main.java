package com.thoughtworks.tictactoe;

import com.thoughtworks.tictactoe.tfoster.Board;
import com.thoughtworks.tictactoe.tfoster.TicTacToeGame;
import com.thoughtworks.tictactoe.tfoster.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Board board = new Board(printStream, new ArrayList<String>());
        Player firstPlayer = new Player("X", board, printStream, new BufferedReader(new InputStreamReader(System.in)));
        Player secondPlayer = new Player("O", board, printStream, new BufferedReader(new InputStreamReader(System.in)));
        TicTacToeGame game = new TicTacToeGame(printStream, board, firstPlayer, secondPlayer);
        game.play();
    }
}
