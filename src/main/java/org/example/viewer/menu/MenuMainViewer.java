package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.Menu;

public class MenuMainViewer implements MenuViewer {
    @Override
    public void draw(Menu menu_main, GUI gui) {
        gui.draw(menu_main);
    }
}
