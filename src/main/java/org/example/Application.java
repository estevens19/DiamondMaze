package org.example;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        Game game = new Game();
        game.run();
    }
}