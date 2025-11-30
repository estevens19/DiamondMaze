package org.example.model.game.maze;

import org.example.model.game.characters.Guard;
import org.example.model.game.characters.Knight;

import java.util.List;

public abstract class MazeBuilder {
    public Maze createMaze() {
        Maze maze = new Maze(getWidth(), getHeight());

        maze.setKnight(createKnight());
        maze.setGuards(createGuards());
        //maze.setWalls(createWalls());

        return maze;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    //protected abstract List<Wall> createWalls();

    protected abstract List<Guard> createGuards();

    protected abstract Knight createKnight();
}
