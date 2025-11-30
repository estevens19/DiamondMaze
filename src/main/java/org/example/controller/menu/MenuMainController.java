package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.Menu;
import org.example.model.menu.MenuMain;
import org.example.state.GameState;

import java.io.IOException;

import static org.example.gui.LanternaGUI.screen;

public class MenuMainController extends Controller<MenuMain> {
    public MenuMainController(Menu menu) {
        super(menu);
    }

/*
    @Override
    public void (Game game key) throws IOException {
        if (inLevels) {
            menuLevels.getKey(key);

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') {
                if (menuLevels.isBackSelected()) {
                    inLevels = false;
                }
            }
        }
    }
 */
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
                    getModel().getMenuLevels().resetSelection();
                    getModel().setMenuLevels(true);
                    getModel().getMenuLevels().updateSize(getModel().getBackground().getWidth(), getModel().getBackground().getHeight());
                }
                else if (getModel().getCurrButton() == 2) {

                }
                else if (getModel().getCurrButton() == 3) {
                    game.setState(null);
                }
        }
    }
}
