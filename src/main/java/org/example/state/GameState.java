package org.example.state;

import org.example.controller.Controller;
import org.example.controller.game.MazeController;
import org.example.model.game.maze.Maze;
import org.example.viewer.Viewer;
import org.example.viewer.game.MazeViewer;

public class GameState extends State<Maze> {
    public GameState(Maze maze) {
        super(maze);
    }

    @Override
    protected Viewer<Maze> getViewer() {
        return new MazeViewer(getModel());
    }

    @Override
    protected Controller<Maze> getController() {
        return new MazeController(getModel());
    }
}