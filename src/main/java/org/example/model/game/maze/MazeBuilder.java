package org.example.model.game.maze;

import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

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
    protected abstract Knight createKnight() throws IOException;
    protected abstract List<Guard> createGuards() throws IOException;
    protected abstract List<Wall> createWalls() throws IOException;
    protected abstract List<Diamond> createDiamonds() throws IOException;
    protected abstract Key createKey() throws IOException;
    protected abstract Door createDoor() throws IOException;
}