
package kuvaajanpiirtaja.domain.funktionlogiikka;

import kuvaajanpiirtaja.domain.Maarittelyjoukko;


public class MaarittelyjoukonLaskija extends Laskija {

    public Maarittelyjoukko laske(String funktio) {
        return new Maarittelyjoukko(Double.MIN_VALUE, Double.MAX_VALUE);
    }
    
}
