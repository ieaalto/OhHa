package kuvaajanpiirtaja.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Laskee ja tallentaa pisteet, joiden mukaan kuvaaja piirretään.
 */
public class KuvaajanPisteet {
    private ArrayList<Piste> pisteet = new ArrayList<>();
    
    /**
     * Pisteet lasketaan olion luonnin yhteydessä. 
     * 
     * @param Funktio, jonka mukaan pisteet lasketaan.
     * @param X:n arvo, josta laskeminen aloitetaan.
     * @param X:n arvo, johon laskeminen lopetetaan.
     * @param Matemaattisen yksikön suhde piirtoyksikköön.
     * @param Kahden pisteen etäisyys. 
     */
    public KuvaajanPisteet(Funktio funktio, double minX, double maxX, double minY, double maxY, int resoluutio, double askel){        
        boolean parametritKelpaa = laskePisteet(funktio,minX,maxX,minY,maxY,resoluutio,askel);
        if(!parametritKelpaa){ 
            throw new IllegalArgumentException();
        }
    }
    
    
    private boolean laskePisteet(Funktio funktio ,double minX, double maxX,double minY, double maxY,int resoluutio ,double askel){
        if(askel > 0 && minX < maxX && resoluutio > 0){
            for(int x = (int) minX*100; x <= maxX*100; x += askel*100){
                try{
                    pisteet.add(new Piste((int)(((double)x/100)*resoluutio+300),(int)(-funktio.laskeY(((double)x/100))*resoluutio+300)));
                } catch(Exception e){
                    continue;
                }    
            }
            return true;
        }
        return false;
    }
    
    public ArrayList<Piste> getPisteet(){
        return pisteet;
    }
    
    
}
