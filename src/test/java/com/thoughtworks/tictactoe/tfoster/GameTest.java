package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.stubbing.OngoingStubbing;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    public static final String GAME_IS_A_DRAW = "Game is a draw";

    private PrintStream printStream;
    private Game game;
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    private void stopGameImmediately() {
        when(board.isFull()).thenReturn(true);
    }

    private void takeTurns(int numberOfTurns) {
        OngoingStubbing<Boolean> stub = when(board.isFull());
        for(int i = 0; i < numberOfTurns; ++i)
            stub = stub.thenReturn(false);
        stub.thenReturn(true);
    }

    private void takeOneTurn() {
        takeTurns(1);
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

        verify(printStream).println(GAME_IS_A_DRAW);
    }

    @Test
    public void shouldAskSecondPlayerAfterFirstPlayerGoes() throws Exception {
        takeTurns(2);
        game.play();

        InOrder inOrder = inOrder(firstPlayer, secondPlayer);
        inOrder.verify(firstPlayer).takeTurn();
        inOrder.verify(secondPlayer).takeTurn();
    }

    @Test
    public void shouldAskFirstPlayerAfterSecondPlayerGoes() throws Exception {
        takeTurns(3);
        game.play();

        InOrder inOrder = inOrder(firstPlayer, secondPlayer);
        inOrder.verify(secondPlayer).takeTurn();
        inOrder.verify(firstPlayer).takeTurn();
    }

    @Test
    public void shouldAskPlayerIfPlayerHasWonAfterPlayerTakesTurn() throws Exception {
        takeOneTurn();
        game.play();

        verify(firstPlayer, atLeastOnce()).hasWon();
    }

    @Test
    public void shouldStopGameWhenPlayerHasWon() throws Exception {
        takeOneTurn();
        when(firstPlayer.hasWon()).thenReturn(true);
        game.play();

        verify(board, times(1)).isFull();
    }

    @Test
    public void shouldDeclareFirstPlayerAsWinnerIfFirstPlayerHasWon() throws Exception {
        takeOneTurn();
        when(firstPlayer.hasWon()).thenReturn(true);
        when(firstPlayer.name()).thenReturn("Player 1");
        game.play();

        verify(printStream).println("Player 1 Wins!");
    }

    @Test
    public void shouldDeclareSecondPlayerAsWinnerIfSecondPlayerHasWon() throws Exception {
        takeTurns(2);
        when(firstPlayer.hasWon()).thenReturn(false);
        when(secondPlayer.hasWon()).thenReturn(true);
        when(secondPlayer.name()).thenReturn("Player 2");
        game.play();

        verify(printStream).println("Player 2 Wins!");
    }

    @Test
    public void shouldNotDeclareGameADrawWhenAPlayerWins() throws Exception {
        takeOneTurn();
        when(firstPlayer.hasWon()).thenReturn(true);
        game.play();

        verify(printStream, never()).println(GAME_IS_A_DRAW);
    }
}