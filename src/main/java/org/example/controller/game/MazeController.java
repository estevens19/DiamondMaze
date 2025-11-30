package org.example.controller.game;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.game.maze.Maze;
import org.example.model.menu.Menu;
import org.example.state.MenuState;
import org.example.controller.game.KnightController;

import java.io.IOException;

public class MazeController extends GameController {
    private final KnightController knightController;
    private final GuardController guardController;

    public MazeController(Maze maze) {
        super(maze);

        this.knightController = new KnightController(maze);
        this.guardController = new GuardController(maze);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            knightController.step(game, action, time);
            guardController.step(game, action, time);
        }
    }
}
