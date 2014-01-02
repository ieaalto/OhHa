
package hiekkalaatikko;

import kuvaajanpiirtaja.domain.Funktio;
import kuvaajanpiirtaja.domain.Piste;
import kuvaajanpiirtaja.domain.funktionlogiikka.Arvonlaskija;


public class Main {
    public static void main(String[] args){
        Funktio f = new Funktio("x^3 -x^2");
        Arvonlaskija laskija = new Arvonlaskija();
        System.out.println(laskija.etsiLukuTaaksepain("52*53E-322"));
        
   //     for(double x = 0; x <= 1; x += 0.1){
   //             double a = Math.floor(x*1000)/1000;
   //             double b = f.laskeY(Math.floor(x*1000)/1000);
        //System.out.println(f.laskeY(0.4));

      //  }
        
    }
}
