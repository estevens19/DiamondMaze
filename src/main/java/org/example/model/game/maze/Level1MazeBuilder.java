package org.example.model.game.maze;

import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.character.CharacterFactory;
import org.example.model.game.element.*;

import java.io.IOException;
import java.util.List;

public class Level1MazeBuilder extends MazeBuilder {
    private final MazeParser mazeParser;
    private final ElementFactory elementFactory;
    private final CharacterFactory characterFactory;

    public Level1MazeBuilder() throws IOException {
        LevelFactory factory = new LevelFactory();
        this.elementFactory = factory.elements();
        this.characterFactory = factory.characters();
        this.mazeParser = new MazeParser("levels/level1.txt");
    }

    @Override
    public Maze createMaze() throws IOException {
        return new Maze() { };
    }

    @Override
    protected Knight createKnight() throws IOException {
        return characterFactory.createKnight(mazeParser.find('K'));
    }

    @Override
    protected List<Guard> createGuards() {
        return mazeParser.findAll('g', pos -> {
            try {
                return characterFactory.createGuard(pos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected List<Wall> createWalls() {
        return mazeParser.findAll('w', pos -> {
            try {
                return elementFactory.createWall(pos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected List<Diamond> createDiamonds() {
        return mazeParser.findAll('d', pos -> {
            try {
                return elementFactory.createDiamond(pos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected Key createKey() throws IOException {
        return elementFactory.createKey(mazeParser.find('k'));
    }

    @Override
    protected Door createDoor() throws IOException {
        return elementFactory.createDoor(mazeParser.find('D'));
    }
}