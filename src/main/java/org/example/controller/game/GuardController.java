package org.example.controller.game;

import org.example.Game;
import org.example.model.game.character.Guard;
import org.example.model.Position;
import org.example.gui.GUI;
import org.example.model.game.maze.Maze;
import java.util.Random;

public class GuardController extends GameController {
    Guard guard;
    private long lastMovement = 0;

    public GuardController(Maze maze) {
        super(maze);
    }

    public void moveGuardLeft() {
        Position posLeft = guard.getPosition_currentImage().getLeft(getModel().getGuardSpeed());
        if (!getModel().isWallGuard(posLeft)) {
            guard.setCurrentImage(guard.getImageLeft());
            moveGuard(posLeft);
            guard.setPosition_imageLeft(guard.getCurrentImage().getPosition());
            guard.setPosition_imageRight(guard.getCurrentImage().getPosition());
        }
    }

    public void moveGuardRight() {
        Position posRight = guard.getPosition_currentImage().getRight(getModel().getGuardSpeed());
        if (!getModel().isWallGuard(posRight)) {
            guard.setCurrentImage(guard.getImageRight());
            moveGuard(posRight);
            guard.setPosition_imageLeft(guard.getCurrentImage().getPosition());
            guard.setPosition_imageRight(guard.getCurrentImage().getPosition());
        }
    }

    public void moveGuardUp() {
        Position posUp = guard.getPosition_currentImage().getUp(getModel().getGuardSpeed());
        if (!getModel().isWallGuard(posUp)) {
            moveGuard(posUp);
            guard.setPosition_imageLeft(guard.getCurrentImage().getPosition());
            guard.setPosition_imageRight(guard.getCurrentImage().getPosition());
        }
    }

    public void moveGuardDown() {
        Position posDown = guard.getPosition_currentImage().getDown(getModel().getGuardSpeed());
        if (!getModel().isWallGuard(posDown)) {
            moveGuard(posDown);
            guard.setPosition_imageLeft(guard.getCurrentImage().getPosition());
            guard.setPosition_imageRight(guard.getCurrentImage().getPosition());
        }
    }

    private void moveGuard(Position position) {
        guard.move(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        lastMovement += time;

        if (lastMovement > getModel().getGuardInterval()) {
            Random rand = new Random();

            for (Guard guard : getModel().getGuards()) {
                this.guard = guard;
                int actionNumber = rand.nextInt(4);

                if (actionNumber == 0) moveGuardUp();
                if (actionNumber == 1) moveGuardRight();
                if (actionNumber == 2) moveGuardDown();
                if (actionNumber == 3) moveGuardLeft();
            }
            lastMovement = 0;
        }
    }
}