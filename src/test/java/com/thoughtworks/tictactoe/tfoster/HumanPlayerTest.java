package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class HumanPlayerTest {

    private BufferedReader reader;
    private Player player;
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player = new HumanPlayer("<NAME>", "<MARKER>", board, printStream, reader);

        when(reader.readLine()).thenReturn("1");
    }

    @Test
    public void shouldPromptUserForInputWhenMakingAChoice() throws Exception {
        player.takeTurn();

        verify(printStream).println("Input the number of the slot where you want your mark");
    }

    @Test
    public void shouldMarkFirstSlotOnBoardWhenPlayerSelectsFirstSlot() throws Exception {
        when(reader.readLine()).thenReturn("1");
        player.takeTurn();

        verify(board).mark(1, "<MARKER>");
    }

    @Test
    public void shouldMarkSecondSlotOnBoardWhenPlayerSelectsSecondSlot() throws Exception {
        when(reader.readLine()).thenReturn("2");
        player.takeTurn();

        verify(board).mark(2, "<MARKER>");
    }

    @Test
    public void shouldMarkBoardWithOWhenPlayerMarkerIsO() throws Exception {
        player = new HumanPlayer("Player 2", "O", board, printStream, reader);
        player.takeTurn();

        verify(board).mark(1, "O");
    }

    @Test
    public void shouldKeepPollingPlayerWhileSlotChoiceIsAlreadyTaken() throws Exception {
        when(board.isTaken(anyInt())).thenReturn(true, true, false, true);
        player.takeTurn();

        verify(board, times(3)).isTaken(anyInt());
    }

    @Test
    public void shouldInformPlayerWhenTakenSlotWasSelected() throws Exception {
        when(board.isTaken(anyInt())).thenReturn(true, false);
        player.takeTurn();

        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldPollBoardForThreeInARowWhenAskedIfPlayerHasWon() throws Exception {
        player.hasWon();

        verify(board).hasThreeInARow("<MARKER>");
    }

    @Test
    public void shouldPollBoardForThreeInAColumnWhenAskedIfPlayerHasWon() throws Exception {
        player.hasWon();

        verify(board).hasThreeInAColumn("<MARKER>");
    }

    @Test
    public void shouldPollBoardForThreeInADiagonalWhenAskedIfPlayerHasWon() throws Exception {
        player.hasWon();

        verify(board).hasThreeInADiagonal("<MARKER>");
    }

}