package org.example.model.game.characters;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.viewer.Image;
import org.example.model.Position;

import java.io.IOException;

public class Guard extends Character {
    public Guard(int x, int y) throws IOException {
        super(new Image(new Position(x, y), "images/Guard.png").resizeImage(140, 45), new Image(new Position(800, 120), "images/Guard_invert.png").resizeImage(140, 45));
    }

    @Override
    public void draw(TextGraphics graphics) {
        getCurrentImage().draw(graphics);
    }

    public void move(Position newPosition) {
        setPosition_currentImage(newPosition);
    }
}
