package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Key extends Element {
    private boolean collected = false;

    public Key(int x, int y) throws IOException, URISyntaxException, FontFormatException {
        super(new Image(new Position(x,y), "images/Key.png").resizeImage(25,25));
    }
    public void collectKey(boolean collected) {
        this.collected = collected;
    }
    public boolean isCollected() {
        return collected;
    }
}