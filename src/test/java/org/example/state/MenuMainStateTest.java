package org.example.state;

import org.example.controller.menu.MenuMainController;
import org.example.model.menu.MenuMain;
import org.example.viewer.menu.MenuMainViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuMainStateTest {
    private MenuMainState state;
    private MenuMain menuMain;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menuMain = new MenuMain();
        state = new MenuMainState(menuMain);
    }

    @Test
    void testGetController() {
        assertTrue(state.getController() instanceof MenuMainController);
    }

    @Test
    void testGetViewer() {
        assertTrue(state.getViewer() instanceof MenuMainViewer);
    }
}
