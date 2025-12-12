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
        this.gui = new LanternaGUI(1850, 340);
        this.state = new MenuMainState(new MenuMain());

        if (state instanceof MenuMainState) {
            MenuMainState menuState = (MenuMainState) state;
            menuState.getModel().updateSize(gui.getScreenWidth(), gui.getScreenHeight());
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void start() throws IOException {
        int FPS = 30;
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

            gui.updateScreenSize();
        }

        gui.close();
    }
}