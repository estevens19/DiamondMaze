package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

public class Game {
    private Screen screen;
    private Maze maze;

    public Game() {
        try {
            SwingTerminalFrame terminal = new SwingTerminalFrame();

            Font font = new Font("Fira Code", Font.PLAIN, 18);
            terminal.setTerminalFont(font);

            terminal.setVisible(true);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            maze = new Maze(40, 20);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException, FontFormatException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(40, 20));

        Terminal terminal = factory.createTerminal();
        ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        screen.setCharacter(10, 10, TextCharacter.fromCharacter('C')[0]);
        screen.refresh();
    }
}