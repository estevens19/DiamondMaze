package org.example.controller.game.character;

import org.example.Game;
import org.example.controller.game.GameController;
import org.example.controller.game.strategy.MoveStrategy;
import org.example.controller.game.strategy.RandomMoveStrategy;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.maze.Maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GuardController extends GameController {
    private final MoveStrategy strategy;
    private long lastMovement = 0;

    public GuardController(Maze maze) {
        super(maze);
        this.strategy = new RandomMoveStrategy();
    }

    private void moveGuard(Guard guard, Position position) {
        guard.move(position);
        guard.setPosition_imageLeft(guard.getCurrentImage().getPosition());
        guard.setPosition_imageRight(guard.getCurrentImage().getPosition());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        lastMovement += time;

        if (lastMovement > getModel().getGuardInterval()) {
            for (Guard guard : getModel().getGuards()) {
                Position nextPos = strategy.getNextMove(guard, getModel());
                if (nextPos != null) {
                    if (getModel().isKnight(nextPos)) {
                        game.onMenuGameOver();
                    } else if (!getModel().isWallGuard(nextPos)) {
                        if (nextPos.getX() < guard.getPosition_currentImage().getX()) guard.setCurrentImage(guard.getImageLeft());
                        if (nextPos.getX() > guard.getPosition_currentImage().getX()) guard.setCurrentImage(guard.getImageRight());

                        moveGuard(guard, nextPos);
                    }
                }
            }
            lastMovement = 0;
        }
    }
}