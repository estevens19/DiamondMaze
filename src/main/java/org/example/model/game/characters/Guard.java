package org.example.model.game.characters;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.gui.LanternaGUI;
import org.example.viewer.Image;
import org.example.model.Position;

import java.io.IOException;

public class Guard extends Character implements LanternaGUI {
    public Guard(int x, int y) throws IOException {
        super(new Image(new Position(x, y), "images/Guard.png").resizeImage(140, 45));
    }

    @Override
    public void draw(TextGraphics graphics) {
        getImage().draw(graphics);
    }

    public void move(Position newPosition) {
        setPosition(newPosition);
    }
}
