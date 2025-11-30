package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public class Key extends Element {
    private boolean collected = false;

    public Key(int x, int y) throws IOException {
        super(new Image(new Position(x,y), "images/Key.png").resizeImage(75,25));
    }
    public void collectKey(){
        collected = true;
    }
    public boolean isCollected() {
        return collected;
    }

}
