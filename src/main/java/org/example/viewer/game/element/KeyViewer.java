package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Key;

public class KeyViewer implements ElementViewer<Key>{
    @Override
    public void draw(Key key, GUI gui) {
        gui.drawImage(key.getImage());
    }
}

