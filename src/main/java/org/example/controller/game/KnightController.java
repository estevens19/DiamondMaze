package org.example.controller.game;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.element.Diamond;
import org.example.model.game.element.Potion;
import org.example.model.game.maze.Maze;
import org.example.model.menu.MenuGameOver;
import org.example.model.menu.MenuPassed;
import org.example.state.MenuGameOverState;
import org.example.state.MenuPassedState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class KnightController extends GameController {
    public KnightController(Maze maze) {
        super(maze);
    }

    public void moveKnightLeft() {
        Position posLeft = getModel().getKnight().getPosition_currentImage().getLeft();

        if (!getModel().isWallKnight(posLeft)) {
            getModel().getKnight().setCurrentImage(getModel().getKnight().getImageLeft());
            moveKnight(posLeft);
            getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
            getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());

            Diamond diamond = getModel().isDiamond(getModel().getKnight().getPosition_currentImage());
            if (diamond != null) {
                if (diamond.isKey()) {
                    getModel().setShowKey(true);
                }
                getModel().addScorePoints(diamond.getPoints());
                getModel().removeDiamond(diamond);
            }

            if (getModel().isKey(getModel().getKnight().getPosition_currentImage()) && getModel().getShowKey()) {
                getModel().getDoor().openDoor(true);
                getModel().setShowKey(false);
            }
            Potion potion = getModel().isPotion(getModel().getKnight().getCurrentImage().getPosition());
            if (potion != null){
                getModel().setPotionEffect(potion);
                getModel().removePotion(potion);
            }
        }
    }

    public void moveKnightRight() {
        Position posRight = getModel().getKnight().getPosition_currentImage().getRight();

        if (!getModel().isWallKnight(posRight)) {
            getModel().getKnight().setCurrentImage(getModel().getKnight().getImageRight());
            moveKnight(posRight);
            getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
            getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());

            Diamond diamond = getModel().isDiamond(getModel().getKnight().getPosition_currentImage());
            if (diamond != null) {
                if (diamond.isKey()) {
                    getModel().setShowKey(true);
                }
                getModel().addScorePoints(diamond.getPoints());
                getModel().removeDiamond(diamond);
            }

            if (getModel().isKey(getModel().getKnight().getPosition_currentImage()) && getModel().getShowKey()) {
                getModel().getDoor().openDoor(true);
                getModel().setShowKey(false);
            }

            Potion potion = getModel().isPotion(getModel().getKnight().getCurrentImage().getPosition());
            if (potion != null){
                getModel().setPotionEffect(potion);
                getModel().removePotion(potion);
            }
        }
    }

    public void moveKnightUp() {
        Position posUp = getModel().getKnight().getPosition_currentImage().getUp();

        if (!getModel().isWallKnight(posUp)) {
            moveKnight(posUp);
            getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
            getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());

            Diamond diamond = getModel().isDiamond(getModel().getKnight().getPosition_currentImage());
            if (diamond != null) {
                if (diamond.isKey()) {
                    getModel().setShowKey(true);
                }
                getModel().addScorePoints(diamond.getPoints());
                getModel().removeDiamond(diamond);
            }

            if (getModel().isKey(getModel().getKnight().getPosition_currentImage()) && getModel().getShowKey()) {
                getModel().getDoor().openDoor(true);
                getModel().setShowKey(false);
            }
            Potion potion = getModel().isPotion(getModel().getKnight().getCurrentImage().getPosition());
            if (potion != null){
                getModel().setPotionEffect(potion);
                getModel().removePotion(potion);
            }
        }
    }

    public void moveKnightDown() {
        Position posDown = getModel().getKnight().getPosition_currentImage().getDown();

        if (!getModel().isWallKnight(posDown)) {
            moveKnight(posDown);
            getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
            getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());

            Diamond diamond = getModel().isDiamond(getModel().getKnight().getPosition_currentImage());
            if (diamond != null) {
                if (diamond.isKey()) {
                    getModel().setShowKey(true);
                }
                getModel().addScorePoints(diamond.getPoints());
                getModel().removeDiamond(diamond);
            }

            if (getModel().isKey(getModel().getKnight().getPosition_currentImage()) && getModel().getShowKey()) {
                getModel().getDoor().openDoor(true);
                getModel().setShowKey(false);
            }
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
            Position posUp = getModel().getKnight().getPosition_currentImage().getUp();

            if (!getModel().isGuard(posUp))
                moveKnightUp();
            else
                game.setState(new MenuGameOverState((new MenuGameOver(getModel().getCurLevel()))));
            if (getModel().isDoor(posUp) && getModel().getDoor().isOpen()) {
                if (getModel().getCurLevel() == 1)
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
                else if (getModel().getCurLevel() == 2)
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
                else
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
            }
        }
        if (action == GUI.ACTION.RIGHT) {
            Position posRight = getModel().getKnight().getPosition_currentImage().getRight();
            if (!getModel().isGuard(posRight))
                moveKnightRight();
            else
                game.setState(new MenuGameOverState((new MenuGameOver(getModel().getCurLevel()))));
            if (getModel().isDoor(posRight) && getModel().getDoor().isOpen()) {
                if (getModel().getCurLevel() == 1)
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
                else if (getModel().getCurLevel() == 2)
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
                else
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
            }
        }
        if (action == GUI.ACTION.DOWN) {
            Position posDown = getModel().getKnight().getPosition_currentImage().getDown();
            if (!getModel().isGuard(posDown))
                moveKnightDown();
            else
                game.setState(new MenuGameOverState((new MenuGameOver(getModel().getCurLevel()))));
            if (getModel().isDoor(posDown) && getModel().getDoor().isOpen()) {
                if (getModel().getCurLevel() == 1)
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
                else if (getModel().getCurLevel() == 2)
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
                else
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
            }
        }
        if (action == GUI.ACTION.LEFT) {
            Position posLeft = getModel().getKnight().getPosition_currentImage().getLeft();
            if (!getModel().isGuard(posLeft))
                moveKnightLeft();
            else
                game.setState(new MenuGameOverState((new MenuGameOver(getModel().getCurLevel()))));
            if (getModel().isDoor(posLeft) && getModel().getDoor().isOpen()) {
                if (getModel().getCurLevel() == 1)
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
                else if (getModel().getCurLevel() == 2)
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
                else
                    game.setState(new MenuPassedState(new MenuPassed(getModel().getCurLevel(), getModel().getScore())));
            }
        }
    }
}