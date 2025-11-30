package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public class Door extends Element {
    public Door(int x, int y) throws IOException {
        super(new Image(new Position(x,y), "images/Door.png").resizeImage(75,25));
    }
/*
    public void openDoor(Key key) throws IOException {
        if (key.isCollected()){
            //levelPassed();
        }
    }
*/
}
