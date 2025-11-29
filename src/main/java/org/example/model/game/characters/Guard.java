package org.example.model.game.characters;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Image;
import org.example.model.Position;
import org.example.viewer.LanternaGUI;

import java.io.IOException;

public class Guard extends Character implements LanternaGUI {
    public Guard() throws IOException {
        super(new Image(new Position(800, 120), "images/Guard.png").resizeImage(140, 45));
    }

    @Override
    public void draw(TextGraphics graphics) {
        getImage().draw(graphics);
    }

    public void move(Position newPosition) {
        setPosition(newPosition);
    }
}
