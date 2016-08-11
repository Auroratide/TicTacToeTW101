package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeGameTest {

    private PrintStream printStream;
    private TicTacToeGame ticTacToeGame;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        ticTacToeGame = new TicTacToeGame(printStream, board);
    }

    @Test
    public void shouldSeeBoardWhenGameIsStarted() throws Exception {
        ticTacToeGame.play();

        verify(board).showBoard();
    }

}