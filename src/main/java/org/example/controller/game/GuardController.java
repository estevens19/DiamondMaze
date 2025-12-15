package org.example.controller.game;

import org.example.Game;
import org.example.model.game.character.Guard;
import org.example.model.Position;
import org.example.gui.GUI;
import org.example.model.game.maze.Maze;

import java.io.IOException;
/*
public class GuardController extends GameController {
    public GuardController(Maze maze) {
        super(maze);
    }

    public void moveGuardLeft(Guard guard) {
        getModel().getGuard().setCurrentImage(getModel().getKnight().getImageLeft());
        moveGuard(getModel().getKnight().getPosition_currentImage().getLeft());
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
    }

    public void moveGuardRight(Guard guard) {
        getModel().getKnight().setCurrentImage(getModel().getKnight().getImageRight());
        moveGuard(getModel().getKnight().getPosition_currentImage().getRight());
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
    }

    public void moveGuardUp(Guard guard) {
        moveGuard(getModel().getKnight().getPosition_currentImage().getUp());
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
    }

    public void moveGuardDown(Guard guard) {
        moveGuard(getModel().getKnight().getPosition_currentImage().getDown());
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
    }

    private void moveGuard(Position position, Guard guard) {
        if ()
            guard.move(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveGuardUp();
        if (action == GUI.ACTION.RIGHT) moveGuardRight();
        if (action == GUI.ACTION.DOWN) moveGuardDown();
        if (action == GUI.ACTION.LEFT) moveGuardLeft();
    }
}
*/