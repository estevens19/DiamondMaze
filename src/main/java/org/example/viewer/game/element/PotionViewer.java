package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Potion;

public class PotionViewer implements ElementViewer<Potion>{
    @Override
    public void draw(Potion potion, GUI gui) {
        gui.drawImage(potion.getImage());
    }
}