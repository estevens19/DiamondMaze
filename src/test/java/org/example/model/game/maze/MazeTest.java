package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.element.Potion;
import org.example.model.game.element.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.FontFormatException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MazeTest {
    private MazeStub maze;

    private static class MazeStub extends Maze {
        public MazeStub() throws IOException, URISyntaxException, FontFormatException {
            super();
            this.walls = new ArrayList<>();
            this.potions = new ArrayList<>();
            this.diamonds = new ArrayList<>();
            this.guards = new ArrayList<>();
        }

        public void addWall(Wall wall) {
            this.walls.add(wall);
        }

        public void addPotion(Potion potion) {
            this.potions.add(potion);
        }

        public void setCountdown(Countdown countdown) {
            this.countdown = countdown;
        }
    }

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        maze = new MazeStub();
    }

    @Test
    void testWallCollision() throws IOException, URISyntaxException, FontFormatException {
        maze.addWall(new Wall(100, 100));
        Position collisionPos = new Position(50, 90);

        assertTrue(maze.isWallKnight(collisionPos));
    }

    @Test
    void testNoWallCollision() throws IOException, URISyntaxException, FontFormatException {
        maze.addWall(new Wall(100, 100));
        Position safePos = new Position(0, 0);

        assertFalse(maze.isWallKnight(safePos));
    }

    @Test
    void testIsPotion() throws IOException, URISyntaxException, FontFormatException {
        Potion potion = new Potion(30, 30);
        maze.addPotion(potion);
        Potion found = maze.isPotion(new Position(-10, 10));

        assertNotNull(found);
        assertEquals(potion, found);
    }

    @Test
    void testRemovePotion() throws IOException, URISyntaxException, FontFormatException {
        Potion potion = new Potion(30, 30);
        maze.addPotion(potion);
        maze.removePotion(potion);

        assertNull(maze.isPotion(new Position(30, 30)));
    }

    @Test
    void testPotionEffectAddsTime() {
        Countdown countdownMock = mock(Countdown.class);
        maze.setCountdown(countdownMock);
        Potion potionMock = mock(Potion.class);
        when(potionMock.getEffect()).thenReturn(0);
        maze.setPotionEffect(potionMock);

        verify(countdownMock, times(1)).addTime(10);
    }

}