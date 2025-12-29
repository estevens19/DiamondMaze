package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Wall extends Element {
    public Wall(int x, int y) throws IOException, URISyntaxException, FontFormatException {
        super(new Image(new Position(x, y), "images/Wall.png").resizeImage(20, 20));
    }
}