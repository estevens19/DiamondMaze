package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.MenuMain;
import org.example.viewer.Viewer;

import java.io.IOException;

public class MenuMainViewer extends Viewer<MenuMain> {
    public MenuMainViewer(MenuMain menu) {
        super(menu);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        gui.drawImage(getModel().getBackground());
        gui.drawImage(getModel().getTitle());
        gui.drawImage(getModel().getStart());
        gui.drawImage(getModel().getControls());
        gui.drawImage(getModel().getExit());
    }
}