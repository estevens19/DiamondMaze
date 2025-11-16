package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Menu implements Drawable {
    private final List<java.awt.Button> buttons;
    private final Image background;

    public Menu(List<java.awt.Button> buttons, Image background) {
        this.buttons = buttons;
        this.background = background;
    }

    @Override
    public void draw(TextGraphics graphics) throws IOException {
        background.draw(graphics);
    }

    public List<Button> getButtons() {
        return buttons;
    }
}