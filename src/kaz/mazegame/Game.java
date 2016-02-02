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
        adv = new Adventurer(maze.getAdvStart());
    }

    public Adventurer getAdventurer() {
        return adv;
    }

    public Maze getMaze() {
        return maze;
    }

    public boolean move(DIRECTION d) {
        //if the direction is not a wall then move the adv there
//        System.out.print("Moving " + d + " onto ");
//        System.out.println(maze.getBlock(adv.getR() + d.getUnitMove().getR(), adv.getC() + d.getUnitMove().getC()));
        boolean complete = false;
        if (maze.getBlock(adv.getR() + d.getUnitMove().getR(), adv.getC() + d.getUnitMove().getC()) != BLOCK.WALL) {
            adv.move(d.getUnitMove());
            complete = true;
        }

        //if the player has walked into the air make them die
        if (maze.getBlock(adv.getR(), adv.getC()) == BLOCK.AIR)
            die(adv.getR(), adv.getC());

        return complete;
    }

    private void die() {
        adv.set(maze.getAdvStart());
    }

    private void die(int row, int col) {
        // TODO: handle tombstones or something i dunno
        die();
    }

}
