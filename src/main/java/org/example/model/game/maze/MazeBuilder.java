package org.example.model.game.maze;

import java.io.IOException;

public abstract class MazeBuilder {
    protected Maze maze;

    public Maze build() throws IOException {
        this.maze = createMaze();
        buildMaze();
        return maze;
    }

    private void buildMaze() throws IOException {
        createAllElements();
    }

    protected abstract Maze createMaze() throws IOException;
    protected abstract void createAllElements() throws IOException;
}