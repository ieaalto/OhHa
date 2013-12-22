
package hiekkalaatikko;

import kuvaajanpiirtaja.domain.Funktio;
import kuvaajanpiirtaja.domain.funktionlogiikka.Arvonlaskija;


public class Main {
    public static void main(String[] args){
        Funktio f = new Funktio("(x-3)*(3/3)");
        System.out.println(f.laskeY(2));
        
    }
}
