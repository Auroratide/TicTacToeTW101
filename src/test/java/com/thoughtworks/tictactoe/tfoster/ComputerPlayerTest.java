package com.thoughtworks.tictactoe.tfoster;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ComputerPlayerTest {

//  PROBLEM: Cannot check integer range?
/*  @Test
    public void shouldSelectEmptyBoardLocationWhenTakingTurn() throws Exception {
        Board board = mock(Board.class);
        when(board.isTaken(1)).thenReturn(false);
        ComputerPlayer player = new ComputerPlayer("<NAME>", "<MARKER>", board);
        player.takeTurn();

        verify(board).mark(1, "<MARKER>");
    }
*/

    @Test
    public void shouldSelectSlot4WhenSlot4IsTheOnlySlotAvailable() throws Exception {
        Board board = mock(Board.class);
        when(board.isTaken(1)).thenReturn(true);
        when(board.isTaken(2)).thenReturn(true);
        when(board.isTaken(3)).thenReturn(true);
        when(board.isTaken(4)).thenReturn(false);
        when(board.isTaken(5)).thenReturn(true);
        when(board.isTaken(6)).thenReturn(true);
        when(board.isTaken(7)).thenReturn(true);
        when(board.isTaken(8)).thenReturn(true);
        when(board.isTaken(9)).thenReturn(true);
        ComputerPlayer player = new ComputerPlayer("<NAME>", "<MARKER>", board);
        player.takeTurn();

        verify(board).mark(4, "<MARKER>");
    }

    @Test
    public void shouldSelectSlot1WhenSlot1IsTheOnlySlotAvailable() throws Exception {
        Board board = mock(Board.class);
        when(board.isTaken(1)).thenReturn(false);
        when(board.isTaken(2)).thenReturn(true);
        when(board.isTaken(3)).thenReturn(true);
        when(board.isTaken(4)).thenReturn(true);
        when(board.isTaken(5)).thenReturn(true);
        when(board.isTaken(6)).thenReturn(true);
        when(board.isTaken(7)).thenReturn(true);
        when(board.isTaken(8)).thenReturn(true);
        when(board.isTaken(9)).thenReturn(true);
        ComputerPlayer player = new ComputerPlayer("<NAME>", "<MARKER>", board);
        player.takeTurn();

        verify(board).mark(1, "<MARKER>");
    }
}