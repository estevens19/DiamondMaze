package org.example.model.game.elements;

import org.example.model.game.element.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    private Wall wall;

    @BeforeEach
    void setup() throws IOException, URISyntaxException, FontFormatException {
        BufferedImage dummyImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        wall = new Wall(10, 10, dummyImage);
    }

    @Test
    void testPositionInitialization() {
        assertEquals(10, wall.getPosition().getX());
        assertEquals(10, wall.getPosition().getY());
    }
}
