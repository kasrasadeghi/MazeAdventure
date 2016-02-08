package kaz.mazegame.Monsters;

import kaz.mazegame.Actor;
import kaz.mazegame.DIRECTION;
import kaz.mazegame.Loc;
import kaz.mazegame.Maze;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by KASRA on 2/2/2016.
 */
public class Monster extends Actor {

    public Monster(Loc l, Maze m) {
        super(l, m);
    }

    public void eat() {

    }

    public void burn() {

    }

    public void move() {
        //TODO: make monster movement less retarded
        super.move(DIRECTION.getRandom());
    }
}
