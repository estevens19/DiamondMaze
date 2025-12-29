package org.example.controller.command;

import org.example.controller.game.character.KnightController;

public class MoveLeftCommand implements Command {
    @Override
    public void execute(KnightController controller) {
        controller.moveKnightLeft();
    }
}
