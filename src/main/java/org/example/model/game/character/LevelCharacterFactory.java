package org.example.model.game.character;

import org.example.model.Position;

import java.io.IOException;

public class Level1CharacterFactory implements CharacterFactory {
    public Knight createKnight(Position position) throws IOException {
        return new Knight(position.getX(), position.getY());
    }

    public Guard createGuard(Position position) throws IOException {
        return new Guard(position.getX(), position.getY());
    }
}