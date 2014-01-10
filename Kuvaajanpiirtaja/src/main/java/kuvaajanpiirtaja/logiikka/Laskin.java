/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuvaajanpiirtaja.logiikka;

import java.util.regex.Pattern;
import kuvaajanpiirtaja.logiikka.funktionlogiikka.Arvonlaskija;
import kuvaajanpiirtaja.logiikka.funktionlogiikka.Syotteenjasentaja;

/**
 *Laskee lausekkeen arvon.;
 * @author Iiro
 */
public class Laskin {
    private Arvonlaskija laskija;
    private Funktiohallinta funktiohallinta;
    
    public Laskin(Funktiohallinta funktiohallinta){
        this.funktiohallinta = funktiohallinta;
        laskija = new Arvonlaskija(funktiohallinta);
    }
    /**
     * Laskee lausekkeen arvon.
     * @param lauseke Laskettava lauseke
     * @return Lausekkeen arvo.
     * @throws Exception kun lauseketta ei voida laskea.
     */
    
    public double laskeLauseke(String lauseke) throws Exception {
        
        Syotteenjasentaja jasentaja = new Syotteenjasentaja(lauseke, false);
        return laskija.laske(jasentaja.getSyote());
    }

}
