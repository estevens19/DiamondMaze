package org.example.model.game.maze;

import org.example.model.game.characters.Guard;
import org.example.model.game.characters.Knight;
import org.example.model.game.element.Diamond;
import org.example.model.game.element.Door;
import org.example.model.game.element.Key;

import java.io.IOException;
import java.util.List;

public abstract class MazeBuilder {
    public Maze createMaze() {
        Maze maze = new Maze(getWidth(), getHeight());

        maze.setKnight(createKnight());
        maze.setGuards(createGuards());
        //maze.setWalls(createWalls());

        return maze;
    }
/*
    protected abstract List<Wall> createWalls();

    protected abstract List<Guard> createGuards() throws IOException;

    protected abstract List<Diamond> createDiamonds() throws IOException;

    protected abstract Key createKey() throws IOException;

    protected abstract Door createDoor() throws IOException;
*/
    protected abstract Knight createKnight() throws IOException;

}
