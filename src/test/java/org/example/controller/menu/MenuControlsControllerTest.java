package org.example.controller.menu;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.menu.MenuControls;
import org.example.state.MenuMainState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MenuControlsControllerTest {
    private MenuControlsController controller;
    private MenuControls menuMock;
    private Game gameMock;

    @BeforeEach
    public void setUp() {
        menuMock = mock(MenuControls.class);
        gameMock = mock(Game.class);
        controller = new MenuControlsController(menuMock);
    }

    @Test
    public void testSelectBack() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getScreenWidth()).thenReturn(640);
        when(menuMock.getScreenHeight()).thenReturn(360);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuMainState.class));
    }
}
