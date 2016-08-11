package com.thoughtworks.tictactoe;

import com.thoughtworks.tictactoe.tfoster.Board;
import com.thoughtworks.tictactoe.tfoster.TicTacToeGame;
import com.thoughtworks.tictactoe.tfoster.TicTacToePlayer;

import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Board board = new Board(printStream, new ArrayList<String>());
        TicTacToePlayer firstPlayer = new TicTacToePlayer();
        TicTacToeGame game = new TicTacToeGame(printStream, board, firstPlayer);
        game.play();
    }
}
