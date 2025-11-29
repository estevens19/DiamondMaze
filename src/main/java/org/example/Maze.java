package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import org.example.controller.InputHandler;
import org.example.viewer.Image;
import org.example.model.Position;
import org.example.model.game.characters.Guard;
import org.example.model.game.characters.Knight;
import org.example.viewer.LanternaGUI;

import java.io.IOException;

public class Maze implements InputHandler, LanternaGUI {
    private Image background;
    private Image backButton;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;
    private boolean exitSelected = false;
    private Knight knight;
    private Guard guard;

    public Maze() throws IOException {
        background = new Image(new Position(0, 0), "images/Background_Maze.png");

        backButton = new Image(new Position(0, 0), "images_menu/Back_shine.png");

        knight = new Knight();
        guard = new Guard();
    }

    public void updateSize(int width, int height) throws IOException {
        background = background.resizeImage(width, height);
        backButton.setPosition(new Position(20, 0));
        backButton = backButton.resizeImage(buttonWidth, buttonHeight);
    }

    @Override
    public void draw(TextGraphics graphics) throws IOException {
        background.draw(graphics);
        backButton.draw(graphics);
        knight.draw(graphics);
        guard.draw(graphics);
    }

    @Override
    public void getKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
                knight.move(new Position(knight.getPosition().getX(), knight.getPosition().getY()-10));
                break;
            case ArrowDown:
                knight.move(new Position(knight.getPosition().getX(), knight.getPosition().getY()+10));
                break;
            case ArrowLeft:
                knight.move(new Position(knight.getPosition().getX()-10, knight.getPosition().getY()));
                knight.setImage(new Image(new Position(knight.getPosition().getX(), knight.getPosition().getY()), "images/Knight_invert.png").resizeImage(300, 55));
                break;
            case ArrowRight:
                knight.move(new Position(knight.getPosition().getX()+10, knight.getPosition().getY()));
                knight.setImage(new Image(new Position(knight.getPosition().getX(), knight.getPosition().getY()), "images/Knight.png").resizeImage(300, 55));
                break;
            case Character:
                if (key.getCharacter() == ' ') {
                    exitSelected = true;
                }
                break;
        }
    }

    public boolean isExitSelected() {
        return exitSelected;
    }

    public void reset() {
        exitSelected = false;
    }
}