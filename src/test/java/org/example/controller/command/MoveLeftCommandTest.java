package org.example.controller.command;

import org.example.controller.game.character.KnightController;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MoveLeftCommandTest {
    @Test
    public void testExecute() {
        MoveLeftCommand command = new MoveLeftCommand();
        KnightController controllerMock = mock(KnightController.class);

        command.execute(controllerMock);

        verify(controllerMock, times(1)).moveKnightLeft();
    }
}
