
package kuvaajanpiirtaja.logiikka;

/**
 * Tallentaa piirtoasetukset.
 */
public class Asetukset {
    private double minX = -10;
    private double maxX = 10;
    private double minY = -10;
    private double maxY = 10; 
    
    public Asetukset(){}
    /**
     * Asettaa asetukset. Piste (minX,minY) piirretään piirtoalueen vasempaan alakulmaan.
     * @param minX x:n alaraja.
     * @param maxX x:n yläraja.
     * @param minY y:n alaraja. 
     * @param maxY y:n yläraja.
     */
    public void setAsetukset(double minX, double maxX, double minY, double maxY){
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }
    
    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }
    
    /**
     * Palauttaa kertoimen, jolla x:n arvot piirrettäessä kerrotaan.
     * @return x:n kertoin.
     */
    public double kerroinX(){
        return (maxX-minX)/20;
    }

     /**
     * Palauttaa kertoimen, jolla y:n arvot piirrettäessä kerrotaan.
     * @return y:n kertoin.
     */
    public double kerroinY(){
        return 20/(maxY-minY);
    }
    
    /**
     * Palauttaa y:n arvoihin lisättävän arvon, jolla piirtoalueen keskipiste kohdistetaan minY:n ja maxY:n väliin. 
     * @return 
     */
    public double lisaysY(){
        return (maxY+minY)/2;
    }
    
    /**
     * Palauttaa x:n arvoihin lisättävän arvon, jolla piirtoalueen keskipiste kohdistetaan minX:n ja maxX:n väliin.
     * @return 
     */
    public double lisaysX(){
        return (maxX+minX)/2;
    }
}

