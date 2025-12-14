package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public class LevelElementFactory implements ElementFactory {
    private Image wallImage;

    public LevelElementFactory() throws IOException {
        this.wallImage = new Image(new Position(0, 0), "images/Wall.png").resizeImage(20, 20);
    }

    @Override
    public Wall createWall(Position position) {
        return new Wall(position.getX(), position.getY(), wallImage.getSprite());
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