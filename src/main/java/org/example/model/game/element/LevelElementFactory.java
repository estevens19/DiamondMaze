package org.example.model.game.element;

import org.example.model.Position;

import java.io.IOException;

public class LevelElementFactory implements ElementFactory {
    @Override
    public Wall createWall(Position position) throws IOException {
        return new Wall(position.getX(), position.getY());
    }

    @Override
    public Diamond createDiamond(Position position) throws IOException {
        return new Diamond(position.getX(), position.getY());
    }

    @Override
    public Key createKey(Position position) throws IOException {
        return new Key(position.getX(), position.getY());
    }

    @Override
    public Door createDoor(Position position) throws IOException {
        return new Door(position.getX(), position.getY());
    }
}