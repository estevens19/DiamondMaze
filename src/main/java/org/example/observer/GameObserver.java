package org.example.observer;

import org.example.model.game.maze.Score;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface GameObserver {
    void onMenuGameOver() throws IOException, URISyntaxException, FontFormatException;
    void onMenuPassed(int currentLevel, Score score) throws IOException, URISyntaxException, FontFormatException;
}