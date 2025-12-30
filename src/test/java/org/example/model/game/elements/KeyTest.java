package org.example.model.game.elements;

import org.example.model.game.element.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyTest {
    private Key key;

    @BeforeEach
    void setup() throws IOException, URISyntaxException, FontFormatException {
        key = new Key(10,10);
    }

    @Test
    void testPositionInitialization() {
        assertEquals(10, key.getPosition().getX());
        assertEquals(10, key.getPosition().getY());
    }
}
