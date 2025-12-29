package org.example.controller.game.character;

import org.example.Game;
import org.example.controller.command.*;
import org.example.controller.game.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.element.Diamond;
import org.example.model.game.element.Potion;
import org.example.model.game.maze.Maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class KnightController extends GameController {
    private final Map<GUI.ACTION, Command> commands;

    public KnightController(Maze maze) {
        super(maze);
        this.commands = new HashMap<>();
        initCommands();
    }

    private void initCommands() {
        commands.put(GUI.ACTION.UP, new MoveUpCommand());
        commands.put(GUI.ACTION.RIGHT, new MoveRightCommand());
        commands.put(GUI.ACTION.DOWN, new MoveDownCommand());
        commands.put(GUI.ACTION.LEFT, new MoveLeftCommand());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        Command command = commands.get(action);
        if (command != null) {
            command.execute(this);
        }

        checkGameStatus(game);
    }

    private void checkGameStatus(Game game) throws IOException, URISyntaxException, FontFormatException {
        Position currentKnightPos = getModel().getKnight().getPosition_currentImage();
        if (getModel().isGuard(currentKnightPos)) {
            game.onMenuGameOver();
        }

        if (getModel().isDoor(currentKnightPos) && getModel().getDoor().isOpen()) {
            game.onMenuPassed(getModel().getCurLevel(), getModel().getScore());
        }
    }

    public void moveKnightLeft() {
        Position posLeft = getModel().getKnight().getPosition_currentImage().getLeft(getModel().getKnightSpeed());
        getModel().getKnight().setCurrentImage(getModel().getKnight().getImageLeft());
        processMove(posLeft);
    }

    public void moveKnightRight() {
        Position posRight = getModel().getKnight().getPosition_currentImage().getRight(getModel().getKnightSpeed());
        getModel().getKnight().setCurrentImage(getModel().getKnight().getImageRight());
        processMove(posRight);
    }

    public void moveKnightUp() {
        Position posUp = getModel().getKnight().getPosition_currentImage().getUp(getModel().getKnightSpeed());
        processMove(posUp);
    }

    public void moveKnightDown() {
        Position posDown = getModel().getKnight().getPosition_currentImage().getDown(getModel().getKnightSpeed());
        processMove(posDown);
    }

    private void processMove(Position nextPos) {
        if (getModel().isWallKnight(nextPos)) {
            return;
        }
        moveKnight(nextPos);
        getModel().getKnight().setPosition_imageLeft(getModel().getKnight().getCurrentImage().getPosition());
        getModel().getKnight().setPosition_imageRight(getModel().getKnight().getCurrentImage().getPosition());
        checkInteractions(nextPos);
    }

    private void moveKnight(Position position) {
        getModel().getKnight().move(position);
    }

    private void checkInteractions(Position pos) {
        Diamond diamond = getModel().isDiamond(pos);
        if (diamond != null) {
            if (diamond.isKey()) {
                getModel().setShowKey(true);
            }
            getModel().addScorePoints(diamond.getPoints());
            getModel().removeDiamond(diamond);
        }

        if (getModel().isKey(pos) && getModel().getShowKey()) {
            getModel().getDoor().openDoor(true);
            getModel().setShowKey(false);
        }

        Potion potion = getModel().isPotion(pos);
        if (potion != null){
            getModel().setPotionEffect(potion);
            getModel().removePotion(potion);
        }
    }
}