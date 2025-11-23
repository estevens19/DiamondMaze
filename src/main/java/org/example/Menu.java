package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private Image background;
    private final Image originalBackground;

    public Menu() throws IOException {
        originalBackground = new Image(new Position(0, 0), "images/1.Main Menu.png");

        background = originalBackground.resizeImage(100, 50);
    }

    public void updateSize(int width, int height) throws IOException {
        this.background = originalBackground.resizeImage(width, height);
    }

    public void draw(TextGraphics graphics) {
        background.draw(graphics);
    }
}