package com.thoughtworks.tictactoe.tfoster;

import org.junit.Test;

import java.io.BufferedReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicTacToePlayerTest {
    @Test
    public void shouldReturn1WhenUserInputs1() throws Exception {
        BufferedReader reader = mock(BufferedReader.class);
        TicTacToePlayer player = new TicTacToePlayer(reader);

        when(reader.readLine()).thenReturn("1");

        assertThat(player.makeChoice(), is(1));
    }
}