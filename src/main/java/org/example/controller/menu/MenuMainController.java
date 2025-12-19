package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.MenuControls;
import org.example.model.menu.MenuMain;
import org.example.model.menu.MenuLevels;
import org.example.state.MenuControlsState;
import org.example.state.MenuLevelsState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuMainController extends Controller<MenuMain> {
    public MenuMainController(MenuMain menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
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
                    game.setState(new MenuControlsState(new MenuControls()));
                }
                else if (getModel().getCurrButton() == 3) {
                    game.exit();
                }
                break;
            case QUIT:
                game.exit();
                break;
        }
    }
}