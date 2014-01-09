/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuvaajanpiirtaja.logiikka;

import java.util.regex.Pattern;
import kuvaajanpiirtaja.logiikka.funktionlogiikka.Arvonlaskija;
import kuvaajanpiirtaja.logiikka.funktionlogiikka.Syotteenjasentaja;

/**
 *Laskee lausekkeen arvon;
 * @author Iiro
 */
public class Laskin {
    private Arvonlaskija laskija= new Arvonlaskija();
    private Funktiohallinta funktiohallinta;
    
    public Laskin(Funktiohallinta funktiohallinta){
        this.funktiohallinta = funktiohallinta;
    }
    
    public double laskeLauseke(String lauseke) throws Exception {
        for(int i = 0; i < lauseke.length()-2; i++){
            if(lauseke.substring(i,i+2).equals("f1")){
                lauseke = laskeFunktionArvo(lauseke, i, 0,"f1");
            } else if(lauseke.substring(i,i+2).equals("f2")){
                lauseke = laskeFunktionArvo(lauseke, i, 1, "f2");
            } else if(lauseke.substring(i,i+2).equals("f3")){
                lauseke = laskeFunktionArvo(lauseke, i, 2, "f3");
            } else if(lauseke.substring(i,i+2).equals("f4")){
                lauseke = laskeFunktionArvo(lauseke, i, 3, "f4");
            }
        }
        Syotteenjasentaja jasentaja = new Syotteenjasentaja(lauseke, false);
        return laskija.laske(jasentaja.getSyote());
    }

    private String laskeFunktionArvo(String lauseke, int i, int index, String korvattava) throws NumberFormatException {
        String sulut = laskija.etsiSulut(lauseke.substring(i));
        if(sulut.isEmpty()){
            throw new IllegalArgumentException();
        }
        Syotteenjasentaja jasentaja = new Syotteenjasentaja(sulut,false);
        double arvo = laskija.laske(jasentaja.getSyote());
        double fArvo = funktiohallinta.getFunktio(index).laskeY(arvo);   
        lauseke = lauseke.replaceFirst(korvattava,"");
        lauseke = lauseke.replaceFirst(Pattern.quote(sulut), String.valueOf(fArvo));        
        return lauseke;
    }
}
