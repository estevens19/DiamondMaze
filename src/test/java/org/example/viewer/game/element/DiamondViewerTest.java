package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Diamond;
import org.example.viewer.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DiamondViewerTest {
    private DiamondViewer viewer;
    private GUI guiMock;
    private Diamond diamondMock;
    private Image imageMock;

    @BeforeEach
    void setUp() {
        viewer = new DiamondViewer();
        guiMock = mock(GUI.class);
        diamondMock = mock(Diamond.class);
        imageMock = mock(Image.class);
    }

    @Test
    void testDrawDoorOpened() {
        when(diamondMock.getImage()).thenReturn(imageMock);
        viewer.draw(diamondMock, guiMock);
        verify(diamondMock, times(1)).getImage();
        verify(guiMock, times(1)).drawImage(imageMock);
    }
}
