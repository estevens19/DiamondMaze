package org.example.gui;

import org.example.viewer.Image;
import java.io.IOException;

public interface GUI {
    ACTION getKey() throws IOException;

    void drawImage(Image image);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}