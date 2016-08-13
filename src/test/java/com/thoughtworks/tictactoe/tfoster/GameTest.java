package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private PrintStream printStream;
    private Game game;
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    private void stopGameImmediately() {
        when(board.isFull()).thenReturn(true);
    }

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        firstPlayer = mock(Player.class);
        secondPlayer = mock(Player.class);
        game = new Game(printStream, board, firstPlayer, secondPlayer);
    }

    @Test
    public void shouldInitializeBoardWhenGameIsStarted() throws Exception {
        stopGameImmediately();
        game.play();

        verify(board).initialize();
    }

    @Test
    public void shouldSeeBoardWhenGameIsStarted() throws Exception {
        stopGameImmediately();
        game.play();

        verify(board, atLeastOnce()).show();
    }

    @Test
    public void shouldTerminateRoundsWhenBoardIsAlreadyFull() throws Exception {
        when(board.isFull()).thenReturn(true, false);
        game.play();

        verify(board).isFull();
    }

    @Test
    public void shouldKeepDoingRoundsUntilBoardIsFull() throws Exception {
    //  Note: In this test, we don't care about whether the players alternate
        when(board.isFull()).thenReturn(false, true, false);
        game.play();

        verify(board, times(2)).isFull();
    }

    @Test
    public void shouldClaimGameIsADrawWhenGameIsOver() throws Exception {
        stopGameImmediately();
        game.play();

        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldAskSecondPlayerAfterFirstPlayerGoes() throws Exception {
        when(board.isFull()).thenReturn(false, false, true);
        game.play();

        InOrder inOrder = inOrder(firstPlayer, secondPlayer);
        inOrder.verify(firstPlayer).takeTurn();
        inOrder.verify(secondPlayer).takeTurn();
    }

    @Test
    public void shouldAskFirstPlayerAfterSecondPlayerGoes() throws Exception {
        when(board.isFull()).thenReturn(false, false, false, true);
        game.play();

        InOrder inOrder = inOrder(firstPlayer, secondPlayer);
        inOrder.verify(secondPlayer).takeTurn();
        inOrder.verify(firstPlayer).takeTurn();
    }
}