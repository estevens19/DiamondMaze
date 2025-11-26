package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Key extends Element{
    public Key() throws IOException {
        super(new Image(new Position(50,50), "images/Key.png").resizeImage(75,25));
    }

    @Override
    public void draw(TextGraphics graphics) {
        getImage().draw(graphics);
    }
}
