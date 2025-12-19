package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public abstract class Maze {
    protected Knight knight;
    protected List<Guard> guards;
    protected List<Wall> walls;
    protected List<Diamond> diamonds;
    protected Key key;
    protected Door door;
    protected Countdown countdown;
    protected boolean showKey = false;
    private final Image background = new Image(new Position(0, 0), "images/Floor.png").resizeImage(640, 360);

    protected int curLevel;

    protected Maze() throws IOException, URISyntaxException, FontFormatException {}

    public Knight getKnight() { return knight; }
    public List<Guard> getGuards() { return guards; }
    public List<Wall> getWalls() { return walls; }
    public List<Diamond> getDiamonds() { return diamonds; }
    public Key getKey() { return key; }
    public Door getDoor() { return door; }
    public Countdown getCountdown(){return countdown;}

    public int getCurLevel(){return curLevel;}

    public boolean getShowKey() {
        return showKey;
    }

    public void setShowKey(boolean showKey) {
        this.showKey = showKey;
    }

    public boolean isWallKnight(Position pos) {
        int knightWidth = 85;
        int knightHeight = 50;
        int wallSide = 20;

        for (Wall wall : walls) {
            Position wallPos = wall.getPosition();

            boolean overlapX = (pos.getX() < wallPos.getX() - wallSide - 5) && (pos.getX() + knightWidth > wallPos.getX() + wallSide - 5);
            boolean overlapY = (pos.getY() < wallPos.getY()) && (pos.getY() + knightHeight > wallPos.getY() + wallSide - 15);

            if (overlapX && overlapY) {
                return true;
            }
        }
        return false;
    }

    public boolean isWallGuard(Position pos) {
        int guardWidth = 55;
        int guardHeight = 40;
        int wallSide = 20;

        for (Wall wall : walls) {
            Position wallPos = wall.getPosition();

            boolean overlapX = (pos.getX() < wallPos.getX() + wallSide - 15) && (pos.getX() + guardWidth > wallPos.getX() + 15);
            boolean overlapY = (pos.getY() < wallPos.getY() + wallSide - 5) && (pos.getY() + guardHeight > wallPos.getY() + 10);

            if (overlapX && overlapY) {
                return true;
            }
        }
        return false;
    }

    public boolean isKnight(Position pos) {
        Position knightPos = knight.getPosition_currentImage();
        int knightWidth = 115, knightHeight = 50;
        int guardWidth = 55, guardHeight = 40;

        boolean overlapX = (pos.getX() < knightPos.getX() + knightWidth - guardWidth - 15) && (pos.getX() + guardWidth > knightPos.getX() + guardWidth + 5);
        boolean overlapY = (pos.getY() < knightPos.getY() + knightHeight - 10) && (pos.getY() + guardHeight > knightPos.getY() + 35);

        if (overlapX && overlapY) {
            return true;
        }
        return false;
    }

    public boolean isGuard(Position pos) {
        int guardWidth = 55;
        int guardHeight = 40;

        for (Guard guard : guards) {
            Position guardPos = guard.getPosition_currentImage();

            boolean overlapX = (pos.getX() < guardPos.getX() - 10) && (pos.getX() + guardWidth > guardPos.getX());
            boolean overlapY = (pos.getY() < guardPos.getY() + 5) && (pos.getY() + guardHeight > guardPos.getY() + 5);

            if (overlapX && overlapY) {
                return true;
            }
        }
        return false;
    }

    public void removeDiamond(Diamond diamond) {
        diamonds.remove(diamond);
    }

    public Diamond isDiamond(Position pos) {
        int knightWidth = 85;
        int knightHeight = 50;

        for (Diamond diamond : diamonds) {
            Position diamondPos = diamond.getPosition();

            boolean overlapX = (pos.getX() < diamondPos.getX() - 30) && (pos.getX() + knightWidth > diamondPos.getX() + 25);
            boolean overlapY = (pos.getY() < diamondPos.getY() - 5) && (pos.getY() + knightHeight > diamondPos.getY() + 10);

            if (overlapX && overlapY) {
                return diamond;
            }
        }
        return null;
    }

    public boolean isKey(Position pos) {
        int knightWidth = 85;
        int knightHeight = 50;

        Position keyPos = key.getPosition();

        boolean overlapX = (pos.getX() < keyPos.getX() - 20) && (pos.getX() + knightWidth > keyPos.getX() + 20);
        boolean overlapY = (pos.getY() < keyPos.getY() - 5) && (pos.getY() + knightHeight > keyPos.getY() + 10);

        if (overlapX && overlapY) {
            return true;
        }
        return false;
    }

    public boolean isDoor(Position pos) {
        int knightWidth = 85;
        int knightHeight = 50;

        Position doorPos = door.getPosition();

        boolean overlapX = (pos.getX() < doorPos.getX() - 30) && (pos.getX() + knightWidth > doorPos.getX() + 40);
        boolean overlapY = (pos.getY() < doorPos.getY()) && (pos.getY() + knightHeight > doorPos.getY() + 30);

        if (overlapX && overlapY) {
            return true;
        }
        return false;
    }

    public Image getBackground() {
        return background;
    }
}