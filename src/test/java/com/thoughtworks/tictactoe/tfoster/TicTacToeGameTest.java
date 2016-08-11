package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TicTacToeGameTest {

    private PrintStream printStream;
    private TicTacToeGame ticTacToeGame;
    private Board board;
    private TicTacToePlayer firstPlayer;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        firstPlayer = mock(TicTacToePlayer.class);
        ticTacToeGame = new TicTacToeGame(printStream, board, firstPlayer);
    }

    @Test
    public void shouldInitializeBoardWhenGameIsStarted() throws Exception {
        ticTacToeGame.play();

        verify(board).initialize();
    }

    @Test
    public void shouldSeeBoardWhenGameIsStarted() throws Exception {
        ticTacToeGame.play();

        verify(board).show();
    }

    @Test
    public void shouldMarkFirstSlotOnBoardAsXWhenFirstPlayerSelectsXInFirstSlot() throws Exception {
        when(firstPlayer.makeChoice()).thenReturn(1);
        ticTacToeGame.doRound(firstPlayer);

        verify(board).mark(1, "X");
    }

    @Test
    public void shouldMarkSecondSlotOnBoardAsXWhenFirstPlayerSelectsXInSecondSlot() throws Exception {
        when(firstPlayer.makeChoice()).thenReturn(2);
        ticTacToeGame.doRound(firstPlayer);

        verify(board).mark(2, "X");
    }
}