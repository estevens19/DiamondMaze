package org.example.controller.game;

import org.example.Game;
import org.example.gui.GUI;
import org.example.model.game.maze.Countdown;
import org.example.model.game.maze.Maze;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MazeControllerStateTest {
    @Test
    void testGameOverWhenCountdownZero() throws Exception {
        Maze mazeMock = mock(Maze.class);
        Game gameMock = mock(Game.class);
        Countdown countdownMock = mock(Countdown.class);

        when(mazeMock.getCountdown()).thenReturn(countdownMock);
        when(countdownMock.getTime()).thenReturn(0);

        MazeController controller = new MazeController(mazeMock);

        controller.step(gameMock, GUI.ACTION.NONE, 100);

        verify(gameMock, times(1)).onMenuGameOver();
    }
}
