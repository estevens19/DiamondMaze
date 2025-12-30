package org.example.model.game.maze;

import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    private Score score;

    @BeforeEach
    public void setUp() {
        score = new Score();
    }

    @Test
    public void testInitialScore() {
        assertEquals(0, score.getPoints());
    }

    @Test
    public void testAddPoints() {
        score.addPoints(10);
        assertEquals(10, score.getPoints());

        score.addPoints(5);
        assertEquals(15, score.getPoints());
    }

    @Test
    public void testScorePosition() {
        Position pos = score.getPosition();
        assertEquals(460, pos.getX());
        assertEquals(20, pos.getY());
    }

    @Test
    public void testScoreString() {
        score.addPoints(100);
        assertEquals("Score: 100", score.scoreString());
    }
}
