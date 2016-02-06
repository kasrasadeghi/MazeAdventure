package kaz.mazegame.Monsters;

import kaz.mazegame.Actor;
import kaz.mazegame.DIRECTION;
import kaz.mazegame.Loc;
import kaz.mazegame.Maze;

/**
 * Created by KASRA on 2/2/2016.
 */
public class Monster extends Actor {

    public Monster(Loc l, Maze m) {
        super(l, m);
    }

    public void eat() {

    }

    public void die() {

    }

    public void burn() {

    }

    public void move() {
        super.move(DIRECTION.getRandom());
    }
}
