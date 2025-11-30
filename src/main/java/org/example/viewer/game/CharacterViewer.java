package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.model.game.characters.Character;

public interface CharacterViewer<T extends Character> {
    void draw(T element, GUI gui);
}
