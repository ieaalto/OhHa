package kuvaajanpiirtaja.logiikka;
/**
 * Piste (x,y)-koordinaatiostossa.
 */

public class Piste {
    
    private int x;
    private int y;
    
    public Piste(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }    
    
}
