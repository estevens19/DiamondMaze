package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Drawable {
    private final List<java.awt.Button> buttons;
    private final Image background;

    public Menu() throws IOException {
        buttons = new ArrayList<Button>();
        Image original_menu_background = new Image(new Position(0, 0), "images/1.Main Menu.png");
        background = original_menu_background.resizeImage(465, 112);
    }

    @Override
    public void draw(TextGraphics graphics) {
        background.draw(graphics);
    }

    public List<Button> getButtons() {
        return buttons;
    }
}