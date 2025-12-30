package org.example.model.game.maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountdownTest {
    private Countdown countdown;

    @BeforeEach
    public void setUp() {
        countdown = new Countdown(125);
    }

    @Test
    public void testInitialTime() {
        assertEquals(125, countdown.getTime());
    }

    @Test
    public void testAddTime() {
        countdown.addTime(10);
        assertEquals(135, countdown.getTime());
    }

    @Test
    public void testTimeStringFormatting() {
        assertEquals("Timer: 2:05", countdown.timeString());
    }

    @Test
    public void testTimeStringFormattingNoLeadingZero() {
        Countdown cd = new Countdown(70);
        assertEquals("Timer: 1:10", cd.timeString());
    }
}
