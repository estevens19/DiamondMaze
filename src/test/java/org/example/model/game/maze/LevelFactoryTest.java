package org.example.model.game.maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LevelFactoryTest {
    private LevelFactory levelFactory;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        levelFactory = new LevelFactory();
    }

    @Test
    void testFactoriesCreation() {
        assertNotNull(levelFactory.elements());
        assertNotNull(levelFactory.characters());
    }
}
