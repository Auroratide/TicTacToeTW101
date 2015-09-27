package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Board board;
    private Game game;
    private PrintStream printStream;
    private Player player;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        game = new Game(board, printStream, player);
    }

    @Test
    public void shouldDrawBoardTwiceWhenStarting() {
        game.start();

        verify(board, times(2)).draw();
    }

    @Test
    public void shouldAcceptPlayerMoveWhenStarting() {
        game.start();

        verify(player).move();
    }

}