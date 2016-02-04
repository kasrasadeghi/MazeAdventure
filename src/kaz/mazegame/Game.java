package kaz.mazegame;

import java.util.ArrayList;

/**
 * Created by kasra on 2/2/2016.
 */
public class Game {
    private Maze maze;
    private Adventurer adv;
    private ArrayList<Actor> actors;

    public Game(String mazeFileName) {
        maze = new Maze(mazeFileName);
        adv = new Adventurer(maze);
    }

    public Adventurer getAdventurer() {
        return adv;
    }

    public Maze getMaze() {
        return maze;
    }


}
