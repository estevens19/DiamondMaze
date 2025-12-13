package org.example.model.game.characters;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.viewer.Image;
import org.example.model.Position;

public abstract class Character {
    private Image imageLeft;
    private Image imageRight;
    private Image currentImage;

    public Character(Image imageRight, Image imageLeft) {
        this.imageLeft = imageLeft;
        this.imageRight = imageRight;
        this.currentImage = imageRight;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public Position getPosition_currentImage() {
       return getCurrentImage().getPosition();
    }

    public void setPosition_currentImage(Position position) {
        currentImage.setPosition(position);
    }

    public void setPosition_imageLeft(Position position) {
        imageLeft.setPosition(position);
    }

    public void setPosition_imageRight(Position position) {
        imageRight.setPosition(position);
    }

    public Image getImageRight() {
        return imageRight;
    }

    public Image getImageLeft() {
        return imageLeft;
    }

    public abstract void draw(TextGraphics graphics);

    public abstract void move(Position newPosition);

    //public abstract void attack(Character target);
}