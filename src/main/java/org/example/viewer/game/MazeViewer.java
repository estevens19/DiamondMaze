package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.gui.LanternaGUI;
import org.example.model.game.character.Character;
import org.example.model.game.element.Element;
import org.example.model.game.maze.Countdown;
import org.example.model.game.maze.Maze;
import org.example.viewer.Viewer;
import org.example.viewer.game.character.CharacterViewer;
import org.example.viewer.game.character.GuardViewer;
import org.example.viewer.game.character.KnightViewer;
import org.example.viewer.game.element.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class MazeViewer extends Viewer<Maze> {
    public MazeViewer(Maze maze) {
        super(maze);
    }

    @Override
    public void draw(GUI gui) throws IOException, URISyntaxException, FontFormatException {
        gui.clear();

        //gui.drawImage(getModel().getBackground());
        drawElement(gui, getModel().getDoor(), new DoorViewer());
        drawElements(gui, getModel().getDiamonds(), new DiamondViewer());
        if (getModel().getShowKey()) {
            drawElement(gui, getModel().getKey(), new KeyViewer());
        }
        drawElements(gui, getModel().getPotions(), new PotionViewer());
        drawCharacter(gui, getModel().getKnight(), new KnightViewer());
        drawCharacters(gui, getModel().getGuards(), new GuardViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawCountdown(gui, getModel().getCountdown());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    private <T extends Character> void drawCharacters(GUI gui, List<T> characters, CharacterViewer<T> viewer) {
        for (T character : characters)
            drawCharacter(gui, character, viewer);
    }

    private <T extends Character> void drawCharacter(GUI gui, T character, CharacterViewer<T> viewer) {
        viewer.draw(character, gui);
    }

    private void drawCountdown(GUI gui, Countdown countdown) throws IOException, URISyntaxException, FontFormatException {
        gui.drawImage(countdown.timeImage());
    }
}