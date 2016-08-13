package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> slots;
    private Collection<String> markers;

    @Before
    public void setUp() throws Exception {
        markers = new ArrayList<>();
        markers.add("X");
        markers.add("O");
        printStream = mock(PrintStream.class);
        slots = new ArrayList<>();
        board = new Board(markers, printStream, slots);
        board.initialize();
    }

    @Test
    public void shouldHave1InFirstSlotWhenBoardIsInitialized() throws Exception {
        board.initialize();

        assertThat(slots.get(0), is("1"));
    }

    @Test
    public void shouldHave4InFourthSlotWhenBoardIsInitialized() throws Exception {
        board.initialize();

        assertThat(slots.get(3), is("4"));
    }

    @Test
    public void shouldShowNumberBoardWhenSlotsContainsNumbers() throws Exception {
        slots.clear();
        for(int i = 1; i <= 9; ++i)
            slots.add(String.valueOf(i));

        board.show();

        verify(printStream).println(
                        "1|2|3\n" +
                        "-----\n" +
                        "4|5|6\n" +
                        "-----\n" +
                        "7|8|9");
    }

    @Test
    public void shouldShowLetterBoardWhenSlotsContainLetters() throws Exception {
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i");
        slots.clear();
        slots.addAll(letters);

        board.show();

        verify(printStream).println(
                        "a|b|c\n" +
                        "-----\n" +
                        "d|e|f\n" +
                        "-----\n" +
                        "g|h|i");
    }

    @Test
    public void shouldMarkFirstSlotWithXWhenFirstSlotIsMarkedAsX() throws Exception {
        board.mark(1, "X");

        assertThat(slots.get(0), is("X"));
    }

    @Test
    public void shouldMarkFifthSlotWithXWhenFifthSlotIsMarkedAsX() throws Exception {
        board.mark(5, "X");

        assertThat(slots.get(4), is("X"));
    }

    @Test
    public void shouldReturnFalseWhenNoSlotsAreTaken() throws Exception {
        slots.set(0, "1");
        assertFalse(board.isTaken(1));
    }

    @Test
    public void shouldReturnTrueWhenSlotIsTakenByFirstMarker() throws Exception {
        slots.set(2, "X");
        assertTrue(board.isTaken(3));
    }

    @Test
    public void shouldReturnTrueWhenSlotIsTakenBySecondMarker() throws Exception {
        slots.set(7, "O");
        assertTrue(board.isTaken(8));
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFullOfXs() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");

        assertTrue(board.isFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFullOfOs() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("O");

        assertTrue(board.isFull());
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");
        slots.set(2, "3");

        assertFalse(board.isFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFullOfXsOrOs() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");
        slots.set(1, "O");
        slots.set(5, "O");

        assertTrue(board.isFull());
    }

    @Test
    public void shouldReturnTrueWhenXHasThreeInARow() throws Exception {
        slots.set(3, "X");
        slots.set(4, "X");
        slots.set(5, "X");

        assertTrue(board.hasThreeInARow("X"));
    }

    @Test
    public void shouldReturnFalseWhenXDoesNotHaveThreeInARow() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");
        slots.set(0, "O");
        slots.set(4, "O");
        slots.set(8, "O");

        assertFalse(board.hasThreeInARow("X"));
    }

    @Test
    public void shouldReturnTrueWhenXHasThreeInAColumn() throws Exception {
        slots.set(2, "X");
        slots.set(5, "X");
        slots.set(8, "X");

        assertTrue(board.hasThreeInAColumn("X"));
    }

    @Test
    public void shouldReturnFalseWhenXDoesNotHaveThreeInAColumn() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");
        slots.set(0, "O");
        slots.set(4, "O");
        slots.set(8, "O");

        assertFalse(board.hasThreeInAColumn("X"));
    }

    @Test
    public void shouldReturnTrueWhenXHasThreeInADiagonal() throws Exception {
        slots.set(0, "X");
        slots.set(4, "X");
        slots.set(8, "X");

        assertTrue(board.hasThreeInADiagonal("X"));
    }

    @Test
    public void shouldReturnFalseWhenXDoesNotHaveThreeInADiagonal() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");
        slots.set(4, "O");

        assertFalse(board.hasThreeInADiagonal("X"));
    }
}