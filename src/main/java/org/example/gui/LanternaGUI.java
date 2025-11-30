package org.example.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import org.example.viewer.Image;

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

        // CORREÇÃO: Voltamos a maximizar a janela!
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
        factory.setInitialTerminalSize(new TerminalSize(width, height));
        return factory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/charybdis.regular.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        // CORREÇÃO: Fonte tamanho 2 para caberem 1300 caracteres num monitor HD
        Font newfont = font.deriveFont(Font.PLAIN, 2);
        return AWTTerminalFontConfiguration.newInstance(newfont);
    }

    @Override
    public ACTION getKey() throws IOException {
        com.googlecode.lanterna.input.KeyStroke key = screen.pollInput();
        if (key == null) return ACTION.NONE;

        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.EOF) return ACTION.QUIT;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Character && key.getCharacter() == 'q') return ACTION.QUIT;

        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.ArrowUp) return ACTION.UP;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.ArrowRight) return ACTION.RIGHT;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.ArrowDown) return ACTION.DOWN;
        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.ArrowLeft) return ACTION.LEFT;

        if (key.getKeyType() == com.googlecode.lanterna.input.KeyType.Character && key.getCharacter() == ' ') return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawImage(Image image) {
        if (image != null) {
            image.draw(screen.newTextGraphics());
        }
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
}