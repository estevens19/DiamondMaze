package org.example.controller.game;

import org.example.Game;
import org.example.model.game.character.Guard;
import org.example.model.Position;
import org.example.gui.GUI;
import org.example.model.game.maze.Maze;

import java.io.IOException;

public class GuardController extends GameController {
    public GuardController(Maze maze) {
        super(maze);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
    }

    private void moveGuard(Guard guard, Position position) {

    }
}