package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private BufferedReader reader;
    private Player player;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player = new Player(printStream, reader);
    }

    @Test
    public void shouldPromptUserForInputWhenMakingAChoice() throws Exception {
        when(reader.readLine()).thenReturn("1");
        player.makeChoice();

        verify(printStream).println("Input the number of the slot where you want your mark");
    }

    @Test
    public void shouldReturn1WhenUserInputs1() throws Exception {
        when(reader.readLine()).thenReturn("1");

        assertThat(player.makeChoice(), is(1));
    }

    @Test
    public void shouldReturn4WhenUserInputs4() throws Exception {
        when(reader.readLine()).thenReturn("4");

        assertThat(player.makeChoice(), is(4));
    }
}