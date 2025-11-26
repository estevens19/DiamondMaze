
package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

import static org.example.Game.running;
import static org.example.Game.screen;

public class Menu implements InputHandler {
    private Image background;
    private Image title;
    private Image start;
    private Image controls;
    private Image exit;
    private int currButton = 1;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;
    private Menu_Levels menuLevels;
    private boolean inLevels = false;

    //private Menu_Levels menuControls;
    //private boolean inControls = false;

    public Menu() throws IOException {
        background = new Image(new Position(0, 0), "images_menu/Main_Menu.png");
        background = background.resizeImage(320, 280);

        title = new Image(new Position(0, 0), "images_menu/Title.png");
        title = title.resizeImage(1300, 250);
        menuLevels = new Menu_Levels();
        refreshButtons();
    }

    private void refreshButtons() throws IOException {
        Position startPos = (start != null) ? start.getPosition() : new Position(0, 0);
        Position controlsPos = (controls != null) ? controls.getPosition() : new Position(0, 0);
        Position exitPos = (exit != null) ? exit.getPosition() : new Position(0, 0);

        switch (currButton) {
            case 1:
                start = new Image(startPos, "images_menu/Start_shine.png");
                controls = new Image(controlsPos, "images_menu/Controls.png");
                exit = new Image(exitPos, "images_menu/Exit.png");
                break;
            case 2:
                start = new Image(startPos, "images_menu/Start.png");
                controls = new Image(controlsPos, "images_menu/Controls_shine.png");
                exit = new Image(exitPos, "images_menu/Exit.png");
                break;
            case 3:
                start = new Image(startPos, "images_menu/Start.png");
                controls = new Image(controlsPos, "images_menu/Controls.png");
                exit = new Image(exitPos, "images_menu/Exit_shine.png");
                break;
        }

        start = start.resizeImage(buttonWidth, buttonHeight);
        controls = controls.resizeImage(buttonWidth, buttonHeight);
        exit = exit.resizeImage(buttonWidth, buttonHeight);
    }

    @Override
    public void getKey(KeyStroke key) throws IOException {
        if (inLevels) {
            menuLevels.getKey(key);

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') {
                if (menuLevels.isBackSelected()) {
                    inLevels = false;
                }
            }
            return;
        }

        switch (key.getKeyType()) {
            case ArrowUp:
                if (currButton > 1) {
                    currButton--;
                    refreshButtons();
                }
                break;
            case ArrowDown:
                if (currButton < 3) {
                    currButton++;
                    refreshButtons();
                }
                break;
            case Character:
                if (key.getCharacter() == ' ') {
                    if (currButton == 1) {
                        menuLevels.resetSelection();
                        inLevels = true;
                        menuLevels.updateSize(background.getWidth(), background.getHeight());
                    }
                    else if (currButton == 2) {

                    }
                    else if (currButton == 3) {
                        screen.stopScreen();
                        running = false;
                    }
                }
                break;
        }
    }

    public void updateSize(int width, int height) throws IOException {
        background = background.resizeImage(width, height);
        int centerX = width / 2;

        title.setPosition(new Position(centerX - title.getWidth() / 2, -85));
        start.setPosition(new Position(centerX - (start.getWidth() / 2), 70));
        controls.setPosition(new Position(centerX - (controls.getWidth() / 2), 130));
        exit.setPosition(new Position(centerX - (exit.getWidth() / 2), 190));

        if (menuLevels != null) {
            menuLevels.updateSize(width, height);
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        if (inLevels) {
            menuLevels.draw(graphics);
        } else {
            background.draw(graphics);
            title.draw(graphics);
            start.draw(graphics);
            controls.draw(graphics);
            exit.draw(graphics);
        }
    }
}