package org.example.controller.command;

import org.example.controller.game.character.KnightController;

public class MoveDownCommand implements Command {
    @Override
    public void execute(KnightController controller) {
        controller.moveKnightDown();
    }
}
