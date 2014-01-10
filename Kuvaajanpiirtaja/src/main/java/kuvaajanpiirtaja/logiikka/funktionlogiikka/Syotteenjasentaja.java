
package kuvaajanpiirtaja.logiikka.funktionlogiikka;

import java.util.Arrays;
import java.util.List;

/**
 * Jäsentää käyttäjän antaman syötteen Arvonlaskijan ymmärtämään muotoon.
 */

public class Syotteenjasentaja {
    
    private List<Character> sallitutMerkit = Arrays.asList('x','A','Z','D','K','.','1','2','3','4','5','6','7','8','9','0','P','L','N','C','T','S','R','(',')','/','*','-','+','F','G','H','J');
    private List<Character> eivatSaaOllaPerakkain = Arrays.asList('P','/','*','+');
    private String syote;
    
    /**
     * Muotoilee syötteen, heittää poikkeuksen jos syöte on virheellinen.
     * @param syote
     * @param onFunktio true, jos syöte on funktio, false jos lauseke. 
     */
    public Syotteenjasentaja(String syote, boolean onFunktio){
        this.syote = muotoileSyote(syote);
        if(!syoteKelpaa(onFunktio)){
            throw new IllegalArgumentException();
        }
        
    }
    
    /**
     * Tarkistaa syötteen kelvollisuuden.
     * @param onFunktio jos true, tulee syötteen sisältää muuttuja x, jos false, se ei saa sisältää muuttujaa. 
     * @return True, jos syöte kelpaa.
     */
    public boolean syoteKelpaa(boolean onFunktio) {
        if(onFunktio && !syote.contains("x")){
            return false;
        } else if (!onFunktio &&syote.contains("x")){
            return false;
        }
        for(int i = 0; i < syote.length(); i++){ 
            if(!sallitutMerkit.contains(syote.charAt(i))){
                return false;
            } if (eivatSaaOllaPerakkain.contains(syote.charAt(i)) || syote.charAt(i) == '-'){
                if(i < syote.length()-2){
                    if(eivatSaaOllaPerakkain.contains(syote.charAt(i+1))){
                        return false;
                    }
                } if (syote.charAt(i) != '-' &&(i == 0 || i == syote.length()-1)){
                    return false;
                }
            }    
        }
        return true;
    }
    
    
    public String getSyote(){
        return syote;
    }
    
    /**
     * Muotoilee syötteen Arvonlaskija ymmärtämään muotoon.
     * @param syote
     * @return muotoiltu syöte.
     */
    private String muotoileSyote(String syote){
        String muotoiltu = syote.toLowerCase(); 
        muotoiltu = muotoiltu.replace(",",".");
        muotoiltu = muotoiltu.replace(" ", "");
        muotoiltu = muotoiltu.replace("^", "P");
        muotoiltu = muotoiltu.replace("log", "L");
        muotoiltu = muotoiltu.replace("ln", "N");
        muotoiltu = muotoiltu.replace("asin", "Z");
        muotoiltu = muotoiltu.replace("acos", "K");
        muotoiltu = muotoiltu.replace("atan", "D");        
        muotoiltu = muotoiltu.replace("sin", "S");
        muotoiltu = muotoiltu.replace("cos", "C");
        muotoiltu = muotoiltu.replace("tan", "T");
        muotoiltu = muotoiltu.replace("sqt", "R");
        muotoiltu = muotoiltu.replace("abs", "A");
        muotoiltu = muotoiltu.replace("pi", String.valueOf(Math.PI));
        muotoiltu = muotoiltu.replace("e",String.valueOf(Math.E));
        muotoiltu = muotoiltu.replace("f1","F");
        muotoiltu = muotoiltu.replace("f2","G");
        muotoiltu = muotoiltu.replace("f3","H");
        muotoiltu = muotoiltu.replace("f4","J");
        return muotoiltu;
    }
    
}
