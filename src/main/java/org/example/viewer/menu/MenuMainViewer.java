package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.MenuMain;
import org.example.viewer.Viewer;

public class MenuMainViewer extends Viewer<MenuMain> {
    public MenuMainViewer(MenuMain menu) {
        super(menu);
    }

    @Override
    public void draw(GUI gui) {
        gui.clear();

        // Desenha o fundo
        gui.drawImage(getModel().getBackground());

        // Desenha os elementos do menu
        if (getModel().getTitle() != null) gui.drawImage(getModel().getTitle());
        if (getModel().getStart() != null) gui.drawImage(getModel().getStart());
        if (getModel().getControls() != null) gui.drawImage(getModel().getControls());
        if (getModel().getExit() != null) gui.drawImage(getModel().getExit());
    }
}