package org.example.model.game.maze;

//import org.example.model.game.characters.Guard;
import org.example.model.game.character.Knight;

import java.io.IOException;

public class MazeLevel1 extends Maze {
    private Knight knight;
   // private List<Guard> guards;
    //private List<Wall> walls;

    public MazeLevel1() throws IOException {
        LoaderMazeBuilder load_maze1 = new LoaderMazeBuilder(1);
        knight = load_maze1.getKnight();
    }

    @Override
    public Knight getKnight() {
        return knight;
    }

    @Override
    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    //public List<Guard> getGuard() {
      //  return guards;
    //}

    //public void setGuard(List<Guard> guard) {
       // this.guards = guard;
   // }

    /*
        public List<Wall> getWalls() {
            return walls;
        }

        public void setWalls(List<Wall> walls) {
            this.walls = walls;
        }

        public boolean isEmpty(Position position) {
            for (Wall wall : walls)
                if (wall.getPosition().equals(position))
                    return false;
            return true;
        }
    */
/*
    public boolean isGuard(Position position) {
        for (Guard guard : guards)
            if (guard.getPosition_currentImage().equals(position))
                return true;
        return false;
    }

 */
}
