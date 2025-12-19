package org.example.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getRight(int speed) {
        return new Position(x+speed,y);
    }
    public Position getLeft(int speed) {
        return new Position(x-speed,y);
    }
    public Position getUp(int speed) {
        return new Position(x,y-speed);
    }
    public Position getDown(int speed) {
        return new Position(x,y+speed);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}