package org.example.model.game.maze;

import org.example.model.Position;
import org.example.viewer.Image;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Countdown {
    private Timer timer;
    private int seconds;
    private Position position;
    public Countdown(int seconds) {
        this.seconds = seconds;
        this.position = new Position(10,20);
    }

    public void start() {
        timer = new Timer(1000,  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;

                if (seconds <= 0) {
                    timer.stop();
                    //FALTA DAR O GAME OVER
                }
            }
        });
        timer.start();
    }
    public void addTime(int time) {
        seconds += time;
    }

    public Position getPosition() {
        return position;
    }

    public int getTime(){
        return seconds;
    }

    public String timeString(){
        if (seconds%60 <10) return "Timer: " + seconds/60 +":0"+ seconds%60;;
        return "Timer: " + seconds/60 +":"+ seconds%60;
    }

    public Image timeImage() throws IOException, URISyntaxException, FontFormatException {
        return Image.createTextImage(position,timeString(),50).resizeImage(150,20);
    }
}


