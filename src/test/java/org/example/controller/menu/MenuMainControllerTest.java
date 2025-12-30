package org.example.controller.menu;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.menu.MenuMain;
import org.example.state.MenuLevelsState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MenuMainControllerTest {
    private MenuMainController controller;
    private MenuMain menuMock;
    private Game gameMock;

    @BeforeEach
    public void setUp() {
        menuMock = mock(MenuMain.class);
        gameMock = mock(Game.class);
        controller = new MenuMainController(menuMock);
    }

    @Test
    public void testMoveUp() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(3);
        controller.step(gameMock, GUI.ACTION.UP, 100);
        verify(menuMock, Mockito.times(1)).backCurrButton();
    }

    @Test
    public void testMoveDown() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(1);
        controller.step(gameMock, GUI.ACTION.DOWN, 100);
        verify(menuMock, Mockito.times(1)).nextCurrButton();
    }

    @Test
    public void testSelectStart() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(1);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuLevelsState.class));
    }

    @Test
    public void testSelectExit() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(3);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).exit();
    }
}
