package org.example.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import org.example.model.Position;
import org.example.model.menu.Menu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    public static Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration cfg = loadFont();
        Terminal terminal = createTerminal(width, height, cfg);
        this.screen = createScreen(terminal);

        ((AWTTerminalFrame)terminal).setExtendedState(Frame.MAXIMIZED_BOTH);
        ((AWTTerminalFrame)terminal).setTitle("Diamond Maze");
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration cfg) throws IOException {
        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setTerminalEmulatorFontConfiguration(cfg);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(width, height)); // (320, 280)

        Terminal terminal = factory.createTerminal();

        return terminal;
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/charybdis.regular.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font newfont = font.deriveFont(Font.PLAIN, 3);
        AWTTerminalFontConfiguration cfg = AWTTerminalFontConfiguration.newInstance(newfont);

        return cfg;
    }

    public ACTION getKey() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key == null) return ACTION.NONE;

        if (key.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') return ACTION.QUIT;

        if (key.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (key.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (key.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (key.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawKnight(Position position) {

    }

    @Override
    public void drawGuard(Position position) {

    }

    /*
        @Override
        public void drawWall(Position position) {
            drawCharacter(position.getX(), position.getY(), '#', "#3333FF");
        }
        @Override
        public void drawText(Position position, String text, String color) {
            TextGraphics graphics = screen.newTextGraphics();
            graphics.setForegroundColor(TextColor.Factory.fromString(color));
            graphics.putString(position.getX(), position.getY(), text);
        }
    */
    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}