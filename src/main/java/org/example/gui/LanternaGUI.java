package org.example.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private Screen screen;
    private TextGraphics graphics;
    private Terminal terminal;
    private int screenWidth;
    private int screenHeight;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration cfg = loadFont();
        this.terminal = createTerminal(width, height, cfg);
        this.screen = createScreen(terminal);
        this.graphics = screen.newTextGraphics();

        TerminalSize terminalSize = screen.getTerminalSize();
        this.screenWidth = terminalSize.getColumns();
        this.screenHeight = terminalSize.getRows();

        if (terminal instanceof AWTTerminalFrame) {
            AWTTerminalFrame frame = (AWTTerminalFrame) terminal;
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            frame.setTitle("Diamond Maze");
        }
    }

    public LanternaGUI(Screen screen) {
        this.screen = screen;
        this.graphics = screen.newTextGraphics();
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration cfg) throws IOException {
        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setTerminalEmulatorFontConfiguration(cfg);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(width, height));
        return factory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        Font font = getFont();

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 3);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public ACTION getKey() throws IOException {
        KeyStroke key = screen.pollInput();

        if (key == null) return ACTION.NONE;

        KeyStroke currentKey = screen.pollInput();
        while (currentKey != null) {
            key = currentKey;
            currentKey = screen.pollInput();
        }

        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.EOF) return ACTION.QUIT;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Character && key.getCharacter() == 'q') return ACTION.QUIT;

        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.ArrowUp || (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Character && key.getCharacter() == 'w')) return ACTION.UP;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.ArrowRight || (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Character && key.getCharacter() == 'd')) return ACTION.RIGHT;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.ArrowDown || (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Character && key.getCharacter() == 's')) return ACTION.DOWN;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.ArrowLeft || (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Character && key.getCharacter() == 'a')) return ACTION.LEFT;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Character && key.getCharacter() == ' ') return ACTION.SELECT;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Enter) return ACTION.SELECT;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Escape) return ACTION.QUIT;

        return ACTION.NONE;
    }

    public static Font getFont() throws IOException, FontFormatException, URISyntaxException {
        URL resource = LanternaGUI.class.getClassLoader().getResource("fonts/square.ttf");
        if (resource == null) {
            throw new IOException("Font file not found");
        }
        File fontFile = new File(resource.toURI());
        return Font.createFont(Font.TRUETYPE_FONT, fontFile);
    }

    @Override
    public void drawImage(Image image) {
        image.draw(graphics);
    }

    @Override
    public void drawText(Position position, String text) {
        graphics.putString(position.getX(), position.getY(), text);
    }

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

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void updateScreenSize() {
        TerminalSize terminalSize = screen.getTerminalSize();
        this.screenWidth = terminalSize.getColumns();
        this.screenHeight = terminalSize.getRows();
    }
}