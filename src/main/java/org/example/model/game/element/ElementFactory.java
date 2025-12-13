package org.example.model.game.element;

import org.example.model.Position;

import java.io.IOException;

public interface ElementFactory {
    Wall createWall(Position position) throws IOException;
    Diamond createDiamond(Position position) throws IOException;
    Key createKey(Position position) throws IOException;
    Door createDoor(Position position) throws IOException;
}