package org.example.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuLevelsTest {
    private MenuLevels menuLevels;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menuLevels = new MenuLevels();
    }

    @Test
    void testInitialState() {
        assertEquals(1, menuLevels.getCurrButton());
    }

    @Test
    void testNavigation() throws IOException, URISyntaxException, FontFormatException {
        menuLevels.nextCurrButton();
        assertEquals(2, menuLevels.getCurrButton());

        menuLevels.backCurrButton();
        assertEquals(1, menuLevels.getCurrButton());
    }

    @Test
    void testBackButton() throws IOException, URISyntaxException, FontFormatException {
        menuLevels.backButton();
        assertEquals(0, menuLevels.getCurrButton());
    }
}
