package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeGameTest {

    private PrintStream printStream;
    private TicTacToeGame ticTacToeGame;
    private Board board;
    private TicTacToePlayer firstPlayer;
    private TicTacToePlayer secondPlayer;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        firstPlayer = mock(TicTacToePlayer.class);
        secondPlayer = mock(TicTacToePlayer.class);
        ticTacToeGame = new TicTacToeGame(printStream, board, firstPlayer, secondPlayer);
    }

    @Test
    public void shouldInitializeBoardWhenGameIsStarted() throws Exception {
        ticTacToeGame.play();

        verify(board).initialize();
    }

    @Test
    public void shouldSeeBoardWhenGameIsStarted() throws Exception {
        ticTacToeGame.play();

        verify(board, atLeastOnce()).show();
    }

    @Test
    public void shouldMarkFirstSlotOnBoardAsXWhenFirstPlayerSelectsXInFirstSlot() throws Exception {
        when(firstPlayer.makeChoice()).thenReturn(1);
        ticTacToeGame.doRound(firstPlayer, "X");

        verify(board).mark(1, "X");
    }

    @Test
    public void shouldMarkSecondSlotOnBoardAsXWhenFirstPlayerSelectsXInSecondSlot() throws Exception {
        when(firstPlayer.makeChoice()).thenReturn(2);
        ticTacToeGame.doRound(firstPlayer, "X");

        verify(board).mark(2, "X");
    }

    @Test
    public void shouldMarkThirdSlotOnBoardAsOWhenSecondPlayerSelectsThirdSlot() throws Exception {
        when(secondPlayer.makeChoice()).thenReturn(3);
        ticTacToeGame.doRound(secondPlayer, "O");

        verify(board).mark(3, "O");
    }

    @Test
    public void shouldKeepPollingPlayerWhileSlotChoiceIsAlreadyTaken() throws Exception {
        when(board.isTaken(anyInt())).thenReturn(true, true, false, true);
        ticTacToeGame.doRound(firstPlayer, "X");

        verify(board, times(3)).isTaken(anyInt());
        verify(board).mark(anyInt(), anyString());
    }
}