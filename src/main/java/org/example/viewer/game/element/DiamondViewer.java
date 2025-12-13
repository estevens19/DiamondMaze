package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Diamond;

public class DiamondViewer implements ElementViewer<Diamond>{
    @Override
    public void draw(Diamond diamond, GUI gui) {
        gui.drawImage(diamond.getImage());
    }
}
