package org.example.state;

import org.example.controller.menu.MenuMainController;
import org.example.controller.Controller;
import org.example.model.menu.MenuMain;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MenuMainViewer;

public class MenuMainState extends State<MenuMain> {
    public MenuMainState(MenuMain model) {
        super(model);
    }

    @Override
    protected Viewer<MenuMain> getViewer() {
        return new MenuMainViewer(getModel());
    }

    @Override
    protected Controller<MenuMain> getController() {
        return new MenuMainController(getModel());
    }
}
