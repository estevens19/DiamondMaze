package org.example.model.game.maze;

import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;

import java.util.List;

public abstract class Maze {
    protected Knight knight;
    protected List<Guard> guards;
    protected List<Wall> walls;
    protected List<Diamond> diamonds;
    protected Key key;
    protected Door door;
    protected Countdown countdown;

    public Knight getKnight() { return knight; }
    public List<Guard> getGuards() { return guards; }
    public List<Wall> getWalls() { return walls; }
    public List<Diamond> getDiamonds() { return diamonds; }
    public Key getKey() { return key; }
    public Door getDoor() { return door; }
    public Countdown getCountdown(){return countdown;}

    public boolean isWall(Position pos) {
        int knightWidth = 85;
        int knightHeight = 50;
        int wallSide = 20;

        for (Wall wall : walls) {
            Position wallPos = wall.getPosition();

            boolean overlapX = (pos.getX() < wallPos.getX() - wallSide - 5) &&
                    (pos.getX() + knightWidth > wallPos.getX() + wallSide - 5);

            boolean overlapY = (pos.getY() < wallPos.getY()) &&
                    (pos.getY() + knightHeight > wallPos.getY() + wallSide - 15);

            if (overlapX && overlapY) {
                return true;
            }
        }
        return false;
    }

    public boolean isGuard(Position pos) {
        for (Guard guard : guards) {
            if (guard.getPosition_currentImage().equals(pos)) {
                return true;
            }
        }
        return false;
    }
}