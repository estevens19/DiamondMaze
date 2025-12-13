package org.example.model.game.characters;

import org.example.model.Position;

public interface CharacterFactory {
    Knight createKnight(Position position);
    Guard createGuard(Position position);
}
