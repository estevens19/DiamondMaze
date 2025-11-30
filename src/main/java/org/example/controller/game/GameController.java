package org.example.controller.game;


import org.example.controller.Controller;
import org.example.model.game.maze.Maze;

public abstract class GameController extends Controller<Maze> {
    public GameController(Maze maze) {
        super(maze);
    }
}