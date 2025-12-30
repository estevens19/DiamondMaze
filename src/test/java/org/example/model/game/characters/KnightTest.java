package org.example.model.game.characters;

import org.example.model.game.character.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {
    private Knight knight;

    @BeforeEach
    void setup() throws IOException, URISyntaxException, FontFormatException {
        knight = new Knight(100,100);
    }

    @Test
    void testKnightPosition() {
        assertEquals(100, knight.getPosition_currentImage().getX());
        assertEquals(100, knight.getPosition_currentImage().getY());
    }
}
