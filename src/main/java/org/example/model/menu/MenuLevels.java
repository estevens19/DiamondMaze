package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuLevels extends Menu {
    private Image level1;
    private Image level2;
    private Image level3;
    private Image back;
    private int currButton = 1;
    private final int buttonWidth = 130;
    private final int buttonHeight = 105;

    private MenuMain menuMain;
    //private MazeLevel1 mazeLevel1;
    //private boolean inLevel1 = false;

    public MenuLevels() throws IOException, URISyntaxException, FontFormatException {
        this.screenWidth = 640;
        this.screenHeight = 360;
        refreshButtons();
        updateSize(screenWidth, screenHeight);
    }

    private void refreshButtons() throws IOException, URISyntaxException, FontFormatException {
        Position l1Pos = (level1 != null) ? level1.getPosition() : new Position(0, 0);
        Position l2Pos = (level2 != null) ? level2.getPosition() : new Position(0, 0);
        Position l3Pos = (level3 != null) ? level3.getPosition() : new Position(0, 0);
        Position backPos = (back != null) ? back.getPosition() : new Position(0, 0);

        switch (currButton) {
            case 1:
                level1 = new Image(l1Pos, "images_menu/Level_1_shine.png");
                level2 = new Image(l2Pos, "images_menu/Level_2.png");
                level3 = new Image(l3Pos, "images_menu/Level_3.png");
                back = new Image(backPos, "images_menu/Back.png");
                break;
            case 2:
                level1 = new Image(l1Pos, "images_menu/Level_1.png");
                level2 = new Image(l2Pos, "images_menu/Level_2_shine.png");
                level3 = new Image(l3Pos, "images_menu/Level_3.png");
                back = new Image(backPos, "images_menu/Back.png");
                break;
            case 3:
                level1 = new Image(l1Pos, "images_menu/Level_1.png");
                level2 = new Image(l2Pos, "images_menu/Level_2.png");
                level3 = new Image(l3Pos, "images_menu/Level_3_shine.png");
                back = new Image(backPos, "images_menu/Back.png");
                break;
            case 0:
                level1 = new Image(l1Pos, "images_menu/Level_1.png");
                level2 = new Image(l2Pos, "images_menu/Level_2.png");
                level3 = new Image(l3Pos, "images_menu/Level_3.png");
                back = new Image(backPos, "images_menu/Back_shine.png");
                break;
        }

        level1 = level1.resizeImage(buttonWidth, buttonHeight);
        level2 = level2.resizeImage(buttonWidth, buttonHeight);
        level3 = level3.resizeImage(buttonWidth, buttonHeight);
        back = back.resizeImage(buttonWidth, buttonHeight);
    }

    @Override
    public void updateSize(int width, int height) throws IOException {
        setBackground(getBackground().resizeImage(width, height));

        int centerX = width / 2;
        int centerY = (height / 2) - (buttonHeight / 2);
        int spacing = buttonWidth + 5;

        level1.setPosition(new Position(centerX - spacing - (buttonWidth / 2), centerY));
        level2.setPosition(new Position(centerX - (buttonWidth / 2), centerY));
        level3.setPosition(new Position(centerX + spacing - (buttonWidth / 2), centerY));

        int backX = width - buttonWidth - 20;
        int backY = 0;

        back.setPosition(new Position(backX - 20, backY + 20));
    }
/*
    public boolean isBackSelected() {
        return currButton == 0;
    }

    public void resetSelection() throws IOException {
        this.currButton = 1;
        refreshButtons();
        updateSize(screenWidth, screenHeight);
    }

    public void previousButton() throws IOException {
        if (currButton > 0) {
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

    public Image getBack() {
        return back;
    }

    public Image getLevel1() {
        return level1;
    }

    public Image getLevel2() {
        return level2;
    }

    public Image getLevel3() {
        return level3;
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