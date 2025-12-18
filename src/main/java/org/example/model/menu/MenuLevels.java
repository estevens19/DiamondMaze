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

    private final Image level1Unselected;
    private final Image level1Selected;
    private final Image level2Unselected;
    private final Image level2Selected;
    private final Image level3Unselected;
    private final Image level3Selected;
    private final Image backUnselected;
    private final Image backSelected;

    private int currButton = 1;
    private final int buttonWidth = 130;
    private final int buttonHeight = 105;

    private MenuMain menuMain;
    //private MazeLevel1 mazeLevel1;
    //private boolean inLevel1 = false;

    public MenuLevels() throws IOException, URISyntaxException, FontFormatException {
        this.screenWidth = 640;
        this.screenHeight = 360;

        level1Unselected = new Image(new Position(0, 0), "images_menu/Level_1.png").resizeImage(buttonWidth, buttonHeight);
        level1Selected = new Image(new Position(0, 0), "images_menu/Level_1_shine.png").resizeImage(buttonWidth, buttonHeight);
        level2Unselected = new Image(new Position(0, 0), "images_menu/Level_2.png").resizeImage(buttonWidth, buttonHeight);
        level2Selected = new Image(new Position(0, 0), "images_menu/Level_2_shine.png").resizeImage(buttonWidth, buttonHeight);
        level3Unselected = new Image(new Position(0, 0), "images_menu/Level_3.png").resizeImage(buttonWidth, buttonHeight);
        level3Selected = new Image(new Position(0, 0), "images_menu/Level_3_shine.png").resizeImage(buttonWidth, buttonHeight);
        backUnselected = new Image(new Position(0, 0), "images_menu/Back.png").resizeImage(buttonWidth, buttonHeight);
        backSelected = new Image(new Position(0, 0), "images_menu/Back_shine.png").resizeImage(buttonWidth, buttonHeight);

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
                level1 = level1Selected;
                level2 = level2Unselected;
                level3 = level3Unselected;
                back = backUnselected;
                break;
            case 2:
                level1 = level1Unselected;
                level2 = level2Selected;
                level3 = level3Unselected;
                back = backUnselected;
                break;
            case 3:
                level1 = level1Unselected;
                level2 = level2Unselected;
                level3 = level3Selected;
                back = backUnselected;
                break;
            case 0:
                level1 = level1Unselected;
                level2 = level2Unselected;
                level3 = level3Unselected;
                back = backSelected;
                break;

        }
        level1.setPosition(l1Pos);
        level2.setPosition(l2Pos);
        level3.setPosition(l3Pos);
        back.setPosition(backPos);
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

    public void backButton() throws IOException, URISyntaxException, FontFormatException {
        currButton = 0;
        refreshButtons();
    }

    public void nextCurrButton() throws IOException, URISyntaxException, FontFormatException {
        currButton++;
        refreshButtons();
    }
}