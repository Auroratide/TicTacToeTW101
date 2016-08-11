package com.thoughtworks.tictactoe.tfoster;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeGameTest {
    @Test
    public void shouldSeeBoardWhenGameIsStarted() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        TicTacToeGame ticTacToeGame = new TicTacToeGame(printStream);

        ticTacToeGame.play();

        verify(printStream).println("1|2|3");
        verify(printStream).println("-----");
        verify(printStream).println("4|5|6");
        verify(printStream).println("-----");
        verify(printStream).println("7|8|9");
    }
}