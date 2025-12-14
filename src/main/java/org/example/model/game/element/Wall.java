package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.image.BufferedImage;

public class Wall extends Element {
    public Wall(int x, int y, BufferedImage sprite) {
        super(new Image(new Position(x, y), sprite));
    }
}