package org.example.controller.command;

import org.example.controller.game.character.KnightController;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MoveDownCommandTest {
    @Test
    public void testExecute() {
        MoveDownCommand command = new MoveDownCommand();
        KnightController controllerMock = mock(KnightController.class);

        command.execute(controllerMock);

        verify(controllerMock, times(1)).moveKnightDown();
    }
}
