package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.MenuControls;
import org.example.model.menu.MenuMain;
import org.example.state.GameState;
import org.example.state.MenuMainState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuControlsController extends Controller<MenuControls> {
    public MenuControlsController(MenuControls menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case SELECT:
                MenuMain menuMain = new MenuMain();
                menuMain.updateSize(getModel().getScreenWidth(), getModel().getScreenHeight());
                game.setState(new MenuMainState(menuMain));
                break;
            case QUIT:
                game.setState(null);
                break;
        }
    }
}