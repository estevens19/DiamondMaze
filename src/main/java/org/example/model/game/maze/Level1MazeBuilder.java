package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.character.CharacterFactory;
import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    protected Maze createMaze() throws IOException, URISyntaxException, FontFormatException {
        return new Maze() {};
    }

    @Override
    protected void setCurLevel(){
        this.maze.curLevel = 1;
    }

    @Override
    protected void createAllElements() throws IOException, URISyntaxException, FontFormatException {
        List<Wall> walls = new ArrayList<>();
        List<Diamond> diamonds = new ArrayList<>();
        List<Guard> guards = new ArrayList<>();
        List<Potion> potions = new ArrayList<>();
        Knight knight = null;
        Key key = null;
        Door door = null;
        Countdown countdown = new Countdown(800);

        Score score = new Score();

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
                    case 'p': potions.add(elementFactory.createPotion(pos)); break;
                }
            }
        }

        Random rand = new Random();
        int val = rand.nextInt(diamonds.size()-1);
        diamonds.get(val).setKey();

        this.maze.walls = walls;
        this.maze.diamonds = diamonds;
        this.maze.guards = guards;
        this.maze.knight = knight;
        this.maze.potions = potions;
        this.maze.key = key;
        this.maze.door = door;

        this.maze.countdown = countdown;
        this.maze.countdown.start();

        this.maze.score = score;
    }
}