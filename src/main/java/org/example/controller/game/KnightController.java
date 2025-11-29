package com.org.example.controller.game;

import org.example.Game;
import org.example.Maze;
import org.example.model.Position;
import org.example.controller.game.GameController;
import org.example.gui.GUI;

public class KnightController extends GameController {
    public HeroController(Maze maze) {
        super(maze);
    }

    public void moveKnightLeft() {
        moveKnight(getModel().getKnight().getPosition().getLeft());
    }

    public void moveKnightRight() {
        moveKnight(getModel().getKnight().getPosition().getRight());
    }

    public void moveKnightUp() {
        moveKnight(getModel().getKnight().getPosition().getUp());
    }

    public void moveKnightDown() {
        moveKnight(getModel().getKnight().getPosition().getDown());
    }

    private void moveKnight(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getKnight().setPosition(position);
            if (getModel().isGuard(position)) getModel().getKnight().decreaseEnergy();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveKnightUp();
        if (action == GUI.ACTION.RIGHT) moveKnightRight();
        if (action == GUI.ACTION.DOWN) moveKnightDown();
        if (action == GUI.ACTION.LEFT) moveKnightLeft();
    }
}