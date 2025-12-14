package org.example.model.game.character;

import org.example.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class LevelCharacterFactory implements CharacterFactory {
    @Override
    public Knight createKnight(Position position) throws IOException, URISyntaxException, FontFormatException {
        return new Knight(position.getX(), position.getY());
    }

    @Override
    public Guard createGuard(Position position) throws IOException, URISyntaxException, FontFormatException {
        return new Guard(position.getX(), position.getY());
    }
}