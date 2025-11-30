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
    private boolean inLevels = false;

    //private Menu_Levels menuControls;
    //private boolean inControls = false;

    public MenuMain() throws IOException {
        super();
        title = new Image(new Position(0, 0), "images_menu/Title.png");
        title = title.resizeImage(1300, 250);

        menuLevels = new MenuLevels();
        refreshButtons();
    }

    public boolean getMenuLevels() {
        return inLevels;
    }

    public void setMenuLevels(boolean value) {
        inLevels = value;
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

    public void updateSize(int width, int height) throws IOException {
        getBackground().resizeImage(width, height);
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
    public void draw(TextGraphics graphics) {
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

 */

    public void backCurrButton() throws IOException {
        currButton--;
        refreshButtons();
    }

    public void nextCurrButton() throws IOException {
        currButton++;
        refreshButtons();
    }

    public int getCurrButton() throws IOException {
        return currButton;
    }

/*
    public State getStateInLevels() {
        return stateInLevels;
    }

    public void setStateInLevels(State stateInLevels) {
        this.stateInLevels = stateInLevels;
    }

*/
}