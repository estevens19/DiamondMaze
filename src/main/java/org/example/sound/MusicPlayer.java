package org.example.sound;

import javax.sound.sampled.Clip;

public interface MusicPlayer {
    void start();
    void stop();

    void setSound(Clip sound);
    Clip getSound();
}
