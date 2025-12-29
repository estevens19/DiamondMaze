package org.example.model.game.maze;

import org.example.model.Position;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class MazeParser {
    private final char[][] maze;
    private final int tileWidth = 15;
    private final int tileHeight = 20;
    private final int offsetX = 15;
    private final int offsetY = 55;

    public MazeParser(String filePath) throws IOException {
        this.maze = render(filePath);
    }

    private char[][] render(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(filePath))))) {
            return br.lines()
                    .map(String::toCharArray)
                    .toArray(char[][]::new);
        }
    }

    public char[][] getMaze() {
        return maze;
    }

    public Position toPosition(int x, int y) {
        return new Position(x * tileWidth + offsetX, y * tileHeight + offsetY);
    }
}