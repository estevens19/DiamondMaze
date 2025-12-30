package org.example.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;

    @BeforeEach
    void setUp() {
        screen = mock(Screen.class);
        gui = new LanternaGUI(screen);
    }

    @Test
    void testGetKeyUp() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    void testGetKeyUpWithW() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke('w', false, false), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    void testGetKeyDown() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    void testGetKeyDownWithS() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke('s', false, false), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    void testGetKeyLeft() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.LEFT, action);
    }

    @Test
    void testGetKeyLeftWithA() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke('a', false, false), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.LEFT, action);
    }

    @Test
    void testGetKeyRight() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.RIGHT, action);
    }

    @Test
    void testGetKeyRightWithD() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke('d', false, false), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.RIGHT, action);
    }

    @Test
    void testGetKeyQuit() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke('q', false, false), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.QUIT, action);
    }

    @Test
    void testGetKeyQuitWithEsc() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Escape), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.QUIT, action);
    }

    @Test
    void testGetKeySelectWithSpace() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(' ', false, false), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.SELECT, action);
    }

    @Test
    void testGetKeySelectWithEnter() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter), (KeyStroke) null);

        GUI.ACTION action = gui.getKey();

        assertEquals(GUI.ACTION.SELECT, action);
    }
}
