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
        this.r += l.getR();
        this.c += l.getC();
    }

    public void move(int dr, int dc) {
        this.r += dr;
        this.c += dc;
    }

    public void set(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void set(Loc l) {
        set(l.getR(), l.getC());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loc)) return false;

        Loc loc = (Loc) o;

        if (r != loc.r) return false;
        return c == loc.c;

    }

    @Override
    public int hashCode() {
        int result = r;
        result = 31 * result + c;
        return result;
    }
}
