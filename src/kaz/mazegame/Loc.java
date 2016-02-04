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

    public boolean equals(Object o){
        if (o instanceof Loc){
            Loc that = (Loc)o;
            if (this.getC() == that.getC() && this.getR() == this.getR())
                return true;
        }
        return false;
    }
}
