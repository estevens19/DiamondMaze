package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Door;

public class DoorViewer implements ElementViewer<Door>{
    @Override
    public void draw(Door door, GUI gui) {
        if (!door.isOpen())
            gui.drawImage(door.getImage());
        else
            gui.drawImage(door.getImage2());
    }
}