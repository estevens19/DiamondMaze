package org.example.model.game.maze;

import org.example.model.game.element.Diamond;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MazeParser {
    private char[][] savedCharacters;
    private File level1;
    //private File level2;
    //private File level3;

    public MazeParser() {
        level1 = new File("level1.txt");
    }

    public void renderLevel1() throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(level1))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        int line_len = lines.get(0).length();
        savedCharacters = new char[lines.size()][line_len];

        for (int i = 0; i < lines.size(); i++) {
            savedCharacters[i] = lines.get(i).toCharArray();
        }
    }
}