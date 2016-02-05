package kaz.mazegame;

import kaz.mazegame.Monsters.Monster;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by kasra on 2/2/2016.
 */
public class Game {
    private Maze maze;
    private Adventurer adv;
    private ArrayList<Actor> actors;
    private ArrayList<Monster> monsters;

    public Game(String mazeFileName) {
        maze = new Maze(mazeFileName);
        adv = new Adventurer(maze);
        monsters = new ArrayList<>();
    }

    public Adventurer getAdventurer() {
        return adv;
    }

    public Maze getMaze() {
        return maze;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void spawnMonster() {
        ArrayList<Loc> viable = new ArrayList<>();
        for (int i = 0; i < maze.getRows(); ++i)
            for ( int j = 0; j < maze.getCols(); ++j)
                viable.add(new Loc(i, j));

        viable = viable.stream().filter(l -> maze.getBlock(l) != BLOCK.WALL)
                .filter(l -> adv.getDist(l) > 4)
                .collect(Collectors.toCollection(ArrayList::new));
        Loc l = viable.get((int) (Math.random() * viable.size()));

        monsters.add(new Monster(l, maze));
    }
}
