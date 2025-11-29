package org.example.viewer.game.element;


import org.example.gui.GUI;
import org.example.model.game.element.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}