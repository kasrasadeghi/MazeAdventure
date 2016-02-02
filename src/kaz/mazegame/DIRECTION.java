package kaz.mazegame;

/**
 * Created by Sarah M on 2/2/2016.
 */
public enum DIRECTION {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);
    private int row, col;
    DIRECTION(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Loc getUnitMove() {
        return new Loc(row, col);
    }
}
