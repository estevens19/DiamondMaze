package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public abstract class Menu {
    private Image background;

    public Menu() throws IOException {
        background = new Image(new Position(0, 0), "images_menu/Main_Menu.png");
        // O resize inicial é feito aqui, mas precisamos de permitir atualizações futuras
        background = background.resizeImage(320, 280);
    }

    public Image getBackground() {
        return background;
    }

    // ADICIONADO: Permitir que o background seja atualizado (ex: resize)
    protected void setBackground(Image background) {
        this.background = background;
    }
}