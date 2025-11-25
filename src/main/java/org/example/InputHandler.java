package org.example;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface InputHandler {
    void getKey(KeyStroke key) throws IOException;
}