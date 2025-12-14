package org.example.model.game.character;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.viewer.Image;
import org.example.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Guard extends Character {
    public Guard(int x, int y) throws IOException, URISyntaxException, FontFormatException {
        super(new Image(new Position(x, y), "images/Guard.png").resizeImage(55, 40), new Image(new Position(x, y), "images/Guard_invert.png").resizeImage(55, 40));
    }

    @Override
    public void draw(TextGraphics graphics) {
        getCurrentImage().draw(graphics);
    }

    public void move(Position newPosition) {
        setPosition_currentImage(newPosition);
    }
}