package org.example.model.game.element;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Position;

import java.io.IOException;

public class Door extends Element {
    Door(Position position) throws IOException {
        super(new Image(position, "images/Door.png").resizeImage(75,25));
    }
/*
    public void openDoor(Key key) throws IOException {
        if (key.isCollected()){
            //levelPassed();
        }
    }
*/
}
