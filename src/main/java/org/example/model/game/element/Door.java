package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Door extends Element {
    public Door(int x, int y) throws IOException, URISyntaxException, FontFormatException {
        super(new Image(new Position(x,y), "images/Door.png").resizeImage(40,40));
    }
/*
    public void openDoor(Key key) throws IOException {
        if (key.isCollected()){
            //levelPassed();
        }
    }
*/
}