package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.MenuGameOverController;
import org.example.model.menu.MenuGameOver;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MenuGameOverViewer;

public class MenuGameOverState extends State<MenuGameOver> {
    public MenuGameOverState(MenuGameOver model) {
        super(model);
    }

    @Override
    protected Viewer<MenuGameOver> getViewer() {
        return new MenuGameOverViewer(getModel());
    }

    @Override
    protected Controller<MenuGameOver> getController() {
        return new MenuGameOverController(getModel());
    }
}
