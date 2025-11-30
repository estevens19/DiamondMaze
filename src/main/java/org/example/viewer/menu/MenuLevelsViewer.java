package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.MenuLevels;
import org.example.viewer.Viewer;

import java.io.IOException;

public class MenuLevelsViewer extends Viewer<MenuLevels> {
    public MenuLevelsViewer(MenuLevels menu) {
        super(menu);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        gui.drawImage(getModel().getBackground());
        gui.drawImage(getModel().getLevel1());
        gui.drawImage(getModel().getLevel2());
        gui.drawImage(getModel().getLevel3());
        gui.drawImage(getModel().getBack());
    }
}