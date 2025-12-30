package org.example.controller.command;

import org.example.controller.game.character.KnightController;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MoveUpCommandTest {
    @Test
    public void testExecute() {
        MoveUpCommand command = new MoveUpCommand();
        KnightController controllerMock = mock(KnightController.class);

        command.execute(controllerMock);

        verify(controllerMock, times(1)).moveKnightUp();
    }
}
