package org.example.controller.game;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.element.Potion;
import org.example.model.game.maze.Maze;
import org.example.model.menu.MenuGameOver;
import org.example.state.MenuGameOverState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class KnightController extends GameController {
    
    public KnightController(Maze maze) {
        super(maze);
    }

    public void moveKnightLeft() {
        Position posLeft = getModel().getKnight().getPosition_currentImage().getLeft(getModel().getKnightSpeed());

        if (!getModel().isWallKnight(posLeft)) {
            getModel().getKnight().setCurrentImage(getModel().getKnight().getImageLeft());
            moveKnight(posLeft);
            getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
            getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());

            Potion potion = getModel().isPotion(getModel().getKnight().getCurrentImage().getPosition());
            if (potion != null){
                getModel().setPotionEffect(potion);
                getModel().removePotion(potion);
            }
        }
    }

    public void moveKnightRight() {
        Position posRight = getModel().getKnight().getPosition_currentImage().getRight(getModel().getKnightSpeed());

        if (!getModel().isWallKnight(posRight)) {
            getModel().getKnight().setCurrentImage(getModel().getKnight().getImageRight());
            moveKnight(posRight);
            getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
            getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());

            Potion potion = getModel().isPotion(getModel().getKnight().getCurrentImage().getPosition());
            if (potion != null){
                getModel().setPotionEffect(potion);
                getModel().removePotion(potion);
            }
        }
    }

    public void moveKnightUp() {
        Position posUp = getModel().getKnight().getPosition_currentImage().getUp(getModel().getKnightSpeed());

        if (!getModel().isWallKnight(posUp)) {
            moveKnight(posUp);
            getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
            getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
            Potion potion = getModel().isPotion(getModel().getKnight().getCurrentImage().getPosition());
            if (potion != null){
                getModel().setPotionEffect(potion);
                getModel().removePotion(potion);
            }
        }
    }

    public void moveKnightDown() {
        Position posDown = getModel().getKnight().getPosition_currentImage().getDown(getModel().getKnightSpeed());

        if (!getModel().isWallKnight(posDown)) {
            moveKnight(posDown);
            getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
            getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());

            Potion potion = getModel().isPotion(getModel().getKnight().getCurrentImage().getPosition());
            if (potion != null){
                getModel().setPotionEffect(potion);
                getModel().removePotion(potion);
            }
        }
    }

    private void moveKnight(Position position) {
        getModel().getKnight().move(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.UP) {
            Position posUp = getModel().getKnight().getPosition_currentImage().getUp(getModel().getKnightSpeed());
            if (!getModel().isGuard(posUp))
                moveKnightUp();
            else
                game.setState(new MenuGameOverState((new MenuGameOver(getModel().getCurLevel()))));
        }
        if (action == GUI.ACTION.RIGHT) {
            Position posRight = getModel().getKnight().getPosition_currentImage().getRight(getModel().getKnightSpeed());
            if (!getModel().isGuard(posRight))
                moveKnightRight();
            else
                game.setState(new MenuGameOverState((new MenuGameOver(getModel().getCurLevel()))));
        }
        if (action == GUI.ACTION.DOWN) {
            Position posDown = getModel().getKnight().getPosition_currentImage().getDown(getModel().getKnightSpeed());
            if (!getModel().isGuard(posDown))
                moveKnightDown();
            else
                game.setState(new MenuGameOverState((new MenuGameOver(getModel().getCurLevel()))));
        }
        if (action == GUI.ACTION.LEFT) {
            Position posLeft = getModel().getKnight().getPosition_currentImage().getLeft(getModel().getKnightSpeed());
            if (!getModel().isGuard(posLeft))
                moveKnightLeft();
            else
                game.setState(new MenuGameOverState((new MenuGameOver(getModel().getCurLevel()))));
        }
    }
}