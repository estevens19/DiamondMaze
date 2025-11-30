package org.example.model.game.maze;

import org.example.model.game.characters.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MazeLevel1Test {

    private MazeLevel1 mazeLevel1;

    @BeforeEach
    void setUp() throws IOException {
        mazeLevel1 = new MazeLevel1();
    }

    @Test
    void testGetKnight() {
        assertNotNull(mazeLevel1.getKnight());
    }

    @Test
    void testSetKnight() {
        Knight newKnightMock = Mockito.mock(Knight.class);

        Knight oldKnight = mazeLevel1.getKnight();

        mazeLevel1.setKnight(newKnightMock);

        assertEquals(newKnightMock, mazeLevel1.getKnight());
        assertNotEquals(oldKnight, mazeLevel1.getKnight());
    }
}
