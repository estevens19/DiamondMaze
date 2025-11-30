package org.example.model.game.maze;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import org.example.*;
import org.example.model.Position;
import org.example.model.game.characters.Guard;
import org.example.model.game.characters.Knight;
import org.example.viewer.Image;

import java.io.IOException;
import java.util.List;

public class MazeLevel1 extends Maze {
    private Position position;
    private Image background;
    private Image backButton;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;
    private boolean backSelected = false;

    private Knight knight;

    private List<Guard> guard;
//  private List<Wall> walls;

    public MazeLevel1() throws IOException {
        this.position = position;
        this.background = background;
        background = new Image(new Position(0, 0), "images/Background_Maze.png");
        backButton = new Image(new Position(0, 0), "images_menu/Back_shine.png");
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

    @Override
    public void updateSize(int width, int height) throws IOException {

    }

    @Override
    public boolean isExitSelected() {
        return false;
    }

    @Override
    public void reset() {

    }
}

 /*   public List<Wall> getWalls() {
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
*/
/*
    public boolean isGuard(Position position) {
        for (Guard guard : guards)
            if (guard.getPosition().equals(position))
                return true;
        return false;
    }
}
*/

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