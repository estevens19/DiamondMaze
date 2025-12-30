package org.example.model.game.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Level3MazeBuilderTest {
    @Test
    public void testBuildMaze() throws Exception {
        Level3MazeBuilder builder = new Level3MazeBuilder();
        Maze maze = builder.build();

        assertNotNull(maze);
        assertFalse(maze.getWalls().isEmpty());
        assertFalse(maze.getGuards().isEmpty());
        assertFalse(maze.getDiamonds().isEmpty());
        assertNotNull(maze.getKnight());
        assertNotNull(maze.getCountdown());
    }
}
