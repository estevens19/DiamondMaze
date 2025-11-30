package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.MenuMain;
import org.example.model.menu.MenuLevels;
import org.example.state.MenuLevelsState;

import java.io.IOException;

public class MenuMainController extends Controller<MenuMain> {
    public MenuMainController(MenuMain menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                if (getModel().getCurrButton() > 1) {
                    getModel().backCurrButton();
                }
                break;
            case DOWN:
                if (getModel().getCurrButton() < 3) {
                    getModel().nextCurrButton();
                }
                break;
            case SELECT:
                if (getModel().getCurrButton() == 1) {
                    game.setState(new MenuLevelsState(new MenuLevels()));
                }
                else if (getModel().getCurrButton() == 2) {
                }
                else if (getModel().getCurrButton() == 3) {
                    game.setState(null);
                }
                break;
            case QUIT:
                game.setState(null);
                break;
        }
    }
}