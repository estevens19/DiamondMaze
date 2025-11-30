package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public abstract class Menu {
    private Image background;
    protected int screenWidth;
    protected int screenHeight;

    public Menu() throws IOException {
        this.screenWidth = 320;
        this.screenHeight = 280;
        this.background = new Image(new Position(0, 0), "images_menu/Main_Menu.png");
        this.background = this.background.resizeImage(320, 280);
    }

    public Image getBackground() {
        return background;
    }

    protected void setBackground(Image background) {
        this.background = background;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public abstract void updateSize(int width, int height) throws IOException;
}