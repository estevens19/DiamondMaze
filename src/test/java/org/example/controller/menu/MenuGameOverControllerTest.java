package org.example.controller.menu;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.menu.MenuGameOver;
import org.example.state.GameState;
import org.example.state.MenuMainState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MenuGameOverControllerTest {
    private MenuGameOverController controller;
    private MenuGameOver menuMock;
    private Game gameMock;

    @BeforeEach
    public void setUp() {
        menuMock = mock(MenuGameOver.class);
        gameMock = mock(Game.class);
        controller = new MenuGameOverController(menuMock);
    }

    @Test
    public void testMoveLeft() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(2);
        controller.step(gameMock, GUI.ACTION.LEFT, 100);
        verify(menuMock, Mockito.times(1)).backCurrButton();
    }

    @Test
    public void testMoveRight() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(1);
        controller.step(gameMock, GUI.ACTION.RIGHT, 100);
        verify(menuMock, Mockito.times(1)).nextCurrButton();
    }

    @Test
    public void testSelectRestart() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(1);
        when(menuMock.getCurLevel()).thenReturn(2);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void testSelectMenu() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(2);
        when(menuMock.getScreenWidth()).thenReturn(640);
        when(menuMock.getScreenHeight()).thenReturn(360);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuMainState.class));
    }
}
