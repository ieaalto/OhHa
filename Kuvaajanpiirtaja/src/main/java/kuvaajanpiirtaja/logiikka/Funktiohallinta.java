package kuvaajanpiirtaja.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Tallentaa funktiot ja palauttaa kuvaajan piirtämiseen tarvittavat pistelistat. Välikäsi käyttöliittymän, funktion sekä kuvaajan piirtävien luokkien välillä.
 */
public class Funktiohallinta {
    
    private HashMap<Integer, Funktio> funktiot = new HashMap<>();
    private Asetukset asetukset = new Asetukset();
    /**
     * Pisteiden laskemisessa käytettävän askeleen pituus, siis kahden pisteen etäisyys x-akselilla.
     */
    
    public Funktiohallinta(){};
        
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
    public boolean lisaaFunktio(String syote, int index){
        if(syote.toLowerCase().contains("f"+(index+1))) {
            return false;
        }
        try {
            funktiot.put(index, new Funktio(syote, this));
        } catch (Exception E){
            return false;
        }
        
        return true;
    }
    /**
     * Asettaa asetukset asetukset-oliolle. Minimit eivät saa olla maksimeita suurempia.
     * @param minX 
     * @param maxX
     * @param minY
     * @param maxY
     * @return true, jos asetukset kelpasivat.
     */
    public boolean setAsetukset(double minX, double maxX, double minY, double maxY){
        if(minX < maxX && minY < maxY) {
            asetukset.setAsetukset(minX, maxX, minY, maxY);
            return true;
        }
        return false;
    }
    
    /**
     * Palauttaa funktion avaimella i.
     * @param i funktion avain (indeksi)
     * @return 
     */
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
            for(Funktio f : funktiot.values()){
                pisteet.addAll(kuvaajanPisteet.laskePisteet(f, asetukset.getMinX(), asetukset.getMaxX(), asetukset.kerroinY(), asetukset.kerroinX(), asetukset.lisaysX() ,asetukset.lisaysY()));
            }
            return pisteet;
        }
        return null;
    }
}
