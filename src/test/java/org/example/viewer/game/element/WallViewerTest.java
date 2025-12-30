package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Wall;
import org.example.viewer.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class WallViewerTest {
    private WallViewer viewer;
    private GUI guiMock;
    private Wall wallMock;
    private Image imageMock;

    @BeforeEach
    void setUp() {
        viewer = new WallViewer();
        guiMock = mock(GUI.class);
        wallMock = mock(Wall.class);
        imageMock = mock(Image.class);
    }

    @Test
    void testDrawDoorOpened() {
        when(wallMock.getImage()).thenReturn(imageMock);
        viewer.draw(wallMock, guiMock);
        verify(wallMock, times(1)).getImage();
        verify(guiMock, times(1)).drawImage(imageMock);
    }
}
