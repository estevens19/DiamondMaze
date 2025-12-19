package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.MenuPassedController;
import org.example.model.menu.MenuPassed;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MenuPassedViewer;

public class MenuPassedState extends State<MenuPassed> {
    public MenuPassedState(MenuPassed model) {
        super(model);
    }

    @Override
    protected Viewer<MenuPassed> getViewer() {
        return new MenuPassedViewer(getModel());
    }

    @Override
    protected Controller<MenuPassed> getController() {
        return new MenuPassedController(getModel());
    }
}
