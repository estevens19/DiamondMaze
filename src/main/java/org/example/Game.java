package org.example;

import java.awt.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

public class Game {
    public static Screen screen;
    public static boolean running = true;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("fonts/charybdis.regular.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font newfont = font.deriveFont(Font.PLAIN, 3);

        AWTTerminalFontConfiguration cfg = AWTTerminalFontConfiguration.newInstance(newfont);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setTerminalEmulatorFontConfiguration(cfg);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(100, 50));

        Terminal terminal = factory.createTerminal();

        ((AWTTerminalFrame)terminal).setExtendedState(Frame.MAXIMIZED_BOTH);
        ((AWTTerminalFrame) terminal).setTitle("Diamond Maze");

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

        while (true) {
            TerminalSize newSize = screen.doResizeIfNecessary();
            menu.draw(graphics);

            if (newSize != null) {
                menu.updateSize(newSize.getColumns(), newSize.getRows());
                screen.clear();
            }

            KeyStroke key = screen.pollInput();
            if (key != null) {
                menu.getKey(key);
            }

            if (!running)
                break;

            if (key.getCharacter() == 'q') {
                screen.stopScreen();
                break;
            }

            screen.refresh();
        }
    }
}