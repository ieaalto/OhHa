package kuvaajanpiirtaja.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *  Hallinnoi funktioita
 * 
 */
public class Funktiohallinta {
    
    private ArrayList<Funktio> funktiot = new ArrayList<>();
    private double minX = -10;
    private double maxX = 10;
    private int kerroinY = 30;
    private int kerroinX = 30;
    private double askel = 0.1;
    
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
     * Asettaa x-akselin piirtokertoimen, siis kuinka monta pikseliä ruudulla vastaa yhtä matemaattista yksikköä. 
     * @param resoluutio
     */
    public void setKerroinX(int kerroin) {
        this.kerroinX = kerroin;
    }

    /**
     * 
     */
    public void setKerroinY(int kerroin){
        this.kerroinY = kerroin;
    }
    
    /**
     * Asettaa käyrän pisteiden laskemisessa käytettävän askeleen pituuden, siis kahden pisteen etäisyyden x-akselilla.
     * @param askel Askeleen pituus.
     */
    public void setAskel(double askel) {
        this.askel = askel;
    }
        
    /**
     * Tyhjentää funktiohallinnan.
     */
    public void tyhjenna(){
        funktiot.clear();
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
    
    public Funktio getFunktio(int i){
        return funktiot.get(i);
    }
    /**
     * Luo ja palauttaa List<KayranPisteet> -olion, joka sisältää jokaiselle funktiolle luodun KuvaajanPisteet -olion. 
     * @return  ArrayList<KayranPisteet> tai null, jos yhtään funktiota ei ole lisatty.
     */
    public ArrayList<ArrayList<Piste>> laskePisteet(){
        ArrayList<ArrayList<Piste>> pisteet = new ArrayList<>();
        KuvaajanPisteet kuvaajanPisteet = new KuvaajanPisteet();
        if(!funktiot.isEmpty()){
            for(Funktio f : funktiot){
                pisteet.addAll(kuvaajanPisteet.laskePisteet(f, minX, maxX, kerroinY, kerroinX, askel));
            }
            return pisteet;
        }
        return null;
    }
}
