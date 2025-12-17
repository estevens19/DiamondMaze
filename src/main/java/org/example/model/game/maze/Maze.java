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
}