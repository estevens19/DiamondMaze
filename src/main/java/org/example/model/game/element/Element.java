package org.example.model.game.element;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Position;

public abstract class Element {
    private final org.example.Image image;

    public Element(org.example.Image image) {
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
}