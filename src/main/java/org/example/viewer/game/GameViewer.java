package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.model.game.characters.Character;
import org.example.model.game.maze.Maze;
import org.example.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Maze> {
    public GameViewer(Maze maze) {
        super(maze);
    }

    @Override
    public void draw(GUI gui) {
        //drawElements(gui, getModel().getWalls(), new WallViewer());
        drawCharacter(gui, getModel().getGuards(), new GuardViewer());
        drawCharacter(gui, getModel().getKnight(), new KnightViewer());

        //gui.drawText(new Position(0, 0), "Energy: " + getModel().getHero().getEnergy(), "#FFD700");
    }

    private void drawCharacter(GUI gui, Object guards, GuardViewer guardViewer) {

    }

    /*
        private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
            for (T element : elements)
                drawElement(gui, element, viewer);
        }
    */
    private <T extends Character> void drawElement(GUI gui, T character, CharacterViewer<T> viewer) {
        viewer.draw(character, gui);
    }
}

