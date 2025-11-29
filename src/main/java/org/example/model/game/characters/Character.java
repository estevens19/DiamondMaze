package org.example.model.game.characters;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Image;
import org.example.model.Position;

public abstract class Character {
    private Image image;

    public Character(Image image) {
        this.image = image;
    }

    public Image getImage() {
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