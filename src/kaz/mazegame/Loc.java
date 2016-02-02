package kaz.mazegame;

/**
 * Created by kasra on 2/1/2016.
 */
public class Loc {
    //basic position class
    private int x, y;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public double getDist(Loc l) {
        return Math.sqrt(x*l.getX() + y*l.getY());
    }

    public void move(Loc l) {
        x += l.getX();
        y += l.getY();
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }


}
