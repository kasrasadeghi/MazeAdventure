package kaz.mazegame;

/**
 * Created by kasra on 2/1/2016.
 */
public class Entity extends Loc {
    //all things
    //people, projectiles, enemies, drops, doors
    private Maze maze;

    public Entity(int x, int y, Maze maze) {
        super(x, y);
        this.maze = maze;
    }
    public Entity(Loc l, Maze m) {
        super(l.getR(), l.getC());
        this.maze = m;
    }

    public Maze getMaze() {
        return maze;
    }

    public BLOCK getBlock() {
        return maze.getBlock(getR(), getC());
    }
}
