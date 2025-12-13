package org.example.model.game.characters;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.viewer.Image;
import org.example.model.Position;

import java.io.IOException;

public class Knight extends Character {
    public Knight(int x, int y) throws IOException {
        super(new Image(new Position(x, y), "images/Knight.png").resizeImage(300, 55), new Image(new Position(x, y), "images/Knight_invert.png").resizeImage(300, 55));
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
