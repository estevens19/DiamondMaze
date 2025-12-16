package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.game.maze.Level1MazeBuilder;
import org.example.model.game.maze.Level2MazeBuilder;
import org.example.model.game.maze.Level3MazeBuilder;
import org.example.model.menu.MenuGameOver;
import org.example.model.menu.MenuMain;
import org.example.state.GameState;
import org.example.state.MenuMainState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuGameOverController extends Controller<MenuGameOver> {
    public MenuGameOverController(MenuGameOver menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {

            case LEFT:
                if(getModel().getCurrButton() > 1){
                    getModel().backCurrButton();
                }
                break;
            case RIGHT:
                if(getModel().getCurrButton() < 2){
                    getModel().nextCurrButton();
                }
                break;
            case SELECT:
                if (getModel().getCurrButton() == 1) {
                    switch (getModel().getCurLevel()){
                        case 1:
                            game.setState(new GameState(new Level1MazeBuilder().build()));
                            break;
                        case 2:
                            game.setState(new GameState(new Level2MazeBuilder().build()));
                            break;
                        case 3:
                            game.setState(new GameState(new Level3MazeBuilder().build()));
                            break;
                    }
                }
                else if (getModel().getCurrButton() == 2) {
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