package org.example.controller.game.strategy;

import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.maze.Maze;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public Position getNextMove(Guard guard, Maze maze) {
        Random rand = new Random();
        int actionNumber = rand.nextInt(4);

        Position nextPos = null;
        Position currentPos = guard.getPosition_currentImage();
        int speed = maze.getGuardSpeed();

        switch (actionNumber) {
            case 0:
                nextPos = currentPos.getUp(speed);
                break;
            case 1:
                nextPos = currentPos.getRight(speed);
                break;
            case 2:
                nextPos = currentPos.getDown(speed);
                break;
            case 3:
                nextPos = currentPos.getLeft(speed);
                break;
        }
        return nextPos;
    }
}
