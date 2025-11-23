package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Drawable {
    private final List<Button> buttons;
    private Image background;
    private final Image originalBackground;

    public Menu() throws IOException {
        buttons = new ArrayList<Button>();

        this.originalBackground = new Image(new Position(0, 0), "images/1.Main Menu.png");

        this.background = originalBackground.resizeImage(100, 50);
    }

    public void updateSize(int width, int height) throws IOException {
        this.background = originalBackground.resizeImage(width, height);
    }

    @Override
    public void draw(TextGraphics graphics) {
        background.draw(graphics);
    }

    public List<Button> getButtons() {
        return buttons;
    }
}