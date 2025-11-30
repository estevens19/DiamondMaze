package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.Menu;
import org.example.model.menu.MenuLevels;

import java.io.IOException;

public class MenuLevelsController extends Controller<MenuLevels> {
    public MenuLevelsController(Menu menu) {
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
                    getModel().isInLevel1().resetSelection();
                    getModel().setMazeLevel1(true);
                    getModel().getMazeLevel1().updateSize(getModel().getBackground().getWidth(), getModel().getBackground().getHeight());
                }
                else if (getModel().getCurrButton() == 0) {
                    menu_main.state(true);
                    menu_levels.state(false);
                }
                break;
        }
    }
}
