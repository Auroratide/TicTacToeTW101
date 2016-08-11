package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BoardTest {

    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldSeeBoardWhenGameIsStarted() throws Exception {
        board.showBoard();

        verify(printStream).println("1|2|3");
        verify(printStream, times(2)).println("-----"); // Mockito doesn't care about ordering
        verify(printStream).println("4|5|6");
        verify(printStream).println("7|8|9");
    }

    @Test
    public void shouldSeeXInSlot1WhenOnlySlot1HasBeenMarkedWithX() throws Exception {
        board.mark(1, "X");
        board.showBoard();

        verify(printStream).println("X|2|3");
    }
}