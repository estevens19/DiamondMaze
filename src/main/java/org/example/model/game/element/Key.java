package org.example.model.game.element;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Position;

import java.io.IOException;

public class Key extends Element {
    private boolean collected = false;

    public Key(Position position) throws IOException {
        super(new Image(position, "images/Key.png").resizeImage(75,25));
    }
    public void collectKey(){
        collected = true;
    }
    public boolean isCollected() {
        return collected;
    }

}
