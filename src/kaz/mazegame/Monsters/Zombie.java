package kaz.mazegame.Monsters;

import kaz.mazegame.BLOCK;
import kaz.mazegame.DIRECTION;
import kaz.mazegame.Loc;
import kaz.mazegame.Maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.Pack200;
import java.util.stream.Collectors;

/**
 * Created by kasra on 2/5/2016.
 */
public class Zombie extends Monster {
    Loc target;
    int counter;

    public Zombie(Loc l, Maze m) {
        super(l, m);
        targetGenerate();
        counter = 0;
    }

    public Loc getTarget() {
        return target;
    }

    public void move() {
        if (counter++%5 == 0)
            targetGenerate();
        if (same(target))
            targetGenerate();
        moveTowards(target);
    }

    public void moveTowards(Loc l) {
        //TODO: implement the A* pathfinding algorithm

    }

    public Loc targetGenerate() {
        Maze maze = getMaze();
        Loc l = new Loc((int)(Math.random() * maze.getRows()), (int) (Math.random() * maze.getCols()));
        return target = (maze.getBlock(l) == BLOCK.WALL)? targetGenerate() : l;
    }

    public Loc targetGenerate2() {
        ArrayList<Loc> viable = new ArrayList<>();
        for (int i = 0; i < getMaze().getRows(); ++i)
            for ( int j = 0; j < getMaze().getCols(); ++j) {
                Loc l = new Loc(i, j);
                if (getMaze().getBlock(l) != BLOCK.WALL)
                    viable.add(l);
            }
        return target = viable.get((int) (Math.random() * viable.size()));
    }

}
