package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;

public abstract class Element {
    private final Image image;

    public Element(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
    public Position getPosition() {
        return image.getPosition();
    }
    public void setPosition(Position position) {
        image.setPosition(position);
    }
    public abstract void draw(TextGraphics g);
}