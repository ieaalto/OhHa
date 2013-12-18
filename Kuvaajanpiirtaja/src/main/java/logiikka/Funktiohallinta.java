package logiikka;

import java.util.ArrayList;
import java.util.List;
import kuvaajanpiirtaja.domain.*;

/**
 *  Hallinnoi funktioita
 * 
 */
public class Funktiohallinta {
    
    private ArrayList<Funktio> funktiot = new ArrayList<>();
    private double minX = -1;
    private double maxX = 1;
    private int resoluutio = 1;
    private double askel = 1;
    
    /**
     *
     */
    public Funktiohallinta(){};

    /**
     * Funktion kuvaaja piirretään välillä maxX - minX. Asettaa minX:n.
     * @param minX
     */
    public void setMinX(int minX) {
        this.minX = minX;
    }

    /**
     * Funktion kuvaaja piirretään välillä maxX - minX. Asettaa maxX:n.
     * @param maxX
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    /**
     * Asettaa piirtoresoluution, siis kuinka monta pikseliä ruudulla vastaa yhtä matemaattista yksikköä. 
     * @param resoluutio
     */
    public void setResoluutio(int resoluutio) {
        this.resoluutio = resoluutio;
    }

    /**
     * Asettaa käyrän pisteiden laskemisessa käytettävän askeleen pituuden, siis kahden pisteen etäisyyden x-akselilla.
     * @param askel Askeleen pituus.
     */
    public void setAskel(double askel) {
        this.askel = askel;
    }
        
    
    /**
     * Lisää funktion. 
     * 
     * @param syote Määrittää funktion. Esim. 2*x + 2.
     * @return True, jos funktio lisättiin onnistuneesti.
     */
    public boolean lisaaFunktio(String syote){
        try {
            funktiot.add(new Funktio(syote));
        } catch (Exception E){
            return false;
        }
        
        return true;
    }
    
    /**
     * Luo ja palauttaa List<KayranPisteet> -olion, joka sisältää jokaiselle funktiolle luodun KuvaajanPisteet -olion. 
     * @return  ArrayList<KayranPisteet> tai null, jos yhtään funktiota ei ole lisatty.
     */
    public ArrayList<KuvaajanPisteet> laskePisteet(){
        ArrayList<KuvaajanPisteet> pisteet = new ArrayList<>();
        if(!funktiot.isEmpty()){
            for(Funktio f : funktiot){
                pisteet.add(new KuvaajanPisteet(f, minX, maxX, resoluutio, askel));
            }
            return pisteet;
        }
        return null;
    }
}
