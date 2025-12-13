package org.example.model.game.maze;

import org.example.model.game.character.CharacterFactory;
import org.example.model.game.character.LevelCharacterFactory;
import org.example.model.game.element.ElementFactory;
import org.example.model.game.element.Level1ElementFactory;

public class Level1Factory {
    private final ElementFactory elementFactory;
    private final CharacterFactory characterFactory;

    public Level1Factory() {
        this.elementFactory = new Level1ElementFactory();
        this.characterFactory = new LevelCharacterFactory();
    }

    public ElementFactory elements() {
        return elementFactory;
    }

    public CharacterFactory characters() {
        return characterFactory;
    }
}