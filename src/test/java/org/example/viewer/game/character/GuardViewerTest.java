package org.example.viewer.game.character;

import org.example.gui.GUI;
import org.example.model.game.character.Guard;
import org.example.viewer.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GuardViewerTest {
    private GuardViewer viewer;
    private GUI guiMock;
    private Guard guardMock;
    private Image imageMock;

    @BeforeEach
    void setUp() {
        viewer = new GuardViewer();
        guiMock = mock(GUI.class);
        guardMock = mock(Guard.class);
        imageMock = mock(Image.class);
    }

    @Test
    void testDrawAndDrawImage() {
        when(guardMock.getCurrentImage()).thenReturn(imageMock);
        viewer.draw(guardMock, guiMock);
        verify(guardMock, times(1)).getCurrentImage();
        verify(guiMock, times(1)).drawImage(imageMock);
    }
}