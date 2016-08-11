package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        slots = new ArrayList<>();
        board = new Board(printStream, slots);
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
        assertFalse(board.isTaken(1, "XO"));
    }

    @Test
    public void shouldReturnTrueWhenSlotIsTakenByAnX() throws Exception {
        slots.set(2, "X");
        assertTrue(board.isTaken(3, "XO"));
    }

    @Test
    public void shouldReturnTrueWhenSlotIsTakenByAnO() throws Exception {
        slots.set(7, "O");
        assertTrue(board.isTaken(8, "XO"));
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFullOfXs() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");

        assertTrue(board.isFull("X"));
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFullOfOs() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("O");

        assertTrue(board.isFull("O"));
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");
        slots.set(2, "3");

        assertFalse(board.isFull("X"));
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFullOfXsOrOs() throws Exception {
        slots.clear();
        for(int i = 0; i < 9; ++i)
            slots.add("X");
        slots.set(1, "O");
        slots.set(5, "O");

        assertTrue(board.isFull("XO"));
    }
}