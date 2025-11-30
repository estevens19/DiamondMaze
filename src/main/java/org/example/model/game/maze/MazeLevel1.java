package org.example.model.game.maze;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import org.example.*;

import java.io.IOException;
import java.util.List;

public class MazeLevel1 extends Maze  {
    private Image background;
    private Image backButton;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;
    private boolean exitSelected = false;


    private final int width;
    private final int height;

    private Knight knight;

    private List<Guard> guard;
    private List<Wall> walls;

    public MazeLevel1(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public List<Guard> getGuard() {
        return guard;
    }

    public void setGuard(List<Guard> guard) {
        this.guard = guard;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}


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

    @Override
    public void updateSize(int width, int height) throws IOException {
        background = background.resizeImage(width, height);
        backButton.setPosition(new Position(20, 0));
        backButton = backButton.resizeImage(buttonWidth, buttonHeight);
    }

    @Override
    public void draw(TextGraphics graphics) throws IOException {
        background.draw(graphics);
        backButton.draw(graphics);
    }

    @Override
    public void getKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
            case ArrowDown:
            case ArrowLeft:
            case ArrowRight:
                break;
            case Character:
                if (key.getCharacter() == ' ') {
                    exitSelected = true;
                }
                break;
        }
    }

    @Override
    public boolean isExitSelected() {
        return exitSelected;
    }

    @Override
    public void reset() {
        exitSelected = false;
    }
}
*/