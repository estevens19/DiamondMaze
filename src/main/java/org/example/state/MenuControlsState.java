package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.MenuControlsController;
import org.example.controller.menu.MenuLevelsController;
import org.example.model.menu.MenuControls;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MenuControlsViewer;
import org.example.viewer.menu.MenuLevelsViewer;

public class MenuControlsState extends State<MenuControls> {
    public MenuControlsState(MenuControls model) {
        super(model);
    }

    @Override
    protected Viewer<MenuControls> getViewer() {
        return new MenuControlsViewer(getModel());
    }

    @Override
    protected Controller<MenuControls> getController() {
        return new MenuControlsController(getModel());
    }
}
