package org.example.viewer.game;

import org.example.model.game.characters.Guard;
import org.example.gui.GUI;

public class GuardViewer implements CharacterViewer<Guard> {
    @Override
    public void draw(Guard guard, GUI gui) {
        //gui.drawGuard(guard.getPosition());
    }
}