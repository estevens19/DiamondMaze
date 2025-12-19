package org.example;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        System.setProperty("sun.java2d.uiScale", "1.0");
        Game game = new Game();
        game.start();
    }
}