package kuvaajanpiirtaja;

import kuvaajanpiirtaja.kayttoliittyma.Kayttoliittyma;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;

public class Main {
        public static void main(String[] args){
            
            Funktiohallinta funktiohallinta = new Funktiohallinta();
            funktiohallinta.lisaaFunktio("sqt(abs(x)-1)");
            Kayttoliittyma kayttoliittyma = new Kayttoliittyma(funktiohallinta);

            kayttoliittyma.run();
        }
}
