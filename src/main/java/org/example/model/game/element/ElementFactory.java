package org.example.model.game.element;

import org.example.model.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;

public interface ElementFactory {
    Wall createWall(Position position) throws IOException, URISyntaxException, FontFormatException;
    Diamond createDiamond(Position position) throws IOException, URISyntaxException, FontFormatException;
    Key createKey(Position position) throws IOException, URISyntaxException, FontFormatException;
    Door createDoor(Position position) throws IOException, URISyntaxException, FontFormatException;
    Potion createPotion(Position position) throws IOException, URISyntaxException, FontFormatException;
}