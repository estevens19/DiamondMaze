package org.example.gui;

import org.example.model.Position;
import org.example.viewer.Image;
import java.io.IOException;

public interface GUI {
    ACTION getKey() throws IOException;

    void drawImage(Image image);

    void drawText(Position position, String text);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}