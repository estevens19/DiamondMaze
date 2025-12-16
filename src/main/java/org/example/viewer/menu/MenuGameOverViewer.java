package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.MenuGameOver;
import org.example.viewer.Viewer;

import java.io.IOException;

public class MenuGameOverViewer extends Viewer<MenuGameOver> {
    public MenuGameOverViewer(MenuGameOver menu) {
        super(menu);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        gui.drawImage(getModel().getBackground());
        gui.drawImage(getModel().getTitle());
        gui.drawImage(getModel().getRestart());
        gui.drawImage(getModel().getMenu());
    }
}