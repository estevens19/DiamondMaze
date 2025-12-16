package org.example.controller.game;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.game.maze.Maze;
import org.example.model.menu.MenuLevels;
import org.example.model.menu.MenuMain;
import org.example.state.MenuLevelsState;
import org.example.state.MenuMainState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MazeController extends GameController {
    private final KnightController knightController;
    private final GuardController guardController;

    public MazeController(Maze maze) {
        super(maze);
        this.knightController = new KnightController(maze);
        this.guardController = new GuardController(maze);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuMainState(new MenuMain()));
        else if (action == GUI.ACTION.SELECT)
            game.setState(new MenuLevelsState(new MenuLevels()));
        else if (getModel().getCountdown().getTime() == 0) {
            game.setState(new MenuLevelsState(new MenuLevels()));
        }
        else {
            knightController.step(game, action, time);
            guardController.step(game, action, time);
        }
    }
}
