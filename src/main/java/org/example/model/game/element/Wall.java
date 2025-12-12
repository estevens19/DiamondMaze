package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public class Wall extends Element{
    Wall(int x, int y) throws IOException {
        super(new Image(new Position(x, y), "images/Wall.png").resizeImage(75, 25));
    }
}