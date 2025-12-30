package org.example.viewer.game.element;

import org.example.gui.GUI;
import org.example.model.game.element.Potion;
import org.example.viewer.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PotionViewerTest {
    private PotionViewer viewer;
    private GUI guiMock;
    private Potion potionMock;
    private Image imageMock;

    @BeforeEach
    void setUp() {
        viewer = new PotionViewer();
        guiMock = mock(GUI.class);
        potionMock = mock(Potion.class);
        imageMock = mock(Image.class);
    }

    @Test
    void testDrawDoorOpened() {
        when(potionMock.getImage()).thenReturn(imageMock);
        viewer.draw(potionMock, guiMock);
        verify(potionMock, times(1)).getImage();
        verify(guiMock, times(1)).drawImage(imageMock);
    }
}
