package org.example.controller.game;
import java.io.IOException;


public class MazeController {



    public class ArenaController extends GameController {
        private final KnightController knightController;
        private final GuardController guardController;

        public ArenaController(Maze maze) {
            super(maze);

            this.knightController = new KnightController(maze);
            this.guardController = new GuardController(maze);
        }

        public void step(Game game, GUI.ACTION action, long time) throws IOException {
            if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0)
                game.setState(new MenuState(new Menu()));
            else {
                knightController.step(game, action, time);
                guardController.step(game, action, time);
            }
        }
    }



}
