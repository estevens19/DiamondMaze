package org.example.model.game.character;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.viewer.Image;
import org.example.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Knight extends Character {
    public Knight(int x, int y) throws IOException, URISyntaxException, FontFormatException {
        super(new Image(new Position(x, y), "images/Knight.png").resizeImage(115, 50), new Image(new Position(x, y), "images/Knight_invert.png").resizeImage(115, 50));
    }

    @Override
    public void draw(TextGraphics graphics) {
        getCurrentImage().draw(graphics);
    }

    @Override
    public void move(Position newPosition) {
        setPosition_currentImage(newPosition);
    }
}