package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;

public class Menu {
    private Image background;
    private final Image originalBackground;
    private Image start;
    private Image controls;
    private Image exit;

    public Menu() throws IOException {
        originalBackground = new Image(new Position(0, 0), "images_menu/Main_Menu.png");
        this.background = originalBackground.resizeImage(100, 50);

        int buttonWidth = 195;
        int buttonHeight = 65;
        start = new Image(new Position(368, 55), "images_menu/Start_shine.png");
        this.start = start.resizeImage(buttonWidth, buttonHeight);
        controls = new Image(new Position(368, 95), "images_menu/Controls.png");
        controls = controls.resizeImage(buttonWidth, buttonHeight);
        exit = new Image(new Position(368, 135), "images_menu/Exit.png");
        exit = exit.resizeImage(buttonWidth, buttonHeight);
    }

    public void updateSize(int width, int height) throws IOException {
        this.background = originalBackground.resizeImage(width, height);
    }

    public void draw(TextGraphics graphics) {
        background.draw(graphics);
        start.draw(graphics);
        controls.draw(graphics);
        exit.draw(graphics);
    }
}