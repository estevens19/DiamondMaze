package org.example.model.menu;

import org.example.model.Position;
import org.example.model.game.maze.Score;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuPassed extends Menu {
    private Image menu;
    private Image level;
    private final Image title;

    private Image star1;
    private Image star2;
    private Image star3;

    private final Image background;

    private final Image restartUnselected;
    private final Image restartSelected;
    private final Image menuUnselected;
    private final Image menuSelected;
    private final Image level2Unselected;
    private final Image level2Selected;
    private final Image level3Unselected;
    private final Image level3Selected;

    private final Image starShine2;
    private final Image starDark2;
    private final Image starShine3;
    private final Image starDark3;

    private int countDiamonds = 0;
    private int countDeads;

    private int currButton = 1;
    private final int buttonWidth = 130;
    private final int buttonHeight = 105;
    private final int starSide = 60;

    private final int curLevel;
    private final Score score;

    public MenuPassed(int curLevel, Score score) throws IOException, URISyntaxException, FontFormatException {
        this.curLevel = curLevel;
        this.score = score;

        this.screenWidth = 640;
        this.screenHeight = 360;

        background = new Image(new Position(0, 0), "images_menu/Passed.png").resizeImage(screenWidth, screenHeight);
        title = new Image(new Position(0, 0), "images_menu/Title_Passed.png").resizeImage(465, 255);

        menuUnselected = new Image(new Position(0, 0), "images_menu/Menu.png").resizeImage(buttonWidth, buttonHeight);
        menuSelected = new Image(new Position(0, 0), "images_menu/Menu_shine.png").resizeImage(buttonWidth, buttonHeight);
        restartUnselected = new Image(new Position(0, 0), "images_menu/Restart.png").resizeImage(buttonWidth, buttonHeight);
        restartSelected = new Image(new Position(0, 0), "images_menu/Restart_shine.png").resizeImage(buttonWidth, buttonHeight);
        level2Unselected = new Image(new Position(0, 0), "images_menu/Level_2.png").resizeImage(buttonWidth, buttonHeight);;
        level2Selected = new Image(new Position(0, 0), "images_menu/Level_2_shine.png").resizeImage(buttonWidth, buttonHeight);;
        level3Unselected = new Image(new Position(0, 0), "images_menu/Level_3.png").resizeImage(buttonWidth, buttonHeight);;
        level3Selected = new Image(new Position(0, 0), "images_menu/Level_3_shine.png").resizeImage(buttonWidth, buttonHeight);;

        star1 = new Image(new Position(0, 0), "images/Star_shine.png").resizeImage(starSide, starSide);
        starDark2 = new Image(new Position(0, 0), "images/Star.png").resizeImage(starSide, starSide);
        starShine2 = new Image(new Position(0, 0), "images/Star_shine.png").resizeImage(starSide, starSide);
        starDark3 = new Image(new Position(0, 0), "images/Star.png").resizeImage(starSide, starSide);
        starShine3 = new Image(new Position(0, 0), "images/Star_shine.png").resizeImage(starSide, starSide);

        refreshButtons();
        refreshStars();
        updateSize(screenWidth, screenHeight);
    }

    private void refreshButtons() {
        Position menuPos = (menu != null) ? menu.getPosition() : new Position(0, 0);
        Position levelPos = (level != null) ? level.getPosition() : new Position(0, 0);

        if (currButton == 1) {
            menu = menuUnselected;
            switch (curLevel) {
                case 1 -> level = level2Selected;
                case 2 -> level = level3Selected;
                case 3 -> level = restartSelected;
            }
        } else {
            menu = menuSelected;
            switch (curLevel) {
                case 1 -> level = level2Unselected;
                case 2 -> level = level3Unselected;
                case 3 -> level = restartUnselected;
            }
        }

        level.setPosition(levelPos);
        menu.setPosition(menuPos);
    }

    private void refreshStars(){
        Position star1Pos = (star1 != null) ? star1.getPosition() : new Position(0, 0);
        Position star2Pos = (star2 != null) ? star2.getPosition() : new Position(0, 0);
        Position star3Pos = (star3 != null) ? star3.getPosition() : new Position(0, 0);


        switch (curLevel) {
            case 1:
                if(score.getPoints() >= 10000){
                    star2 = starShine2;
                    star3 = starShine3;
                }
                else if(score.getPoints() >= 6000){
                    star2 = starShine2;
                    star3 = starDark3;
                }
                else{
                    star2 = starDark2;
                    star3 = starDark3;
                }

                break;
            case 2:
                if(score.getPoints() >= 15000){
                    star2 = starShine2;
                    star3 = starShine3;
                }
                else if(score.getPoints() >= 9000){
                    star2 = starShine2;
                    star3 = starDark3;
                }
                break;
            case 3:
                if(score.getPoints() >= 25000){
                    star2 = starShine2;
                    star3 = starShine3;
                }
                else if(score.getPoints() >= 15000){
                    star2 = starShine2;
                    star3 = starDark3;
                }
                break;
        }

        if (currButton == 1) {
            menu = menuUnselected;
            switch (curLevel) {
                case 1 -> level = level2Selected;
                case 2 -> level = level3Selected;
                case 3 -> level = restartSelected;
            }
        } else {
            menu = menuSelected;
            switch (curLevel) {
                case 1 -> level = level2Unselected;
                case 2 -> level = level3Unselected;
                case 3 -> level = restartUnselected;
            }
        }
        star1.setPosition(star1Pos);
        star2.setPosition(star2Pos);
        star3.setPosition(star3Pos);
    }

    @Override
    public void updateSize(int width, int height) throws IOException {
        setBackground(getBackground().resizeImage(width, height));

        int centerX = width / 2;
        int centerY = (height / 2) - (buttonHeight / 2);
        int spacingButtons = buttonWidth + 15;
        int spacingStars = 28;

        menu.setPosition(new Position(centerX + spacingButtons - (buttonWidth / 2), centerY));
        level.setPosition(new Position(centerX - spacingButtons - (buttonWidth / 2), centerY));
        title.setPosition(new Position(centerX - title.getWidth() / 2 + 14, -40));

        star1.setPosition(new Position(centerX - (buttonWidth / 2) - spacingStars, centerY -20));
        star2.setPosition(new Position(centerX - spacingStars, centerY - 20));
        star3.setPosition(new Position(centerX + (buttonWidth / 2) -spacingStars, centerY-20));
    }

    public int getCurLevel() { return curLevel; }

    @Override
    public Image getBackground() {
        return background;
    }

    public int getCurrButton() {
        return currButton;
    }

    public Image getMenu() {
        return menu;
    }

    public Image getTitle(){
        return title;
    }
    public Image getLevel(){
        return level;
    }

    public void backCurrButton() throws IOException, URISyntaxException, FontFormatException {
        currButton--;
        refreshButtons();
    }

    public void nextCurrButton() throws IOException, URISyntaxException, FontFormatException {
        currButton++;
        refreshButtons();
    }

    public Image getStar1(){
        return star1;
    }

    public Image getStar2(){
        return star2;
    }
    public Image getStar3(){
        return star3;
    }
}