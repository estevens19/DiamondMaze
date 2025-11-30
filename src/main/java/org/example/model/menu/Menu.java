package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public abstract class Menu {
    private Image background;
    private int currButton = 1;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;

    private MenuLevels menuLevels;
    private boolean inLevels = false;

    //private MenuControls menuControls;
    //private boolean inControls = false;

    public Menu() {
        background = new Image(new Position(0, 0), "images_menu/Main_Menu.png");
        background = background.resizeImage(320, 280);
    }

    public Image getBackground() {
        return background;
    }
}
