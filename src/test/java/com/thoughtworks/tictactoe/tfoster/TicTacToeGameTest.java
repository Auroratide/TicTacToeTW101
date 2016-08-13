package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

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

    @Test
    public void shouldAskSecondPlayerAfterFirstPlayerGoes() throws Exception {
        when(board.isFull(anyString())).thenReturn(false, false, true);
        ticTacToeGame.play();

        InOrder inOrder = inOrder(firstPlayer, secondPlayer);
        inOrder.verify(firstPlayer).makeChoice();
        inOrder.verify(secondPlayer).makeChoice();
    }

    @Test
    public void shouldAskFirstPlayerAfterSecondPlayerGoes() throws Exception {
        when(board.isFull(anyString())).thenReturn(false, false, false, true);
        ticTacToeGame.play();

        InOrder inOrder = inOrder(firstPlayer, secondPlayer);
        inOrder.verify(secondPlayer).makeChoice();
        inOrder.verify(firstPlayer).makeChoice();
    }
}