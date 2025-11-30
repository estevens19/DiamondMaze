package org.example.model.game.element;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Position;

import java.io.IOException;

public class Diamond extends Element {
    private boolean isKey = false;
    public Diamond(Position position) throws IOException {
        super(new Image(position, "images/Diamond.png").resizeImage(75,25));
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
