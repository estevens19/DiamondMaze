package org.example.controller.game.character;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.character.Knight;
import org.example.model.game.maze.Maze;
import org.example.viewer.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

class KnightControllerTest {
    private KnightController controller;
    private Maze mazeMock;
    private Game gameMock;
    private Knight knightMock;

    @BeforeEach
    void setUp() {
        mazeMock = mock(Maze.class);
        gameMock = mock(Game.class);
        knightMock = mock(Knight.class);

        when(mazeMock.getKnight()).thenReturn(knightMock);
        when(mazeMock.getKnightSpeed()).thenReturn(5);
        when(knightMock.getPosition_currentImage()).thenReturn(new Position(10, 10));
        when(knightMock.getImageLeft()).thenReturn(mock(Image.class));
        when(knightMock.getImageRight()).thenReturn(mock(Image.class));
        when(knightMock.getCurrentImage()).thenReturn(mock(Image.class));
        when(knightMock.getCurrentImage().getPosition()).thenReturn(new Position(10, 10));

        controller = new KnightController(mazeMock);
    }

    @Test
    void testKnightMovesRight() throws Exception {
        when(mazeMock.isWallKnight(any(Position.class))).thenReturn(false);
        controller.step(gameMock, GUI.ACTION.RIGHT, 100);
        verify(knightMock, atLeastOnce()).move(any(Position.class));
        verify(knightMock, atLeastOnce()).setCurrentImage(any());
    }
}
