package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

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
}