package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.FontFormatException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MazeTest {
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

        public void addDiamond(Diamond diamond) {
            this.diamonds.add(diamond);
        }

        public void addGuard(Guard guard) {
            this.guards.add(guard);
        }

        public void setKnight(Knight knight) {
            this.knight = knight;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public void setDoor(Door door) {
            this.door = door;
        }

        public void setCountdown(Countdown countdown) {
            this.countdown = countdown;
        }

        public void setScore(Score score) {
            this.score = score;
        }
    }

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        maze = new MazeStub();
    }

    @Test
    void testWallCollisionKnight() {
        BufferedImage dummyImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        maze.addWall(new Wall(100, 100, dummyImage));
        Position collisionPos = new Position(50, 80);

        assertTrue(maze.isWallKnight(collisionPos));
    }

    @Test
    void testNoWallCollisionKnight() {
        BufferedImage dummyImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        maze.addWall(new Wall(100, 100, dummyImage));
        Position safePos = new Position(0, 0);

        assertFalse(maze.isWallKnight(safePos));
    }

    @Test
    void testWallCollisionGuard() {
        BufferedImage dummyImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        maze.addWall(new Wall(100, 100, dummyImage));
        Position collisionPos = new Position(90, 90);

        assertTrue(maze.isWallGuard(collisionPos));
    }

    @Test
    void testIsPotion() throws IOException, URISyntaxException, FontFormatException {
        Potion potion = new Potion(30, 30);
        maze.addPotion(potion);
        // O valor (-10, 10) já passa na lógica atual, mantido.
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

    @Test
    void testPotionEffectRemovesTime() {
        Countdown countdownMock = mock(Countdown.class);
        maze.setCountdown(countdownMock);
        Potion potionMock = mock(Potion.class);
        when(potionMock.getEffect()).thenReturn(4);
        maze.setPotionEffect(potionMock);

        verify(countdownMock, times(1)).addTime(-10);
    }

    @Test
    void testIsDiamond() {
        Diamond diamond = mock(Diamond.class);
        when(diamond.getPosition()).thenReturn(new Position(50, 50));
        maze.addDiamond(diamond);
        Position collisionPos = new Position(15, 40);

        assertEquals(diamond, maze.isDiamond(collisionPos));
        assertNull(maze.isDiamond(new Position(0, 0)));
    }

    @Test
    void testRemoveDiamond() throws IOException, URISyntaxException, FontFormatException {
        Diamond diamond = new Diamond(50, 50);
        maze.addDiamond(diamond);
        maze.removeDiamond(diamond);

        assertTrue(maze.getDiamonds().isEmpty());
    }

    @Test
    void testIsKey() {
        Key keyMock = mock(Key.class);
        when(keyMock.getPosition()).thenReturn(new Position(200, 200));
        maze.setKey(keyMock);

        assertTrue(maze.isKey(new Position(170, 190)));
        assertFalse(maze.isKey(new Position(0, 0)));
    }

    @Test
    void testIsDoor() {
        Door doorMock = mock(Door.class);
        when(doorMock.getPosition()).thenReturn(new Position(300, 300));
        maze.setDoor(doorMock);

        assertTrue(maze.isDoor(new Position(260, 290)));
        assertFalse(maze.isDoor(new Position(0, 0)));
    }

    @Test
    void testIsKnight() {
        Knight knightMock = mock(Knight.class);
        when(knightMock.getPosition_currentImage()).thenReturn(new Position(100, 100));
        maze.setKnight(knightMock);

        assertTrue(maze.isKnight(new Position(110, 105)));
        assertFalse(maze.isKnight(new Position(0, 0)));
    }

    @Test
    void testIsGuard() {
        Guard guardMock = mock(Guard.class);
        when(guardMock.getPosition_currentImage()).thenReturn(new Position(150, 150));
        maze.addGuard(guardMock);

        assertTrue(maze.isGuard(new Position(135, 150)));
        assertFalse(maze.isGuard(new Position(0, 0)));
    }

    @Test
    void testAddScorePoints() {
        Score scoreMock = mock(Score.class);
        maze.setScore(scoreMock);
        maze.addScorePoints(50);

        verify(scoreMock, times(1)).addPoints(50);
    }

    @Test
    void testGettersAndSetters() {
        maze.setShowKey(true);
        assertTrue(maze.getShowKey());

        assertNotNull(maze.getWalls());
        assertNotNull(maze.getGuards());
        assertNotNull(maze.getDiamonds());
    }

    @Test
    void testPotionEffectsThreads() {
        Potion potionSlowGuard = mock(Potion.class);
        when(potionSlowGuard.getEffect()).thenReturn(1);
        maze.setPotionEffect(potionSlowGuard);

        Potion potionSpeedGuard = mock(Potion.class);
        when(potionSpeedGuard.getEffect()).thenReturn(2);
        maze.setPotionEffect(potionSpeedGuard);

        Potion potionSlowKnight = mock(Potion.class);
        when(potionSlowKnight.getEffect()).thenReturn(3);
        maze.setPotionEffect(potionSlowKnight);

        Potion potionHideKnight = mock(Potion.class);
        when(potionHideKnight.getEffect()).thenReturn(5);
        maze.setPotionEffect(potionHideKnight);

        Potion potionHideGuards = mock(Potion.class);
        when(potionHideGuards.getEffect()).thenReturn(6);
        maze.setPotionEffect(potionHideGuards);
    }
}