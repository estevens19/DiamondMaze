package org.example.controller.game;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.maze.Maze;
import org.example.viewer.Image;

public class KnightController extends GameController {
    public KnightController(Maze maze) {
        super(maze);
    }

    public void moveKnightLeft() {
        getModel().getKnight().setCurrentImage(getModel().getKnight().getImageLeft());
        moveKnight(getModel().getKnight().getPosition_currentImage().getLeft());
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
    }

    public void moveKnightRight() {
        getModel().getKnight().setCurrentImage(getModel().getKnight().getImageRight());
        moveKnight(getModel().getKnight().getPosition_currentImage().getRight());
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
    }

    public void moveKnightUp() {
        moveKnight(getModel().getKnight().getPosition_currentImage().getUp());
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
    }

    public void moveKnightDown() {
        moveKnight(getModel().getKnight().getPosition_currentImage().getDown());
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
    }

    private void moveKnight(Position position) {
        getModel().getKnight().move(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveKnightUp();
        if (action == GUI.ACTION.RIGHT) moveKnightRight();
        if (action == GUI.ACTION.DOWN) moveKnightDown();
        if (action == GUI.ACTION.LEFT) moveKnightLeft();
    }
}