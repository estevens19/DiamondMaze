package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.MenuPassed;
import org.example.viewer.Viewer;

import java.io.IOException;

public class MenuPassedViewer extends Viewer<MenuPassed> {
    public MenuPassedViewer(MenuPassed menu) {
        super(menu);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        gui.drawImage(getModel().getBackground());
        gui.drawImage(getModel().getTitle());
        gui.drawImage(getModel().getLevel());
        gui.drawImage(getModel().getMenu());
    }
}