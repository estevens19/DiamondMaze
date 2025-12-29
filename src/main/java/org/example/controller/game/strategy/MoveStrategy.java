package org.example.controller.game.strategy;

import org.example.model.Position;
import org.example.model.game.character.Guard;
import org.example.model.game.maze.Maze;

public interface MoveStrategy {
    Position getNextMove(Guard guard, Maze maze);
}
