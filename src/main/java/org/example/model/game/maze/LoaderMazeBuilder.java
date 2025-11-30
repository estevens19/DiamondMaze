package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.characters.Guard;
import org.example.model.game.characters.Knight;
import org.example.model.game.element.Diamond;
import org.example.model.game.element.Door;
import org.example.model.game.element.Key;
import org.example.viewer.Image;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoaderMazeBuilder extends MazeBuilder {
    private Image background;
    private Image backButton;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;
    private boolean exitSelected = false;
    private int level;
    private Knight knight;
    /*
    private List<Guard> guards;
    private List<Diamond> diamonds;
    private Key key;
    private Door door;
*/
    public LoaderMazeBuilder(int level) throws IOException {
        this.level = level;

        if (level == 1) {
            background = new Image(new Position(0, 0), "images/Background_Maze.png");
            backButton = new Image(new Position(0, 0), "images_menu/Back_shine.png");
            this.knight = createKnight();
            /*
            this.guards = createGuards();
            this.diamonds = createDiamonds();
            this.key = createKey();
            this.door = createDoor();
             */

        }
        else if (level == 2) {

        }
        else if (level == 3) {

        }
    }

/*
    @Override
    protected List<Guard> createGuards() throws IOException {
        ArrayList<Guard> guards = new ArrayList<Guard>();
        guards.add(new Guard(800,120));
        guards.add(new Guard(1200, 210));
        return guards;
    }

    @Override
    protected List<Diamond> createDiamonds() throws IOException {
        ArrayList<Diamond> diamonds = new ArrayList<Diamond>();
        diamonds.add(new Diamond(650,120));
        diamonds.add(new Diamond(1200, 250));
        return diamonds;
    }

    @Override
    protected Key createKey() throws IOException {
        return new Key(600, 600);
    }

    @Override
    protected Door createDoor() throws IOException {
        return new Door(900, 600);
    }
*/
    @Override
    protected Knight createKnight() throws IOException {
        return new Knight(800,100);
    }

    public Knight getKnight() {
        return knight;
    }
}

