package org.example.model.game.element;

import org.example.model.Position;

public class Level1ElementFactory implements ElementFactory {
    public Wall createWall(Position p) {
        return new Wall(p.getX(), p.getY());
    }

    public Diamond createDiamond(Position p) {
        return new Diamond(p.getX(), p.getY());
    }

    public Key createKey(Position p) {
        return new Key(p.getX(), p.getY());
    }

    public Door createDoor(Position p) {
        return new Door(p.getX(), p.getY());
    }
}