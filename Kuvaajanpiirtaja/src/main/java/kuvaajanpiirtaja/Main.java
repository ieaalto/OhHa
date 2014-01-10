package kuvaajanpiirtaja;

import kuvaajanpiirtaja.kayttoliittyma.Kayttoliittyma;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;

public class Main {
        public static void main(String[] args){
            
            Funktiohallinta funktiohallinta = new Funktiohallinta();
            Kayttoliittyma kayttoliittyma = new Kayttoliittyma(funktiohallinta);

            kayttoliittyma.run();
        }
}
