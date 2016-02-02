package kaz.mazegame;

/**
 * Created by kasra on 2/1/2016.
 */
public class Entity extends Loc {
    //all things
    //people, projectiles, enemies, drops, doors
    public Entity(int x, int y) {
        super(x, y);
    }
    public Entity(Loc l) {
        super(l.getX(), l.getY());
    }
}
