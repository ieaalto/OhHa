package kuvaajanpiirtaja;

import kuvaajanpiirtaja.kayttoliittyma.Kayttoliittyma;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;

public class Main {
        public static void main(String[] args){
            
            Funktiohallinta funktiohallinta = new Funktiohallinta();
            funktiohallinta.lisaaFunktio("1.25*x^2 + 1/4*x^3");
            Kayttoliittyma kayttoliittyma = new Kayttoliittyma(funktiohallinta);

            kayttoliittyma.run();
        }
}
