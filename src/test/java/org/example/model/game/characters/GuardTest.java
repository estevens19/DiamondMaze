package org.example.model.game.characters;

import org.example.model.game.character.Guard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuardTest {
    private Guard guard;

    @BeforeEach
    void setup() throws IOException, URISyntaxException, FontFormatException {
        guard = new Guard(150,120);
    }

    @Test
    void testGuardPosition() {
        assertEquals(150, guard.getPosition_currentImage().getX());
        assertEquals(120, guard.getPosition_currentImage().getY());
    }
}
