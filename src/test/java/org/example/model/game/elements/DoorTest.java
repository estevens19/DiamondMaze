package org.example.model.game.elements;

import org.example.model.game.element.Door;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class DoorTest {
    private Door door;

    @BeforeEach
    void setup() throws IOException, URISyntaxException, FontFormatException {
        door = new Door(10,10);
    }

    @Test
    void openFalseByDefault(){
        assertFalse(door.isOpen());
    }

    @Test
    void setOpen(){
        door.openDoor(true);
        assertTrue(door.isOpen());
        door.openDoor(false);
        assertFalse(door.isOpen());
    }

}
