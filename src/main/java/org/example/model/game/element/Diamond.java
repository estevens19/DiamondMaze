package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

public class Diamond extends Element {
    private boolean isKey = false;
    private int points;

    public Diamond(int x, int y) throws IOException, URISyntaxException, FontFormatException {
        super(new Image(new Position(x,y), "images/Diamond.png").resizeImage(25,25));
        Random rand = new Random();
        points = rand.nextInt(1,4)*1000 + rand.nextInt(10)*100;

    }

    public void setKey(){
        isKey = true;
    }
    public boolean isKey(){
        return isKey;
    }
    public int getPoints(){return points;}

}