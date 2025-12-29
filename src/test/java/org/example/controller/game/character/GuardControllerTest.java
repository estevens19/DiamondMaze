package org.example.controller.game.character;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.maze.Maze;
import org.example.viewer.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GuardControllerTest {
    private GuardController controller;
    private Maze mazeMock;
    private Game gameMock;
    private Guard guardMock;

    @BeforeEach
    void setUp() {
        mazeMock = mock(Maze.class);
        gameMock = mock(Game.class);
        guardMock = mock(Guard.class);

        when(mazeMock.getGuards()).thenReturn(List.of(guardMock));
        when(mazeMock.getGuardInterval()).thenReturn(500L);
        when(guardMock.getPosition_currentImage()).thenReturn(new Position(10, 10));
        when(guardMock.getImageLeft()).thenReturn(mock(Image.class));
        when(guardMock.getImageRight()).thenReturn(mock(Image.class));
        when(guardMock.getCurrentImage()).thenReturn(mock(Image.class));
        when(guardMock.getCurrentImage().getPosition()).thenReturn(new Position(10, 10));

        controller = new GuardController(mazeMock);
    }

    @Test
    void testGuardMovesAfterInterval() throws Exception {
        long timeElapsed = 501;

        when(mazeMock.isWallGuard(any(Position.class))).thenReturn(false);
        when(mazeMock.isKnight(any(Position.class))).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.NONE, timeElapsed);

        verify(guardMock, atLeastOnce()).move(any(Position.class));
    }
}
