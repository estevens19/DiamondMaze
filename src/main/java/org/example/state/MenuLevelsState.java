package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.MenuLevelsController;
import org.example.model.menu.MenuLevels;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MenuLevelsViewer;

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
