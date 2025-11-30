package org.example.viewer.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.gui.GUI;
import org.example.model.menu.Menu;

public interface MenuViewer<T extends Menu> {
    void draw(T element, GUI gui);
/*
{
        if (inLevels) {
            menuLevels.draw(graphics);
        } else {
            background.draw(graphics);
            title.draw(graphics);
            start.draw(graphics);
            controls.draw(graphics);
            exit.draw(graphics);
        }
    }

    public void drawMenuLevels(T element, GUI gui)) {
        background.draw(graphics);
        level1.draw(graphics);
        level2.draw(graphics);
        level3.draw(graphics);
        back.draw(graphics);
    }
}
*/
