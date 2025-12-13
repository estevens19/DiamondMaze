package org.example.viewer.game.character;

import org.example.gui.GUI;
import org.example.model.game.character.Character;

public interface CharacterViewer<T extends Character> {
    void draw(T element, GUI gui);
}