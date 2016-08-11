package com.thoughtworks.tictactoe.tfoster;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private BufferedReader reader;
    private Player player;

    @Before
    public void setUp() throws Exception {
        reader = mock(BufferedReader.class);
        player = new Player(reader);
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