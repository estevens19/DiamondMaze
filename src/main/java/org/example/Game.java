package org.example;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.example.gui.GUI;
import org.example.gui.LanternaGUI;
import org.example.model.menu.MenuMain;
import org.example.sound.MenuMusicPlayer;
import org.example.sound.MusicLoader;
import org.example.state.MenuMainState;
import org.example.state.State;

public class Game {
    private final LanternaGUI gui;
    private State<?> state;
    private MenuMusicPlayer menuMusicPlayer;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(640, 360);
        this.state = new MenuMainState(new MenuMain());

        if (state instanceof MenuMainState menuState) {
            menuState.getModel().updateSize(gui.getScreenWidth(), gui.getScreenHeight());
        }

        try {
            Clip clip = new MusicLoader().loadSound(
                    AudioSystem.getAudioInputStream(
                            Objects.requireNonNull(getClass().getClassLoader().getResource("music/soundtrack.wav"))
                    ),
                    AudioSystem.getClip()
            );
            this.menuMusicPlayer = new MenuMusicPlayer(clip);
        } catch (Exception e) {
            System.out.println("Aviso: Não foi possível carregar a música de fundo.");
            e.printStackTrace();
        }
    }

    public void setState(State<?> state) {
        this.state = state;
    }

    public void exit() {
        this.state = null;
    }

    public void step(long time) throws IOException, URISyntaxException, FontFormatException {
        if (state == null) return;

        GUI.ACTION action = gui.getKey();
        State<?> currentState = state;
        currentState.getControllerInstance().step(this, action, time);

        if (currentState == state) {
            currentState.getViewerInstance().draw(gui);
        }
    }

    public void start() throws IOException, URISyntaxException, FontFormatException {
        final int FPS = 30;
        final int frameTime = 1000 / FPS;

        if (this.menuMusicPlayer != null) {
            this.menuMusicPlayer.start();
        }

        long lastTime = System.currentTimeMillis();
        long lastResizeCheck = 0;

        while (state != null) {
            long currentTime = System.currentTimeMillis();
            long delta = currentTime - lastTime;
            lastTime = currentTime;

            step(delta);
            gui.refresh();

            if (currentTime - lastResizeCheck > 500) {
                gui.updateScreenSize();
                lastResizeCheck = currentTime;
            }

            long elapsed = System.currentTimeMillis() - currentTime;
            long sleep = frameTime - elapsed;
            if (sleep > 0) {
                try { Thread.sleep(sleep); } catch (InterruptedException ignored) {}
            }
        }

        if (this.menuMusicPlayer != null) {
            this.menuMusicPlayer.stop();
        }

        gui.close();
    }
}