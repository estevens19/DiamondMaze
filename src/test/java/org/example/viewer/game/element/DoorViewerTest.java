package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Door;
import org.example.viewer.Image;
import org.example.viewer.game.element.DoorViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DoorViewerTest {
    private DoorViewer viewer;
    private GUI guiMock;
    private Door doorMock;
    private Image doorClosedMock;
    private Image doorOpenedMock;

    @BeforeEach
    void setUp() {
        viewer = new DoorViewer();
        guiMock = mock(GUI.class);
        doorMock = mock(Door.class);
        doorClosedMock = mock(Image.class);
        doorOpenedMock = mock(Image.class);
    }

    @Test
    void testDrawDoorOpened() {
        when(doorMock.isOpen()).thenReturn(true);
        when(doorMock.getImage2()).thenReturn(doorOpenedMock);
        viewer.draw(doorMock, guiMock);
        verify(doorMock, times(1)).getImage2();
        verify(guiMock, times(1)).drawImage(doorOpenedMock);
        verify(guiMock, never()).drawImage(doorClosedMock);
    }

    @Test
    void testDrawDoorClosed() {
        when(doorMock.isOpen()).thenReturn(false);
        when(doorMock.getImage()).thenReturn(doorClosedMock);
        viewer.draw(doorMock, guiMock);
        verify(doorMock, times(1)).getImage();
        verify(guiMock, times(1)).drawImage(doorClosedMock);
        verify(guiMock, never()).drawImage(doorOpenedMock);
    }
}
