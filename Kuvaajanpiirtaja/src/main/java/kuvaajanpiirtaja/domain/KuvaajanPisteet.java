package kuvaajanpiirtaja.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Laskee ja tallentaa pisteet, joiden mukaan kuvaaja piirretään.
 */
public class KuvaajanPisteet {
    private List<Piste> pisteet = new ArrayList<>();
    
    /**
     * Pisteet lasketaan olion luonnin yhteydessä. 
     * 
     * @param Funktio, jonka mukaan pisteet lasketaan.
     * @param X:n arvo, josta laskeminen aloitetaan.
     * @param X:n arvo, johon laskeminen lopetetaan.
     * @param Matemaattisen yksikön suhde piirtoyksikköön.
     * @param Kahden pisteen etäisyys. 
     */
    public KuvaajanPisteet(Funktio funktio, double minX, double maxX, int resoluutio, double askel){        
        boolean parametritKelpaa = laskePisteet(funktio,minX,maxX,resoluutio,askel);
        if(!parametritKelpaa){ 
            throw new IllegalArgumentException();
        }
    }
    
    
    private boolean laskePisteet(Funktio funktio ,double minX, double maxX,int resoluutio ,double askel){
        if(askel > 0 && minX < maxX && resoluutio > 0){
            for(double x = minX; x <= maxX; x += askel){
                pisteet.add(new Piste((int) x*resoluutio,(int)funktio.laskeY(x)*resoluutio));
            }
            return true;
        }
        return false;
    }
    
    public List<Piste> getPisteet(){
        return pisteet;
    }
    
    
}
