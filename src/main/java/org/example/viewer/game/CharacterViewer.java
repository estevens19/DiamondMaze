package org.example.viewer.game;

import org.example.gui.GUI;

public interface CharacterViewer<T extends Character> {
    void draw(T element, GUI gui);
}
