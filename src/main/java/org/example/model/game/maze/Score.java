package org.example.model.game.maze;

import org.example.model.Position;
import org.example.viewer.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Score {
    private int points;
    private Position position;

    public Score() {
        this.points = 0;
        this.position = new Position(400,20);
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public Position getPosition() {
        return position;
    }

    public int getPoints(){
        return points;
    }

    public String scoreString(){
        return "Score: " + points;
    }

    public Image scoreImage() throws IOException, URISyntaxException, FontFormatException {
        return Image.createTextImage(position,scoreString(),50).resizeImage(150,20);
    }

}
