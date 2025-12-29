package org.example.model.game.maze;

import org.example.model.Position;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MazeParserTest {
    @Test
    void testRenderMapDimensions() throws IOException {
        MazeParser parser = new MazeParser("mazeParserTest.txt");
        char[][] map = parser.getMaze();
        assertNotNull(map);
        assertEquals(6, map.length);
        assertEquals(10, map[0].length);
    }

    @Test
    void testRenderMapContent() throws IOException {
        MazeParser parser = new MazeParser("mazeParserTest.txt");
        char[][] map = parser.getMaze();
        assertEquals('w', map[0][0]);
        assertEquals('d', map[1][3]);
        assertEquals('p', map[1][7]);
        assertEquals(' ', map[2][1]);
    }

    @Test
    void testToPositionCalculation() throws IOException {
        MazeParser parser = new MazeParser("mazeParserTest.txt");
        Position posZero = parser.toPosition(0, 0);
        Position posUm = parser.toPosition(1, 1);
        Position posCustom = parser.toPosition(5, 2);
        assertEquals(15, posZero.getX());
        assertEquals(55, posZero.getY());
        assertEquals(30, posUm.getX());
        assertEquals(75, posUm.getY());
        assertEquals(90, posCustom.getX());
        assertEquals(95, posCustom.getY());
    }

    @Test
    void testFileNotFound() {
        assertThrows(NullPointerException.class, () -> {
            new MazeParser("mazeParserTest2.txt");
        });
    }
}
