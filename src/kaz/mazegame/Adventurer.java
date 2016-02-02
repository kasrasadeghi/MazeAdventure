package kaz.mazegame;

/**
 * Created by kasra on 2/2/2016.
 */
public class Adventurer extends Actor {
    private DIRECTION direction;

    public Adventurer(int x, int y) {
        super(x, y);
        direction = DIRECTION.UP;
    }

    public Adventurer(Loc l) {
        super(l.getR(), l.getC());
        direction = DIRECTION.UP;
    }
}
