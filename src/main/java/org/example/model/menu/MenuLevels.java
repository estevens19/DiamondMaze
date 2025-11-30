package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public class MenuLevels extends Menu {
    private Image background;
    private Image level1;
    private Image level2;
    private Image level3;
    private Image back;
    private int currButton = 1;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;

    private boolean inLevel1 = false;
    //private boolean inLevel2 = false;
    //private boolean inLevel3 = false;

    public MenuLevels() throws IOException {
        background = new Image(new Position(0, 0), "images_menu/Main_Menu.png");
        background = background.resizeImage(320, 280);

        refreshButtons();
    }

    private void refreshButtons() throws IOException {
        Position l1Pos = (level1 != null) ? level1.getPosition() : new Position(0, 0);
        Position l2Pos = (level2 != null) ? level2.getPosition() : new Position(0, 0);
        Position l3Pos = (level3 != null) ? level3.getPosition() : new Position(0, 0);
        Position backPos = (back != null) ? back.getPosition() : new Position(0, 0);

        if (currButton == 1) {
            level1 = new Image(l1Pos, "images_menu/Level_1_shine.png");
            back = new Image(backPos, "images_menu/Back.png");
        }
        else if (currButton == 0) {
            level1 = new Image(l1Pos, "images_menu/Level_1.png");
            back = new Image(backPos, "images_menu/Back_shine.png");
        }
        else {
            level1 = new Image(l1Pos, "images_menu/Level_1.png");
            back = new Image(backPos, "images_menu/Back.png");
        }
        level2 = new Image(l2Pos, "images_menu/Level_2.png");
        level3 = new Image(l3Pos, "images_menu/Level_3.png");

        level1 = level1.resizeImage(buttonWidth, buttonHeight);
        level2 = level2.resizeImage(buttonWidth, buttonHeight);
        level3 = level3.resizeImage(buttonWidth, buttonHeight);
        back = back.resizeImage(buttonWidth, buttonHeight);
    }

    public void updateSize(int width, int height) throws IOException {
        background = background.resizeImage(width, height);

        int centerX = width / 2;
        int centerY = (height / 2) - (buttonHeight / 2);
        int spacing = buttonWidth + 20;

        level1.setPosition(new Position(centerX - spacing - (buttonWidth / 2), centerY));
        level2.setPosition(new Position(centerX - (buttonWidth / 2), centerY));
        level3.setPosition(new Position(centerX + spacing - (buttonWidth / 2), centerY));

        int backX = width - buttonWidth - 20;
        int backY = 0;

        back.setPosition(new Position(backX, backY));
    }
/*
    public void draw(TextGraphics graphics) {
        background.draw(graphics);
        level1.draw(graphics);
        level2.draw(graphics);
        level3.draw(graphics);
        back.draw(graphics);
    }
*/
    public boolean isBackSelected() {
        return currButton == 0;
    }

    public void resetSelection() throws IOException {
        this.currButton = 1;
        refreshButtons();
    }

    @Override
    public void getKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
                if (currButton == 1) {
                    currButton = 0;
                    refreshButtons();
                }
                break;
            case ArrowDown:
                if (currButton == 0) {
                    currButton = 1;
                    refreshButtons();
                }
                break;
            case ArrowLeft:
                break;
            case ArrowRight:
                break;
            case Character:
                if (currButton == 1 && key.getCharacter() == ' ')
                    break;

                break;


        }
    }
}