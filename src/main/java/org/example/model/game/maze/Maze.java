package org.example.model.game.maze;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import org.example.model.game.characters.Knight;

import java.io.IOException;

public abstract class Maze {

    //public abstract void draw(TextGraphics graphics) throws IOException;

    //public abstract void updateSize(int width, int height) throws IOException;

    //public abstract boolean isExitSelected();

    //public abstract void reset();

    public abstract Knight getKnight();

    //@Override
    //public abstract void getKey(KeyStroke key) throws IOException;


}