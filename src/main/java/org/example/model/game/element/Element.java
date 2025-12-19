package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

public abstract class Element {
    private final Image image;
    private Image image2;

    public Element(Image image) {
        this.image = image;
    }
    public Element(Image image1, Image image2) {
        this.image = image1;
        this.image2 = image2;
    }

    public Image getImage() {
        return image;
    }
    public Image getImage2() { return image2; }
    public Position getPosition() {
        return image.getPosition();
    }
    public void setPosition(Position position) {
        image.setPosition(position);
    }
}