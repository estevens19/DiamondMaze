package org.example.model.game.elements;

import org.example.model.game.element.Potion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PotionTest {
    private Potion potion;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        potion = new Potion(10, 10);
    }

    @Test
    void testPointsRange() throws IOException, URISyntaxException, FontFormatException {
        for (int i = 0; i < 100; i++) {
            Potion d = new Potion(10, 10);
            int points = d.getEffect();
            assertTrue(points >= 0);
            assertTrue(points < 8);
        }
    }

    @Test
    void testPositionInitialization() {
        assertEquals(10, potion.getPosition().getX());
        assertEquals(10, potion.getPosition().getY());
    }
}
