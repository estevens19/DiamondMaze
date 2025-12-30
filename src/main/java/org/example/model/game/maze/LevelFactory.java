package org.example.model.game.maze;

import org.example.model.game.character.CharacterFactory;
import org.example.model.game.character.LevelCharacterFactory;
import org.example.model.game.element.ElementFactory;
import org.example.model.game.element.LevelElementFactory;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class LevelFactory {
    private final ElementFactory elementFactory;
    private final CharacterFactory characterFactory;

    public LevelFactory() throws IOException, URISyntaxException, FontFormatException {
        this.elementFactory = new LevelElementFactory();
        this.characterFactory = new LevelCharacterFactory();
    }

    public ElementFactory elements() { return elementFactory; }
    public CharacterFactory characters() { return characterFactory; }
}