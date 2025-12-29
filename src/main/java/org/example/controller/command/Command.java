package org.example.controller.command;

import org.example.controller.game.character.KnightController;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface Command {
    void execute(KnightController controller) throws IOException, URISyntaxException, FontFormatException;
}
