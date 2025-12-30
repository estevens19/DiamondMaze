package org.example.controller.menu;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.menu.MenuLevels;
import org.example.state.GameState;
import org.example.state.MenuMainState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MenuLevelsControllerTest {
    private MenuLevelsController controller;
    private MenuLevels menuMock;
    private Game gameMock;

    @BeforeEach
    public void setUp() {
        menuMock = mock(MenuLevels.class);
        gameMock = mock(Game.class);
        controller = new MenuLevelsController(menuMock);
    }

    @Test
    public void testMoveUp() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(3);
        controller.step(gameMock, GUI.ACTION.UP, 100);
        verify(menuMock, Mockito.times(1)).backButton();
    }

    @Test
    public void testMoveDown() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(0);
        controller.step(gameMock, GUI.ACTION.DOWN, 100);
        verify(menuMock, Mockito.times(1)).nextCurrButton();
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
    public void testSelectLevel1() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(1);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void testSelectLevel2() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(2);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void testSelectLevel3() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(3);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void testSelectBack() throws IOException, URISyntaxException, FontFormatException {
        when(menuMock.getCurrButton()).thenReturn(0);
        when(menuMock.getScreenWidth()).thenReturn(640);
        when(menuMock.getScreenHeight()).thenReturn(360);
        controller.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuMainState.class));
    }
}
