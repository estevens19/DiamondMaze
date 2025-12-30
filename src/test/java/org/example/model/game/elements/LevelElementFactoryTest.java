package org.example.model.game.elements;

import org.example.model.Position;
import org.example.model.game.element.LevelElementFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LevelElementFactoryTest {
    private LevelElementFactory factory;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        factory = new LevelElementFactory();
    }

    @Test
    void testCreateElements() throws IOException, URISyntaxException, FontFormatException {
        Position pos = new Position(10, 10);

        assertNotNull(factory.createWall(pos));
        assertNotNull(factory.createDiamond(pos));
        assertNotNull(factory.createPotion(pos));
        assertNotNull(factory.createKey(pos));
        assertNotNull(factory.createDoor(pos));
        assertEquals(10, factory.createWall(pos).getPosition().getX());
        assertEquals(10, factory.createWall(pos).getPosition().getY());
    }
}
