package org.example.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuMainTest {
    private MenuMain menuMain;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menuMain = new MenuMain();
    }

    @Test
    void testInitialState() {
     assertEquals(1, menuMain.getCurrButton());
    }

    @Test
    void testNavigation() throws IOException {
        menuMain.nextCurrButton();
        assertEquals(2, menuMain.getCurrButton());

        menuMain.nextCurrButton();
        assertEquals(3, menuMain.getCurrButton());

        menuMain.nextCurrButton();
        assertEquals(3, menuMain.getCurrButton());

        menuMain.backCurrButton();
        assertEquals(2, menuMain.getCurrButton());

        menuMain.backCurrButton();
        assertEquals(1, menuMain.getCurrButton());

        menuMain.backCurrButton();
        assertEquals(1, menuMain.getCurrButton());
    }
}
