package org.example;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import org.example.gui.LanternaGUI;
import org.example.model.menu.MenuMain;
import org.example.state.MenuMainState;
import org.example.state.State;

/*
public class Game {
    public static Screen screen;
    public static boolean running = true;


    public Game() throws IOException, URISyntaxException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("fonts/charybdis.regular.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font newfont = font.deriveFont(Font.PLAIN, 3);

        AWTTerminalFontConfiguration cfg = AWTTerminalFontConfiguration.newInstance(newfont);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setTerminalEmulatorFontConfiguration(cfg);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(320, 280));

        Terminal terminal = factory.createTerminal();

        ((AWTTerminalFrame)terminal).setExtendedState(Frame.MAXIMIZED_BOTH);
        ((AWTTerminalFrame)terminal).setTitle("Diamond Maze");

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    public void run() throws IOException {
        Menu menu = new Menu();
        TextGraphics graphics = screen.newTextGraphics();
        TerminalSize initialSize = screen.getTerminalSize();
        menu.updateSize(initialSize.getColumns(), initialSize.getRows());

        while (running) {
            TerminalSize newSize = screen.doResizeIfNecessary();
            if (newSize != null) {
                menu.updateSize(newSize.getColumns(), newSize.getRows());
                screen.clear();
            }

            menu.draw(graphics);
            screen.refresh();

            KeyStroke key = screen.pollInput();
            if (key != null) {
                menu.getKey(key);

                if (key.getCharacter() != null && key.getCharacter() == 'q') {
                    running = false;
                }
            }

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        screen.stopScreen();
    }
}

 */

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(320, 280);
        this.state = new MenuMainState(new MenuMain());
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

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
