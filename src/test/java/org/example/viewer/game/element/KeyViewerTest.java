package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Key;
import org.example.viewer.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class KeyViewerTest {
    private KeyViewer viewer;
    private GUI guiMock;
    private Key keyMock;
    private Image imageMock;

    @BeforeEach
    void setUp() {
        viewer = new KeyViewer();
        guiMock = mock(GUI.class);
        keyMock = mock(Key.class);
        imageMock = mock(Image.class);
    }

    @Test
    void testDrawDoorOpened() {
        when(keyMock.getImage()).thenReturn(imageMock);
        viewer.draw(keyMock, guiMock);
        verify(keyMock, times(1)).getImage();
        verify(guiMock, times(1)).drawImage(imageMock);
    }
}
