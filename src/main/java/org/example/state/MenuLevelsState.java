package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.MenuLevelsController;
import org.example.controller.menu.MenuMainController;
import org.example.model.menu.Menu;
import org.example.model.menu.MenuLevels;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MenuLevelsViewer;
import org.example.viewer.menu.MenuMainViewer;

public class MenuLevelsState extends State<MenuLevels> {
    public MenuLevelsState(MenuLevels model) {
        super(model);
    }

    @Override
    protected Viewer<MenuLevels> getViewer() {
        return new MenuLevelsViewer(getModel());
    }

    @Override
    protected Controller<MenuLevels> getController() {
        return new MenuLevelsController(getModel());
    }
}
