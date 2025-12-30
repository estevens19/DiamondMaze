package org.example.model.game.elements;

import org.example.model.game.element.Diamond;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class DiamondTest {
    private Diamond diamond;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        diamond = new Diamond(10, 10);
    }

    @Test
    void testDiamondIsNotKeyByDefault() {
        assertFalse(diamond.isKey());
    }

    @Test
    void testSetKey() {
        diamond.setKey();
        assertTrue(diamond.isKey());
    }

    @Test
    void testPointsRange() throws IOException, URISyntaxException, FontFormatException {
        for (int i = 0; i < 100; i++) {
            Diamond d = new Diamond(10, 10);
            int points = d.getPoints();
            assertTrue(points >= 1000);
            assertTrue(points <= 3900);
            assertEquals(0, points % 100);
        }
    }

    @Test
    void testPositionInitialization() {
        assertEquals(10, diamond.getPosition().getX());
        assertEquals(10, diamond.getPosition().getY());
    }
}
