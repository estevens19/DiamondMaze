package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.characters.Guard;
import org.example.model.game.characters.Knight;
import org.example.viewer.Image;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends MazeBuilder {
    private Image background;
    private Image backButton;
    private final int buttonWidth = 320;
    private final int buttonHeight = 90;
    private boolean exitSelected = false;
    private int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        if (level == 1) {
            background = new Image(new Position(0, 0), "images/Background_Maze.png");
            backButton = new Image(new Position(0, 0), "images_menu/Back_shine.png");
        }
        else if (level == 2) {

        }
        else if (level == 3) {

        }
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<Guard> createGuards() {
        List<Guard> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'G') guards.add(new Guard(x, y));
        }

        return guards;
    }

    @Override
    protected Knight createKnight() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'K') return new Knight(x, y);
        }
        return null;
    }
}
