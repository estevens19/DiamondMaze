package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Wall;

public class WallViewer implements ElementViewer<Wall>{
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawImage(wall.getImage());
    }
}

