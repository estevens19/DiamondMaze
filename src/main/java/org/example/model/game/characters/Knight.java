package org.example.model.game.characters;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.gui.LanternaGUI;
import org.example.viewer.Image;
import org.example.model.Position;

import java.io.IOException;

public class Knight extends Character {
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
