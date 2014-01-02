
package kuvaajanpiirtaja.domain.funktionlogiikka;

/**
 * Yläluokka funktiota käsitteleville luokille. 
 * 
 */
public abstract class Laskija {
    
    /**
     * Palauttaa merkkijonon ensimmäisen luvun. Esim. syötteellä -2.5+2 palauttaa -2.5. 
     * @param merkkijono 
     * @return Löydetty luku;
     */
    public String etsiLuku(String merkkijono) {
        for (int i = 0; i < merkkijono.length(); i++) {
            if (Character.isDigit(merkkijono.charAt(i)) || (merkkijono.charAt(i) == '-')) {
                for (int n = i + 1; n < merkkijono.length(); n++) {
                    if(merkkijono.charAt(n) == 'E' && n < merkkijono.length()-2){
                        if(!Character.isDigit(merkkijono.charAt(n+1)) && merkkijono.charAt(n+1) != '-'){
                            return merkkijono.substring(i,n);                       
                        } else if(merkkijono.charAt(n+1) == '-' && !Character.isDigit(merkkijono.charAt(n+2))){
                            return merkkijono.substring(i,n);
                        } 
                        n += 1;                    
                    } else if (!Character.isDigit(merkkijono.charAt(n)) && (merkkijono.charAt(n) != '.')){
                        return merkkijono.substring(i, n);
                    } else if (n == merkkijono.charAt(merkkijono.length() - 1)) {
                        return merkkijono.substring(i);
                    } 
                }
                return merkkijono.substring(i);
            }
        }
        return "0";
    }
    /**
     * Palauttaa merkkijonon viimeisen luvun. Esim syötteellä -2.5+2 palauttaa 2.
     * @param merkkijono
     * @return Löydetty luku.
     */
    
    public String etsiLukuTaaksepain(String merkkijono) {
        for (int i = merkkijono.length() - 1; i >= 0; i--) {
            if (Character.isDigit(merkkijono.charAt(i))) {
                for (int n = i - 1; n >= 0; n--) {
                   if(merkkijono.charAt(n) == 'E' && n > 1){
                        if(!Character.isDigit(merkkijono.charAt(n-1)) && merkkijono.charAt(n-1) != '-'){
                            return merkkijono.substring(n,i+1);                       
                        } else if(merkkijono.charAt(n-1) == '-' && !Character.isDigit(merkkijono.charAt(n-2))){
                            return merkkijono.substring(n,i-1);
                        } 
                        n -= 1;  
                    
                    }if (!Character.isDigit(merkkijono.charAt(n)) && (merkkijono.charAt(n) != '.') && (merkkijono.charAt(n) != '-')) {
                        return merkkijono.substring(n + 1, i + 1);
                    } else if (merkkijono.charAt(n) == '-' && n != 0) {
                        if(merkkijono.charAt(n-1) != 'E'){
                            return merkkijono.substring(n, i + 1);
                        }
                    } else if (n == merkkijono.charAt(0)) {
                        return merkkijono.substring(i);
                    }
                }
                return merkkijono;
            }
        }
        return "0";
    }
    /**
     * Etsii merkkijonon ensimmäisten sulujen sisällön. Esim. syötteellä ((2+2)-2)+(3-1) palauttaa (2+2)-2.
     * @param merkkijono
     * @return Löydetty merkkijono
     */
    public String etsiSulut(String merkkijono) {
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
        return merkkijono;
    }
    
}
