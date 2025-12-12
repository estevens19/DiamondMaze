package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public class MenuMain extends Menu {
    private Image title;

    private Image start;
    private Image controls;
    private Image exit;

    private final Image startSelected;
    private final Image startUnselected;
    private final Image controlsSelected;
    private final Image controlsUnselected;
    private final Image exitSelected;
    private final Image exitUnselected;

    private int currButton = 1;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;

    private MenuLevels menuLevels;

    public MenuMain() throws IOException {
        super();
        title = new Image(new Position(0, 0), "images_menu/Title.png");
        title = title.resizeImage(1300, 300);

        startUnselected = new Image(new Position(0, 0), "images_menu/Start.png").resizeImage(buttonWidth, buttonHeight);
        startSelected = new Image(new Position(0, 0), "images_menu/Start_shine.png").resizeImage(buttonWidth, buttonHeight);

        controlsUnselected = new Image(new Position(0, 0), "images_menu/Controls.png").resizeImage(buttonWidth, buttonHeight);
        controlsSelected = new Image(new Position(0, 0), "images_menu/Controls_shine.png").resizeImage(buttonWidth, buttonHeight);

        exitUnselected = new Image(new Position(0, 0), "images_menu/Exit.png").resizeImage(buttonWidth, buttonHeight);
        exitSelected = new Image(new Position(0, 0), "images_menu/Exit_shine.png").resizeImage(buttonWidth, buttonHeight);

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

    private void refreshButtons() {
        Position startPos = (start != null) ? start.getPosition() : new Position(0, 0);
        Position controlsPos = (controls != null) ? controls.getPosition() : new Position(0, 0);
        Position exitPos = (exit != null) ? exit.getPosition() : new Position(0, 0);

        switch (currButton) {
            case 1:
                start = startSelected;
                controls = controlsUnselected;
                exit = exitUnselected;
                break;
            case 2:
                start = startUnselected;
                controls = controlsSelected;
                exit = exitUnselected;
                break;
            case 3:
                start = startUnselected;
                controls = controlsUnselected;
                exit = exitSelected;
                break;
        }

        start.setPosition(startPos);
        controls.setPosition(controlsPos);
        exit.setPosition(exitPos);
    }

    @Override
    public void updateSize(int width, int height) throws IOException {
        setBackground(getBackground().resizeImage(width, height));
        int centerX = width / 2;

        title.setPosition(new Position(centerX - title.getWidth() / 2, -110));
        start.setPosition(new Position(centerX - (start.getWidth() / 2), 70));
        controls.setPosition(new Position(centerX - (controls.getWidth() / 2), 130));
        exit.setPosition(new Position(centerX - (exit.getWidth() / 2), 190));

        if (menuLevels != null) {
            menuLevels.updateSize(width, height);
        }
    }

    public int getCurrButton() {
        return currButton;
    }

    public void backCurrButton() throws IOException {
        if (currButton > 1) {
            currButton--;
            refreshButtons();
        }
    }

    public void nextCurrButton() throws IOException {
        if (currButton < 3) {
            currButton++;
            refreshButtons();
        }
    }
}