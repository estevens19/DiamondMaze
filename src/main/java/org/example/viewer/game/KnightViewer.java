package org.example.viewer.game;

import org.example.model.game.characters.Knight;
import org.example.gui.GUI;

public class KnightViewer implements CharacterViewer<Knight> {
    @Override
    public void draw(Knight knight, GUI gui) {
        // Agora passamos a imagem completa, não apenas a posição
        gui.drawImage(knight.getImage());
    }
}