package org.example.viewer.game;

import org.example.Maze;
import org.example.gui.GUI;
import org.example.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Maze> {
    public GameViewer(Maze maze) {
        super(maze);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getGuards(), new GuardViewer());
        drawElement(gui, getModel().getKnight(), new KnightViewer());

        //gui.drawText(new Position(0, 0), "Energy: " + getModel().getHero().getEnergy(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}

