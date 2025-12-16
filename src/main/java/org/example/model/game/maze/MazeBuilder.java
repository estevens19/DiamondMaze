package org.example.model.game.maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class MazeBuilder {
    protected Maze maze;

    public Maze build() throws IOException, URISyntaxException, FontFormatException {
        this.maze = createMaze();
        buildMaze();
        return maze;
    }

    private void buildMaze() throws IOException, URISyntaxException, FontFormatException {
        createAllElements();
    }

    protected abstract Maze createMaze() throws IOException;
    protected abstract void createAllElements() throws IOException, URISyntaxException, FontFormatException;
}