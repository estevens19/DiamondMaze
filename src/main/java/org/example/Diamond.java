package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Diamond extends Element {
    private boolean isKey = false;
    public Diamond() throws IOException {
        super(new Image(new Position(50,50), "images/Diamond.png").resizeImage(75,25));
    }

    public void setKey(){
        isKey = true;
    }
    @Override
    public void draw(TextGraphics graphics) {
        getImage().draw(graphics);
    }
}
