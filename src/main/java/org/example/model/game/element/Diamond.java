package org.example.model.game.element;

import org.example.model.Position;
import org.example.viewer.Image;

import java.io.IOException;

public class Diamond extends Element {
    private boolean isKey = false;
    public Diamond(int x, int y) throws IOException {
        super(new Image(new Position(x,y), "images/Diamond.png").resizeImage(75,25));
    }

    public void setKey(){
        isKey = true;
    }
    public boolean isKey(){
        return isKey;
    }

    /*
    public void addScore(Score score){
        score += ;
    }
    */

}
