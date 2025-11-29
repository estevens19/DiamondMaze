package org.example.viewer.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.menu.Menu;

public interface MenuViewer extends Viewer<T extends Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    public void drawMenu(TextGraphics graphics) {
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

    public void drawMenuLevels(TextGraphics graphics) {
        background.draw(graphics);
        level1.draw(graphics);
        level2.draw(graphics);
        level3.draw(graphics);
        back.draw(graphics);
    }
}
