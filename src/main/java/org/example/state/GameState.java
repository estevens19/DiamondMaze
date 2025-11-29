package org.example.state;

import org.example.Maze;
import org.example.controller.Controller;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

public class GameState extends State<Maze> {
    public GameState(Maze maze) {
        super(maze);
    }

    @Override
    protected Viewer<Maze> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Maze> getController() {
        return new MazeController(getModel());
    }
}
