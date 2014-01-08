
package hiekkalaatikko;

import kuvaajanpiirtaja.logiikka.Funktio;
import kuvaajanpiirtaja.logiikka.Piste;
import kuvaajanpiirtaja.logiikka.funktionlogiikka.Arvonlaskija;


public class Main {
    public static void main(String[] args){
        Funktio f = new Funktio("x+log(x)");
        Arvonlaskija laskija = new Arvonlaskija();
        
       //for(double x = 0; x <= 1; x += 0.1){
         //       double a = Math.floor(x*1000)/1000;
           //     double b = f.laskeY(Math.floor(x*1000)/1000);
       //}
        //System.out.println(f.laskeY(-9.9));
        System.out.println(laskija.laske("0.32"));

      //  }
        
    }
}
