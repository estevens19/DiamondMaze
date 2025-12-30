package org.example.model.game.characters;

import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.character.LevelCharacterFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LevelCharacterFactoryTest {
    private LevelCharacterFactory factory;

    @BeforeEach
    void setUp() {
        factory = new LevelCharacterFactory();
    }

    @Test
    void testCreateKnight() throws IOException, URISyntaxException, FontFormatException {
        Position pos = new Position(20, 20);
        Knight knight = factory.createKnight(pos);

        assertNotNull(knight);
        assertEquals(20, knight.getPosition_currentImage().getX());
    }

    @Test
    void testCreateGuard() throws IOException, URISyntaxException, FontFormatException {
        Position pos = new Position(30, 30);
        Guard guard = factory.createGuard(pos);

        assertNotNull(guard);
        assertEquals(30, guard.getPosition_currentImage().getX());
    }
}
