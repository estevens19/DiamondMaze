package org.example.model.game.character;

import org.example.model.Position;

import java.io.IOException;

public class LevelCharacterFactory implements CharacterFactory {
    @Override
    public Knight createKnight(Position position) throws IOException {
        return new Knight(position.getX(), position.getY());
    }

    @Override
    public Guard createGuard(Position position) throws IOException {
        return new Guard(position.getX(), position.getY());
    }
}