package org.example.model.game.maze;

import org.example.model.game.character.Guard;
import org.example.model.game.character.Knight;
import org.example.model.game.element.*;

import java.util.List;

public abstract class Maze {
    protected Knight knight;
    protected List<Guard> guards;
    protected List<Wall> walls;
    protected List<Diamond> diamonds;
    protected Key key;
    protected Door door;

    public Knight getKnight() {
        return knight;
    }

    public List<Guard> getGuards() {
        return guards;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Diamond> getDiamonds() {
        return diamonds;
    }

    public Key getKey() {
        return key;
    }

    public Door getDoor() {
        return door;
    }
/*
    public boolean isWall(Position position) {
        return walls.stream().anyMatch(w -> w.getPosition().equals(position));
    }

    public boolean isGuard(Position position) {
        return guards.stream().anyMatch(g -> g.getPosition().equals(position));
    }
 */
}