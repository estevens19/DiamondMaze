package org.example.controller.game.strategy;

import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.maze.Maze;
import org.junit.jupiter.api.Test;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomMoveStrategyTest {
    @Test
    public void testGetNextMove() {
        RandomMoveStrategy strategy = new RandomMoveStrategy();
        Guard guardMock = mock(Guard.class);
        Maze mazeMock = mock(Maze.class);
        Position currentPos = new Position(50, 35);

        when(guardMock.getPosition_currentImage()).thenReturn(currentPos);
        when(mazeMock.getGuardSpeed()).thenReturn(1);

        Position nextPos = strategy.getNextMove(guardMock, mazeMock);
        assertNotNull(nextPos);

        boolean isNeighbor = (abs(nextPos.getX() - currentPos.getX()) + abs(nextPos.getY() - currentPos.getY())) == 1;
        assertTrue(isNeighbor);
    }
}
