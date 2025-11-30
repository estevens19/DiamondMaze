package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public class MenuMain extends Menu {
    private Image title;
    private Image start;
    private Image controls;
    private Image exit;
    private int currButton = 1;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;

    private MenuLevels menuLevels;

    public MenuMain() throws IOException {
        super();
        title = new Image(new Position(0, 0), "images_menu/Title.png");
        title = title.resizeImage(1300, 300);

        menuLevels = new MenuLevels();
        refreshButtons();

        this.screenWidth = 1850;
        this.screenHeight = 340;
        updateSize(screenWidth, screenHeight);
    }

    public Image getTitle() { return title; }
    public Image getStart() { return start; }
    public Image getControls() { return controls; }
    public Image getExit() { return exit; }

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
    public void updateSize(int width, int height) throws IOException {
        setBackground(getBackground().resizeImage(width, height));
        int centerX = width / 2;

        title.setPosition(new Position(centerX - title.getWidth() / 2, -85));
        start.setPosition(new Position(centerX - (start.getWidth() / 2), 70));
        controls.setPosition(new Position(centerX - (controls.getWidth() / 2), 130));
        exit.setPosition(new Position(centerX - (exit.getWidth() / 2), 190));

        if (menuLevels != null) {
            menuLevels.updateSize(width, height);
        }
    }
/*
    public void previousButton() throws IOException {
        if (currButton > 1) {
            currButton--;
            refreshButtons();
            updateSize(screenWidth, screenHeight);
        }
    }

    public void nextButton() throws IOException {
        if (currButton < 3) {
            currButton++;
            refreshButtons();
            updateSize(screenWidth, screenHeight);
        }
    }
*/
    public int getCurrButton() {
        return currButton;
    }

    public void backCurrButton() throws IOException {
        currButton--;
        refreshButtons();
    }

    public void nextCurrButton() throws IOException {
        currButton++;
        refreshButtons();
    }
}