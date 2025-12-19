package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class LevelElementFactory implements ElementFactory {
    private Image wallImage;

    public LevelElementFactory() throws IOException, URISyntaxException, FontFormatException {
        this.wallImage = new Image(new Position(0, 0), "images/Wall.png").resizeImage(20, 20);
    }

    @Override
    public Wall createWall(Position position) {
        return new Wall(position.getX(), position.getY(), wallImage.getSprite());
    }

    @Override
    public Diamond createDiamond(Position position) throws IOException, URISyntaxException, FontFormatException {
        return new Diamond(position.getX(), position.getY());
    }

    @Override
    public Key createKey(Position position) throws IOException, URISyntaxException, FontFormatException {
        return new Key(position.getX(), position.getY());
    }

    @Override
    public Door createDoor(Position position) throws IOException, URISyntaxException, FontFormatException {
        return new Door(position.getX(), position.getY());
    }

    @Override
    public Potion createPotion(Position position) throws IOException, URISyntaxException, FontFormatException {
        return new Potion(position.getX(), position.getY());
    }
}