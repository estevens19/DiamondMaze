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
    protected List<Potion> potions;
    protected Key key;
    protected Door door;
    protected Countdown countdown;
    protected Score score;

    protected int curLevel;

    protected int knightSpeed = 5;
    protected int guardSpeed = 5;
    protected long guardInterval = 800;

    public Knight getKnight() { return knight; }
    public List<Guard> getGuards() { return guards; }
    public List<Wall> getWalls() { return walls; }
    public List<Diamond> getDiamonds() { return diamonds; }
    public Key getKey() { return key; }
    public Door getDoor() { return door; }
    public List<Potion> getPotions() {
        return potions;
    }
    public Countdown getCountdown(){return countdown;}
    public Score getScore() {return score;}

    public int getCurLevel(){return curLevel;}

    public int getKnightSpeed() {
        return knightSpeed;
    }
    public int getGuardSpeed() {
        return guardSpeed;
    }

    public long getGuardInterval() {
        return guardInterval;
    }

    public void setKnightSpeed(int knightSpeed) {
        this.knightSpeed = knightSpeed;
    }

    public void setGuardSpeed(int guardSpeed) {
        this.guardSpeed = guardSpeed;
    }

    public void setGuardInterval(long guardInterval) {
        this.guardInterval = guardInterval;
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

    public Potion isPotion(Position pos) {
        int knightWidth = 55;
        int knightHeight = 40;
        int potionSide = 20;
        
        for (Potion potion : potions) {
            Position potionPos = potion.getPosition();

            boolean overlapX = (pos.getX() < potionPos.getX() + potionSide) && (pos.getX() + knightWidth > potionPos.getX());
            boolean overlapY = (pos.getY() < potionPos.getY() + potionSide) && (pos.getY() + knightHeight > potionPos.getY());

            if (overlapX && overlapY) {
                return potion;
            }
        }
        return null;
    }

    public void removePotion(Potion potion){
        potions.remove(potion);
    }

    public void speedGuard() {
        new Thread(() -> {
            guardInterval = 500;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guardInterval = 800;
        }).start();
    }

    public void slowKnight() {
        new Thread(() -> {
            knightSpeed = 2;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            knightSpeed = 5;
        }).start();
    }

    public void slowGuard() {
        new Thread(() -> {
            guardSpeed = 2;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guardSpeed = 5;
        }).start();
    }

    public void setPotionEffect(Potion potion){
        switch (potion.getEffect()){
            case 0:
                countdown.addTime(10);
                break;
            case 1:
                slowGuard();
                break;
            case 2:
                speedGuard();
                break;
            case 3:
                slowKnight();
                break;
        }
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