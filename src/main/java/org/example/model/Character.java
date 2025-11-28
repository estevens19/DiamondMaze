package org.example.model;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Position;

public abstract class Character {
    private org.example.Image image;

    public Character(org.example.Image image) {
        this.image = image;
    }

    public org.example.Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Position getPosition() {
        return image.getPosition();
    }

    public void setPosition(Position position) {
        this.image.setPosition(position);
    }

    public abstract void draw(TextGraphics graphics);
    public abstract void move(Position newPosition);
    //public abstract void attack(Character target);
}