package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.character.CharacterFactory;
import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Level1MazeBuilder extends MazeBuilder {
    private final MazeParser parser;
    private final ElementFactory elementFactory;
    private final CharacterFactory characterFactory;

    public Level1MazeBuilder() throws IOException, URISyntaxException, FontFormatException {
        LevelFactory factory = new LevelFactory();
        this.elementFactory = factory.elements();
        this.characterFactory = factory.characters();
        this.parser = new MazeParser("levels/level1.txt");
    }

    @Override
    protected Maze createMaze() {
        return new Maze() {};
    }

    @Override
    protected void createAllElements() throws IOException, URISyntaxException, FontFormatException {
        List<Wall> walls = new ArrayList<>();
        List<Diamond> diamonds = new ArrayList<>();
        List<Guard> guards = new ArrayList<>();
        Knight knight = null;
        Key key = null;
        Door door = null;
        Countdown countdown = new Countdown(29);

        char[][] map = parser.getMaze();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                Position pos = parser.toPosition(x, y);
                switch (map[y][x]) {
                    case 'w': walls.add(elementFactory.createWall(pos)); break;
                    case 'd': diamonds.add(elementFactory.createDiamond(pos)); break;
                    case 'g': guards.add(characterFactory.createGuard(pos)); break;
                    case 'K': knight = characterFactory.createKnight(pos); break;
                    case 'k': key = elementFactory.createKey(pos); break;
                    case 'D': door = elementFactory.createDoor(pos); break;
                }
            }
        }

        this.maze.walls = walls;
        this.maze.diamonds = diamonds;
        this.maze.guards = guards;
        this.maze.knight = knight;
        this.maze.key = key;
        this.maze.door = door;
        this.maze.countdown = countdown;
        this.maze.countdown.start();
    }
}