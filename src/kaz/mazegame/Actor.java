package kaz.mazegame;

/**
 * Created by kasra on 2/2/2016.
 */
public class Actor extends Entity {
    //people, enemies
    private DIRECTION d;
    private Loc start;

    public Actor(int x, int y, Maze m) {
        super(x, y, m);
        start = new Loc(x, y);
    }

    public Actor(Loc l, Maze m) {
        super(l, m);
        start = l;
    }

    public Loc getStart() {
        return start;
    }

    public boolean move(DIRECTION d) {
        //if the direction is not a wall then move the actor there
        boolean complete = false;
        int movedR = getR() + d.getUnitMove().getR();
        int movedC = getC() + d.getUnitMove().getC();
        if (movedR < 0 || movedC < 0 ||
                movedR >= getMaze().getRows() ||
                movedC >= getMaze().getCols())
            return false;
        if (getMaze().getBlock(movedR, movedC) != BLOCK.WALL) {
            move(d.getUnitMove());
            complete = true;
        }

        //if the player has walked into the air make them die
        if (getMaze().getBlock(getR(), getC()) == BLOCK.AIR)
            die(getR(), getC());

        return complete;
    }

    private void die(int row, int col) {
        // TODO: handle tombstones or something i dunno
        die();
    }

    private void die() {
        set(start);
    }




}
