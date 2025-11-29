package org.example.controller.game;

import org.example.Game;
import org.example.model.game.characters.Guard;
import org.example.Maze;
import org.example.model.Position;
import org.example.gui.GUI;

import java.io.IOException;

public class GuardController extends GameController {
    private long lastMovement;

    public GuardController(Maze maze) {
        super(maze);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Guard guard : getModel().getGuards())
                moveMonster(guard, guard.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }
    }

    private void moveMonster(Guard guard, Position position) {
        if (getModel().isEmpty(position)) {
            guard.setPosition(position);
            if (getModel().getKnight().getPosition().equals(position))
                getModel().getKnight().decreaseEnergy();
        }
    }
}
