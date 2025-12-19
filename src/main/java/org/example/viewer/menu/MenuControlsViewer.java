package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.MenuControls;
import org.example.viewer.Viewer;

import java.io.IOException;

public class MenuControlsViewer extends Viewer<MenuControls> {
    public MenuControlsViewer(MenuControls menu) {
        super(menu);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        gui.drawImage(getModel().getBackground());
        gui.drawImage(getModel().getBack());
        gui.drawImage(getModel().getText());
    }
}