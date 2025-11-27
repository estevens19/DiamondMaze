package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Door extends Element{
    Door() throws IOException {
        super(new Image(new Position(50,50), "images/Door.png").resizeImage(75,25));
    }
/*
    public void openDoor(Key key) throws IOException {
        if (key.isCollected()){
            //levelPassed();
        }
    }
*/
    @Override
    public void draw(TextGraphics graphics) {
        getImage().draw(graphics);
    }
}
