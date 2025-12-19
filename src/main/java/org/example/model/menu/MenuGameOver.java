package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuGameOver extends Menu {
    private Image restart;
    private Image menu;
    private final Image title;

    private final Image background;

    private final Image restartUnselected;
    private final Image restartSelected;
    private final Image menuUnselected;
    private final Image menuSelected;


    private int currButton = 1;
    private final int buttonWidth = 130;
    private final int buttonHeight = 105;

    private final int curLevel;

    public MenuGameOver(int curLevel) throws IOException, URISyntaxException, FontFormatException {
        this.curLevel = curLevel;

        this.screenWidth = 640;
        this.screenHeight = 360;

        restartUnselected = new Image(new Position(0, 0), "images_menu/Restart.png").resizeImage(buttonWidth, buttonHeight);
        restartSelected = new Image(new Position(0, 0), "images_menu/Restart_shine.png").resizeImage(buttonWidth, buttonHeight);
        menuUnselected = new Image(new Position(0, 0), "images_menu/Menu.png").resizeImage(buttonWidth, buttonHeight);
        menuSelected = new Image(new Position(0, 0), "images_menu/Menu_shine.png").resizeImage(buttonWidth, buttonHeight);
        background = new Image(new Position(0, 0), "images_menu/Game_Over.png").resizeImage(screenWidth, screenHeight);
        title = new Image(new Position(0, 0), "images_menu/Title_Game_Over.png").resizeImage(465, 255);
        refreshButtons();
        updateSize(screenWidth, screenHeight);
    }

    private void refreshButtons() {
        Position restartPos = (restart != null) ? restart.getPosition() : new Position(0, 0);
        Position menuPos = (menu != null) ? menu.getPosition() : new Position(0, 0);

        switch (currButton) {
            case 1:
                restart = restartSelected;
                menu = menuUnselected;
                break;
            case 2:
                restart = restartUnselected;
                menu = menuSelected;
                break;
        }
        restart.setPosition(restartPos);
        menu.setPosition(menuPos);
    }

    @Override
    public void updateSize(int width, int height) throws IOException {
        setBackground(getBackground().resizeImage(width, height));

        int centerX = width / 2;
        int centerY = (height / 2) - (buttonHeight / 2);
        int spacing = buttonWidth + 5;

        restart.setPosition(new Position(centerX - spacing - (buttonWidth / 2), centerY));
        menu.setPosition(new Position(centerX + spacing - (buttonWidth / 2), centerY));
        title.setPosition(new Position(centerX - title.getWidth() / 2 + 14, -40));
    }

    public int getCurLevel() { return curLevel; }

    @Override
    public Image getBackground() {
        return background;
    }

    public Image getTitle(){
        return title;
    }
    public int getCurrButton() {
        return currButton;
    }

    public Image getRestart() {
        return restart;
    }

    public Image getMenu() {
        return menu;
    }

    public void backCurrButton() throws IOException, URISyntaxException, FontFormatException {
        currButton--;
        refreshButtons();
    }

    public void nextCurrButton() throws IOException, URISyntaxException, FontFormatException {
        currButton++;
        refreshButtons();
    }
}