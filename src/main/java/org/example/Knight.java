package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Character;

import java.io.IOException;

public class Knight extends Character implements LanternaGUI {
    public Knight() throws IOException {
        super(new Image(new Position(800, 100), "images/Knight.png").resizeImage(300, 55));
    }

    @Override
    public void draw(TextGraphics graphics) {
        getImage().draw(graphics);
    }

    public void move(Position newPosition) {
        setPosition(newPosition);
    }
}
