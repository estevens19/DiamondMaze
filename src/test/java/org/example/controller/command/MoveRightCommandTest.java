package org.example.controller.command;

import org.example.controller.game.character.KnightController;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MoveRightCommandTest {
    @Test
    public void testExecute() {
        MoveRightCommand command = new MoveRightCommand();
        KnightController controllerMock = mock(KnightController.class);

        command.execute(controllerMock);

        verify(controllerMock, times(1)).moveKnightRight();
    }
}
