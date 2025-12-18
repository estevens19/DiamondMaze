package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

public class Potion extends Element {
    int effect;

    public Potion(int x, int y) throws IOException, URISyntaxException, FontFormatException {
        super(new Image(new Position(x,y), "images/Potion.png").resizeImage(20,20));
        Random rand = new Random();
        effect = rand.nextInt(4);
    }

    public int getEffect() {
        return effect;
    }
}