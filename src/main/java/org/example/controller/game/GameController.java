package org.example.controller.game;

import org.example.Maze;
import org.example.controller.Controller;

public abstract class GameController extends Controller<Maze> {
    public GameController(Maze maze) {
        super(maze);
    }
}