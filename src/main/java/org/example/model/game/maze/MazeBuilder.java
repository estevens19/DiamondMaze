package org.example.model.game.maze;

import org.example.model.game.characters.Knight;

public abstract class MazeBuilder {
    public Maze createMaze() {
        Maze maze = new Maze(getWidth(), getHeight());

        maze.setKnight(createHero());
        maze.setGuards(createMonsters());
        //maze.setWalls(createWalls());

        return maze;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    //protected abstract List<Wall> createWalls();

    protected abstract List<Guard> createGuards();

    protected abstract Knight createKnight();
}
