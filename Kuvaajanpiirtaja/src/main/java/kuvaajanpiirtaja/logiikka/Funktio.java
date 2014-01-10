package kuvaajanpiirtaja.logiikka;

import kuvaajanpiirtaja.logiikka.funktionlogiikka.Arvonlaskija;
import kuvaajanpiirtaja.logiikka.funktionlogiikka.Syotteenjasentaja;

/**
 * Laskee konstruktorissa annettavan funktion arvoja.
 */
public class Funktio {
    
    private Syotteenjasentaja jasentaja;
    private Arvonlaskija laskija;
    
    public Funktio(String syote, Funktiohallinta funktiohallinta) throws IllegalArgumentException{
          laskija = new Arvonlaskija(funktiohallinta);
          jasentaja = new Syotteenjasentaja(syote, true);
    }    
    
    /**
     * Laskee funktion arvon annetulla x:n arvolla.
     * @param x x:n arvo.
     * @return Funktion arvo x:llä.
     * @throws NumberFormatException Jos arvon laskeminen ei onnistunut. 
     */
    
    public double laskeY(double x) throws Exception {
        String funktio = jasentaja.getSyote().replace("x",String.valueOf(x));
        return laskija.laske(funktio);
    }
    
}
