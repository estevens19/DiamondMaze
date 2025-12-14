package org.example.viewer;

import org.example.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void draw(GUI gui) throws IOException, URISyntaxException, FontFormatException;
}
