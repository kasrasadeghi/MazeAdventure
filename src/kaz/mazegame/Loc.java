package kaz.mazegame;

/**
 * Created by kasra on 2/1/2016.
 */
public class Loc {
    //basic position class
    private int r, c;

    public Loc(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {return r;}
    public int getC() {return c;}

    public double getDist(Loc l) {
        return Math.sqrt(r *l.getR() + c *l.getC());
    }

    public void move(Loc l) {
        this.r += l.r;
        this.c += l.c;
    }

    public void move(int dr, int dc) {
        this.r += dr;
        this.c += dc;
    }

    public void set(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public Loc add(Loc l) {
        return new Loc(r + l.r, c + l.c);
    }

    public Loc getDirLoc(DIRECTION d) {
        return add(d.getUnitMove());
    }

    public void set(Loc l) {
        set(l.getR(), l.getC());
    }


    public boolean same(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loc)) return false;

        Loc loc = (Loc) o;

        if (r != loc.r) return false;
        return c == loc.c;
    }
}
