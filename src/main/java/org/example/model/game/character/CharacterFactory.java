package org.example.model.game.character;

import org.example.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface CharacterFactory {
    Knight createKnight(Position position) throws IOException, URISyntaxException, FontFormatException;
    Guard createGuard(Position position) throws IOException, URISyntaxException, FontFormatException;
}