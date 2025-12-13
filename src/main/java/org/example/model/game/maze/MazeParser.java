package org.example.model.game.maze;

import org.example.model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MazeParser {
    private final char[][] maze;

    public MazeParser(String filePath) throws IOException {
        this.maze = load(filePath);
    }

    private char[][] load(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filePath))))
        {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        int height = lines.size();
        int width = lines.get(0).length();

        char[][] result = new char[height][width];
        for (int y = 0; y < height; y++) {
            result[y] = lines.get(y).toCharArray();
        }

        return result;
    }

    public Position find(char symbol) {
        for (int y = 0; y < maze.length; y++)
            for (int x = 0; x < maze[y].length; x++)
                if (maze[y][x] == symbol)
                    return new Position(x, y);

        return null;
    }

    public <T> List<T> findAll(char symbol, Function<Position, T> creator) {
        List<T> lst = new ArrayList<>();

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                if (maze[y][x] == symbol) {
                    lst.add(creator.apply(new Position(x*50, y*20 + 25)));
                }
            }
        }
        return lst;
    }
}