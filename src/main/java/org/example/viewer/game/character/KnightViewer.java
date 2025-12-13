package org.example.viewer.game.character;

import org.example.model.game.character.Knight;
import org.example.gui.GUI;

public class KnightViewer implements CharacterViewer<Knight> {
    @Override
    public void draw(Knight knight, GUI gui) {
        gui.drawImage(knight.getCurrentImage());
    }
}