package org.example.model.menu;

public class Menu {
    private Position position;

    public Menu() {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
