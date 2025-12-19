package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Door extends Element {
    private boolean open = false;
    public Door(int x, int y) throws IOException, URISyntaxException, FontFormatException {
        super(new Image(new Position(x,y), "images/Door.png").resizeImage(40,40), new Image(new Position(x,y), "images/DoorOpen.png").resizeImage(40,40));
    }

    public boolean isOpen() {
        return open;
    }
    public void openDoor(boolean open) {
        this.open = open;
    }
}