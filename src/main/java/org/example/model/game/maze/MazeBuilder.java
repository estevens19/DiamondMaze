package org.example.model.game.maze;

import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;

import java.io.IOException;
import java.util.List;

public abstract class MazeBuilder {

    protected Maze maze;

    public Maze build() throws IOException {
        this.maze = createMaze();
        maze.knight = createKnight();
        maze.guards = createGuards();
        maze.walls = createWalls();
        maze.diamonds = createDiamonds();
        maze.key = createKey();
        maze.door = createDoor();
        return maze;
    }

    protected abstract Maze createMaze() throws IOException;
    protected abstract Knight createKnight() throws IOException;
    protected abstract List<Guard> createGuards() throws IOException;
    protected abstract List<Wall> createWalls() throws IOException;
    protected abstract List<Diamond> createDiamonds() throws IOException;
    protected abstract Key createKey() throws IOException;
    protected abstract Door createDoor() throws IOException;
}