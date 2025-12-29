package org.example.viewer.game.character;

import org.example.gui.GUI;
import org.example.model.game.character.Knight;
import org.example.viewer.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class KnightViewerTest {
    private KnightViewer viewer;
    private GUI guiMock;
    private Knight knightMock;
    private Image imageMock;

    @BeforeEach
    void setUp() {
        viewer = new KnightViewer();
        guiMock = mock(GUI.class);
        knightMock = mock(Knight.class);
        imageMock = mock(Image.class);
    }

    @Test
    void testDrawAndDrawImage() {
        when(knightMock.getCurrentImage()).thenReturn(imageMock);
        viewer.draw(knightMock, guiMock);
        verify(knightMock, times(1)).getCurrentImage();
        verify(guiMock, times(1)).drawImage(imageMock);
    }
}