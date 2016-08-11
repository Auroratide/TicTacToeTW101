package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> slots;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        slots = new ArrayList<>();
        board = new Board(printStream, slots);
        board.initialize();
    }

    @Test
    public void shouldBoardOfSlotNumbersWhenBoardIsInitialized() throws Exception {
        board.initialize();
        board.showBoard();

        verify(printStream).println("1|2|3");
        verify(printStream, times(2)).println("-----"); // Mockito doesn't care about ordering
        verify(printStream).println("4|5|6");
        verify(printStream).println("7|8|9");
    }

    @Test
    public void shouldMarkFirstSlotWithXWhenFirstSlotIsMarkedAsX() throws Exception {
        board.mark(1, "X");

        assertThat(slots.get(1), is("X"));
    }

    @Test
    public void shouldShowFirstSlotAsXWhenFirstSlotIsMarkedAsX() throws Exception {
        slots.set(0, "X");
        board.showBoard();

        verify(printStream).println("X|2|3");
    }

    @Test
    public void shouldShowSecondSlotAsXWhenSecondSlotIsMarkedAsX() throws Exception {
        slots.set(1, "X");
        board.showBoard();

        verify(printStream).println("1|X|3");
    }

    @Test
    public void shouldShowNinthSlotAsXWhenNinthSlotIsMarkedAsX() throws Exception {
        slots.set(8, "X");
        board.showBoard();

        verify(printStream).println("7|8|X");
    }

    @Test
    public void shouldShowFirstAndFifthSlotAsXWhenFirstAndFifthSlotAreMarkedAsX() throws Exception {
        slots.set(0, "X");
        slots.set(4, "X");
        board.showBoard();

        verify(printStream).println("X|2|3");
        verify(printStream).println("4|X|6");
    }
}