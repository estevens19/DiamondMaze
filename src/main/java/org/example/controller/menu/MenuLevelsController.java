package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.game.maze.Level1MazeBuilder;
import org.example.model.menu.MenuLevels;
import org.example.model.menu.MenuMain;
import org.example.state.GameState;
import org.example.state.MenuMainState;

import java.io.IOException;

public class MenuLevelsController extends Controller<MenuLevels> {
    public MenuLevelsController(MenuLevels menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                if (getModel().getCurrButton() == 1) {
                    getModel().backCurrButton();
                }
                break;
            case DOWN:
                if (getModel().getCurrButton() == 0) {
                    getModel().nextCurrButton();
                }
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
            case SELECT:
                if (getModel().getCurrButton() == 1) {
                    game.setState(new GameState(new Level1MazeBuilder().build()));
                }
                else if (getModel().getCurrButton() == 0) {
                    MenuMain menuMain = new MenuMain();
                    menuMain.updateSize(getModel().getScreenWidth(), getModel().getScreenHeight());
                    game.setState(new MenuMainState(menuMain));
                }
                break;
            case QUIT:
                game.setState(null);
                break;
        }
    }
}