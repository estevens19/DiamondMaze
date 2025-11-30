package org.example.model.game.element;

import com.googlecode.lanterna.graphics.TextGraphics;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Countdown {
    private Timer timer;
    private int seconds;
    Countdown(int seconds) {
        this.seconds = seconds;
    }

    public void start() {
        timer = new Timer(1000,  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                System.out.println("Timer: " + seconds/60 +":"+ seconds%60);

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
/*
    public void draw(TextGraphics graphics) {
        System.out.println("Timer: " + seconds/60 +":"+ seconds%60);
        graphics.putString(150,100,seconds/60 + ":" + seconds%60);
    }
    */
}


