package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.maze.Maze;
import org.example.viewer.Viewer;

import java.util.List;

/*
public class MazeViewer extends Viewer<Maze> {
    public MazeViewer(Maze maze) {
        super(maze);
    }

    @Override
    public void draw(GUI gui) {
        draw(gui, getModel().getKnight(), new KnightViewer());
        draw(gui, getModel().getGuard(), new GuardViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Character> void drawCharacter(GUI gui, T element, CharacterViewer<T> viewer) {
        viewer.draw(knight, gui);
        for (T guard : guards)
            drawCharacter(gui, guard, viewer);
    }
}

*/