package org.example.controller.game;

import org.example.Game;
import org.example.controller.game.character.GuardController;
import org.example.controller.game.character.KnightController;
import org.example.gui.GUI;
import org.example.model.game.maze.Maze;
import org.example.model.menu.MenuMain;
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
        else if (getModel().getCountdown().getTime() == 0) {
            game.onMenuGameOver();
        }
        else {
            knightController.step(game, action, time);
            guardController.step(game, action, time);
        }
    }
}