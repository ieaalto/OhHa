package kuvaajanpiirtaja.domain;

import kuvaajanpiirtaja.domain.funktionlogiikka.Arvonlaskija;
import kuvaajanpiirtaja.domain.funktionlogiikka.MaarittelyjoukonLaskija;
import kuvaajanpiirtaja.domain.funktionlogiikka.Syotteenjasentaja;

/**
 * Laskee konstruktorissa annettavan funktion arvoja.
 */
public class Funktio {
    
    private Syotteenjasentaja jasentaja;
    private Maarittelyjoukko maarittelyjoukko;
    
    public Funktio(String syote) throws IllegalArgumentException{
          jasentaja = new Syotteenjasentaja(syote);
          MaarittelyjoukonLaskija laskija = new MaarittelyjoukonLaskija();
          maarittelyjoukko = laskija.laske(syote);
    }    
    
    /**
     * Laskee funktion arvon annetulla x:n arvolla.
     * @param x x:n arvo.
     * @return Funktion arvo x:llä.
     * @throws NumberFormatException Jos arvon laskeminen ei onnistunut. 
     */
    
    public double laskeY(double x) throws NumberFormatException {
        Arvonlaskija laskija = new Arvonlaskija();
        String funktio = jasentaja.getSyote().replace("x",String.valueOf(x));
        return laskija.laske(funktio);
    }
    
    public Maarittelyjoukko getMaarittelyjoukko(){
        return maarittelyjoukko;
    }
}
