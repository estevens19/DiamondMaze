package org.example.viewer;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ImageTest {
    private Image image;
    private BufferedImage mockBufferedImage;
    private Position initialPosition;

    @BeforeEach
    void setUp() {
        mockBufferedImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

        int redColor = new Color(255, 0, 0, 255).getRGB();
        mockBufferedImage.setRGB(0, 0, redColor);

        initialPosition = new Position(5, 5);

        image = new Image(initialPosition, mockBufferedImage);
    }

    @Test
    void testDimensions() {
        assertEquals(10, image.getWidth());
        assertEquals(10, image.getHeight());
    }

    @Test
    void testPositionGetter() {
        assertEquals(5, image.getPosition().getX());
        assertEquals(5, image.getPosition().getY());
    }

    @Test
    void testPositionSetter() {
        Position newPos = new Position(20, 20);
        image.setPosition(newPos);

        assertEquals(20, image.getPosition().getX());
    }

    @Test
    void testResizeImage() throws IOException {
        Image resizedImage = image.resizeImage(20, 20);

        assertNotNull(resizedImage);
        assertEquals(20, resizedImage.getWidth());
        assertEquals(20, resizedImage.getHeight());

        assertEquals(initialPosition, resizedImage.getPosition());
    }

    @Test
    void testDraw() {
        TextGraphics graphicsMock = mock(TextGraphics.class);
        image.draw(graphicsMock);
        verify(graphicsMock, atLeastOnce()).setCharacter(eq(5), eq(5), any(TextCharacter.class));
    }

}
