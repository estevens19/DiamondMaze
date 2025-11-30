package org.example;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import org.example.gui.LanternaGUI;
import org.example.model.menu.MenuMain;
import org.example.state.MenuMainState;
import org.example.state.State;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        // CORREÇÃO CRUCIAL: Aumentar a resolução para 1300x750 para caber o mapa e o título
        this.gui = new LanternaGUI(1300, 750);
        this.state = new MenuMainState(new MenuMain());
    }

    public void setState(State state) {
        this.state = state;
    }

    public void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);
            gui.refresh();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}