package org.example.model.game.character;

import org.example.model.Position;

import java.io.IOException;

public interface CharacterFactory {
    Knight createKnight(Position position) throws IOException;
    Guard createGuard(Position position) throws IOException;
}