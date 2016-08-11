package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeGameTest {

    private PrintStream printStream;
    private TicTacToeGame ticTacToeGame;
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    private void stopGameImmediately() {
        when(board.isFull(anyString())).thenReturn(true);
    }

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        firstPlayer = mock(Player.class);
        secondPlayer = mock(Player.class);
        ticTacToeGame = new TicTacToeGame(printStream, board, firstPlayer, secondPlayer);
    }

    @Test
    public void shouldInitializeBoardWhenGameIsStarted() throws Exception {
        stopGameImmediately();
        ticTacToeGame.play();

        verify(board).initialize();
    }

    @Test
    public void shouldSeeBoardWhenGameIsStarted() throws Exception {
        stopGameImmediately();
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
        when(board.isTaken(anyInt(), anyString())).thenReturn(true, true, false, true);
        ticTacToeGame.doRound(firstPlayer, "X");

        verify(board, times(3)).isTaken(anyInt(), anyString());
        verify(board).mark(anyInt(), anyString());
    }

    @Test
    public void shouldInformPlayerWhenTakenSlotWasSelected() throws Exception {
        when(board.isTaken(anyInt(), anyString())).thenReturn(true, false);
        ticTacToeGame.doRound(firstPlayer, "X");

        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldTerminateRoundsWhenBoardIsAlreadyFull() throws Exception {
        when(board.isFull(anyString())).thenReturn(true, false);
        ticTacToeGame.play();

        verify(board).isFull(anyString());
    }

    @Test
    public void shouldKeepDoingRoundsUntilBoardIsFull() throws Exception {
    //  Note: In this test, we don't care about whether the players alternate
        when(board.isFull(anyString())).thenReturn(false, true, false);
        ticTacToeGame.play();

        verify(board, times(2)).isFull(anyString());
    }

    @Test
    public void shouldClaimGameIsADrawWhenGameIsOver() throws Exception {
        stopGameImmediately();
        ticTacToeGame.play();

        verify(printStream).println("Game is a draw");
    }
}