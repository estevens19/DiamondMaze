package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.characters.Knight;
import org.example.viewer.Image;

import java.io.IOException;

public abstract class Maze {
    private Image background;
    private Image backButton;
    private int buttonWidth;
    private int buttonHeight;
    private Knight knight;

    public Maze() throws IOException {
        background = new Image(new Position(0, 0), "images/Background_Maze.png");
        backButton = new Image(new Position(0, 0), "images_menu/Back_shine.png");
        buttonWidth = 320;
        buttonHeight = 90;
        updateSize(1850, 340);
    }

    public void updateSize(int width, int height) throws IOException {
        background = background.resizeImage(width, height);
        backButton.setPosition(new Position(20, 0));
        backButton = backButton.resizeImage(buttonWidth, buttonHeight);
    }

    public abstract Knight getKnight();

    public abstract void setKnight(Knight knight);

    //public abstract void draw(TextGraphics graphics) throws IOException;

    //public abstract void updateSize(int width, int height) throws IOException;

    //public abstract boolean isExitSelected();

    //public abstract void reset();

    /*
        public class MazeLevel1 extends Maze {
            private Image background;
            private Image backButton;
            private final int buttonWidth = 320;
            private final int buttonHeight = 90;
            private boolean exitSelected = false;

            public MazeLevel1() throws IOException {
                background = new Image(new Position(0, 0), "images/Background_Maze.png");
                backButton = new Image(new Position(0, 0), "images_menu/Back_shine.png");
            }

            public Maze CreateMazeLevel1() throws IOException {

                return new MazeLevel1();
            }
        */

    public Image getBackButton() {
        return backButton;
    }

    public Image getBackground() {
        return background;
    }

    public int getButtonWidth() {
        return buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }
}