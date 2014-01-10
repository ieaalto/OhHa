
package kuvaajanpiirtaja.logiikka.funktionlogiikka;

/**
 * Yläluokka funktiota käsitteleville luokille. Määrittelee metodit lukujen sekä sulkujen sisällön hakemiseen.
 * 
 */
public abstract class Laskija {
    
    /**
     * Palauttaa merkkijonon ensimmäisen luvun. Esim. syötteellä -2.5+2 palauttaa -2.5. 
     * @param merkkijono 
     * @return Löydetty luku;
     */
    public String etsiLuku(String merkkijono) throws Exception{
        merkkijono =  merkkijono.replace("Infinity","I");
        for (int i = 0; i < merkkijono.length(); i++) {
            if (Character.isDigit(merkkijono.charAt(i)) || (merkkijono.charAt(i) == '-') || merkkijono.charAt(i) == 'I') {    
                for (int n = i + 1; n < merkkijono.length(); n++) {
                    if(merkkijono.charAt(n) == 'E' && n < merkkijono.length()-2){
                        if(eenSisaltavaLukuPaattyy(merkkijono, n, 1)) return merkkijono.substring(i,n).replace("I","Infinity"); 
                        n += 1;                    
                    } else if (!Character.isDigit(merkkijono.charAt(n)) && (merkkijono.charAt(n) != '.') && merkkijono.charAt(n) != 'I'){
                        return merkkijono.substring(i, n).replace("I","Infinity");
                    } 
                }
                return merkkijono.substring(i).replace("I","Infinity");
            }
        }
        return "0";
    }
    
    /**
     * Palauttaa merkkijonon viimeisen luvun. Esim syötteellä -2.5+2 palauttaa 2.
     * @param merkkijono
     * @return Löydetty luku.
     */
    
    public String etsiLukuTaaksepain(String merkkijono) throws Exception {
        merkkijono = merkkijono.replace("Infinity","I");
        for (int i = merkkijono.length() - 1; i >= 0; i--) {
            if (Character.isDigit(merkkijono.charAt(i)) || merkkijono.charAt(i) == 'I') {
                for (int n = i - 1; n >= 0; n--) {
                   if(merkkijono.charAt(n) == 'E' && n > 1){
                        if(eenSisaltavaLukuPaattyy(merkkijono, n, -1))return merkkijono.substring(n,i+1).replace("I","Infinity"); 
                        n -= 1;  
                    
                    }if (!Character.isDigit(merkkijono.charAt(n)) && (merkkijono.charAt(n) != '.') && (merkkijono.charAt(n) != '-')) {
                        return merkkijono.substring(n+1, i+1).replace("I","Infinity");
                    } else if (merkkijono.charAt(n) == '-' && n != 0) {
                        if(Character.isDigit(merkkijono.charAt(n-1))){
                            return merkkijono.substring(n+1, i+1).replace("I","Infinity");
                        }else if(merkkijono.charAt(n-1) != 'E' ){
                            return merkkijono.substring(n, i + 1).replace("I","Infinity");
                        }

                    }
                }
                return merkkijono.replace("I","Infinity");
            }
        }
        return "0";
    }
    
    /**
     * Etsii merkkijonon ensimmäisten sulujen sisällön. Esim. syötteellä ((2+2)-2)+(3-1) palauttaa (2+2)-2.
     * @param merkkijono
     * @return Löydetty merkkijono
     */
    public String etsiSulut(String merkkijono) throws Exception{
        int sulut = 0;
        int alku = 0;
        for (int i = 0; i < merkkijono.length(); i++) {
            if (merkkijono.charAt(i) == '(') {
                if (sulut == 0) {
                    alku = i;
                }
                sulut++;
            } else if (merkkijono.charAt(i) == ')') {
                sulut--;
                if (sulut == 0) {
                    return merkkijono.substring(alku + 1, i);
                }
            }
        }
        if(sulut > 0){
            throw new IllegalArgumentException();
        }
        return merkkijono;
    }

    /**
     * Tarkistaa päättyykkö E:n sisältävä luku merkkijonon kohdassa i. 
     * @param merkkijono
     * @param i 
     * @param suunta suunta, johon merkkijonoa luetaan
     * @return true jos luku päättyy.
     */
    private boolean eenSisaltavaLukuPaattyy(String merkkijono, int i, int suunta) {
        if (!Character.isDigit(merkkijono.charAt(i+suunta)) && merkkijono.charAt(i+suunta) != '-') {
            return true;
        } else if (merkkijono.charAt(i+suunta) == '-' && !Character.isDigit(merkkijono.charAt(i+suunta*2))) {
            return true;
        }
        return false;
    }

    
}

