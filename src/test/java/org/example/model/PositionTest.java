package org.example.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    @Property
    public void testGetRight(@ForAll int x, @ForAll int y, @ForAll int speed) {
        Position pos = new Position(x, y);
        Position move = pos.getRight(speed);
        assertEquals(x + speed, move.getX());
        assertEquals(y, move.getY());
    }

    @Property
    public void testGetLeft(@ForAll int x, @ForAll int y, @ForAll int speed) {
        Position pos = new Position(x, y);
        Position move = pos.getLeft(speed);
        assertEquals(x - speed, move.getX());
        assertEquals(y, move.getY());
    }

    @Property
    public void testGetUp(@ForAll int x, @ForAll int y, @ForAll int speed) {
        Position pos = new Position(x, y);
        Position move = pos.getUp(speed);
        assertEquals(x, move.getX());
        assertEquals(y - speed, move.getY());
    }

    @Property
    public void testGetDown(@ForAll int x, @ForAll int y, @ForAll int speed) {
        Position pos = new Position(x, y);
        Position move = pos.getDown(speed);
        assertEquals(x, move.getX());
        assertEquals(y + speed, move.getY());
    }
}