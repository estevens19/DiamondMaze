package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.character.CharacterFactory;
import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level1MazeBuilder extends MazeBuilder {
    private final MazeParser parser;
    private final ElementFactory elementFactory;
    private final CharacterFactory characterFactory;

    public Level1MazeBuilder() throws IOException {
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
    protected void createAllElements() throws IOException {
        List<Wall> walls = new ArrayList<>();
        List<Diamond> diamonds = new ArrayList<>();
        List<Guard> guards = new ArrayList<>();
        Knight knight = null;
        Key key = null;
        Door door = null;

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
    }

    @Override
    protected Knight createKnight() { return maze.knight; }

    @Override
    protected List<Guard> createGuards() { return maze.guards; }

    @Override
    protected List<Wall> createWalls() { return maze.walls; }

    @Override
    protected List<Diamond> createDiamonds() { return maze.diamonds; }

    @Override
    protected Key createKey() { return maze.key; }

    @Override
    protected Door createDoor() { return maze.door; }
}