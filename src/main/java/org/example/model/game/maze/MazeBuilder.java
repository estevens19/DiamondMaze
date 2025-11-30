package org.example.model.game.maze;

import org.example.model.game.characters.Knight;

import java.io.IOException;

public abstract class MazeBuilder {
    public Maze createMaze() throws IOException {
        MazeLevel1 maze = new MazeLevel1();
        maze.setKnight(createKnight());
        //maze.setGuards(createGuards());
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
