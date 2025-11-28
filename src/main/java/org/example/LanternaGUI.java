package org.example;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public interface LanternaGUI {
    void draw(TextGraphics graphics) throws IOException;
}
