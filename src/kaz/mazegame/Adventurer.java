package kaz.mazegame;

/**
 * Created by kasra on 2/2/2016.
 */
public class Adventurer extends Actor {
    private DIRECTION direction;

    public Adventurer(Maze maze) {
        super(maze.getAdvStart(), maze);
        direction = DIRECTION.UP;
    }

    public Adventurer(Loc l, Maze maze) {
        super(l.getR(), l.getC(), maze);
        direction = DIRECTION.UP;
    }
}
