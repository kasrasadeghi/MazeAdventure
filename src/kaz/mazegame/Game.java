package kaz.mazegame;

import java.util.ArrayList;

/**
 * Created by kasra on 2/2/2016.
 */
public class Game {
    private Maze maze;
    private Adventurer guy;
    private ArrayList<Actor> actors;

    public Game(String mazeFileName) {
        maze = new Maze(mazeFileName);
    }

    public Maze getMaze() {
        return maze;
    }
}
