package kuvaajanpiirtaja.logiikka.funktionlogiikka;

import kuvaajanpiirtaja.logiikka.Funktiohallinta;
/**
 * Laskee String-muotoisen lausekkeen Double-arvon.
 */

public class Arvonlaskija extends Laskija {   
    
    Funktiohallinta funktiohallinta;
    
    public Arvonlaskija(Funktiohallinta funktiohallinta){
        this.funktiohallinta = funktiohallinta;
    }
    
    /**
     * Laskee syötteen double-arvon.
     * @param syote Laskettava lauseke.
     * @return Lausekkeen arvo.
     * @throws Exception Jos syötteen arvon laskeminen ei onnistunut. 
     */
    public double laske(String syote) throws Exception{
        try{
            return Double.parseDouble(syote);
        }catch(Exception e){
            return lueArvoSulut(syote);
        }        
    }
    
    /**
     * Etsii merkkijonosta sulut ja korvaa ne niiden sisällön lasketulla arvolla.
     * @param lauseke luettava merkkijono
     * @return välittää lopullisen arvon
     * @throws Exception 
     */
    private double lueArvoSulut(String lauseke) throws Exception{

        for(int i = 0; i < lauseke.length(); i++){
            if(lauseke.charAt(i) == '('){
                String sulut = etsiSulut(lauseke.substring(i));
                String laskettuOsa = String.valueOf((double) laske(sulut));
                lauseke = lauseke.replace("("+sulut+")", laskettuOsa);
                i = 0;
            }
        }
        
        lauseke = poistaOperaattorit(lauseke, new char[]{'(',')'}).replace("--","+").replace("++","+");
        return lueArvoPotenssi(lauseke);
    }
    
    /**
     * Etsii merkkijonosta potenssimerkit ja laskee niitä edeltävän ja seuraavan luvun, sekä korvaa ne edeltävällä luvulla korotettuna seuraavan luvun 
     * potenssiin.  
     * @param lauseke luettava merkkijono
     * @return välittää lopullisen arvon
     * @throws Exception 
     */
    private double lueArvoPotenssi(String lauseke) throws Exception{
        for(int i = 1; i < lauseke.length()-1; i++){
            if(lauseke.charAt(i) == 'P'){
                String a = etsiLukuTaaksepain(lauseke.substring(0, i));
                String b = etsiLuku(lauseke.substring(i));
                lauseke = lauseke.replaceFirst(a+"P"+b, String.valueOf(Math.pow(Double.parseDouble(a),Double.parseDouble(b))));
                i = 0;
            }     
        
        }
        return lueArvoErikoisoperaattorit(lauseke);
    }
    
    /**
     * Etsii merkkijonosta erikoisoperaattori(sin, abs, log jne.) sekä korvaa operaattorin ja sitä seuraavan luvun operaattoria vastaavan funktion arvolla. 
     * @param lauseke 
     * @return välittää lopullisen arvon
     * @throws Exception 
     */
    private double lueArvoErikoisoperaattorit(String lauseke) throws Exception{
        char[] etsittavat = {'L','N','S','C','T','Z','K','D','R','A'};
        for(int i = 0; i < lauseke.length(); i++){
            for(char c : etsittavat){ 
                if(c == lauseke.charAt(i)){
                    String luku = etsiLuku(lauseke.substring(i));
                    String laskettu = luku;
            
                    if(lauseke.charAt(i)=='L'){
                        laskettu = String.valueOf(Math.log10(laske(luku)));
                    } else if(lauseke.charAt(i)=='N'){                
                        laskettu = String.valueOf(Math.log(laske(luku)));
                    } else if(lauseke.charAt(i)=='S'){
                        laskettu = String.valueOf(Math.sin(laske(luku)));  
                    } else if(lauseke.charAt(i)=='C'){
                        laskettu = String.valueOf(Math.cos(laske(luku)));
                    } else if(lauseke.charAt(i)=='T'){
                        laskettu = String.valueOf(Math.tan(laske(luku)));
                    } else if(lauseke.charAt(i)=='Z'){
                        laskettu = String.valueOf(Math.asin(laske(luku)));
                    } else if(lauseke.charAt(i)=='K'){
                        laskettu = String.valueOf(Math.acos(laske(luku)));
                    } else if(lauseke.charAt(i)=='D'){
                        laskettu = String.valueOf(Math.atan(laske(luku)));
                    } else if(lauseke.charAt(i)=='R'){
                        laskettu = String.valueOf(Math.sqrt(laske(luku)));
                    } else if(lauseke.charAt(i)=='A'){
                        laskettu = String.valueOf(Math.abs(laske(luku)));
                    }   
            
                    lauseke = lauseke.substring(0,i)+lauseke.substring(i).replaceFirst(luku, laskettu);
                }
            }        
        }
        if(lauseke.contains("NaN")){
            throw new NumberFormatException();
        }
        lauseke = poistaOperaattorit(lauseke, etsittavat);
        return  lueArvoFunktiot(lauseke);        
    }
        
    /**
     * Kuten lueArvoErikoisoperaattorit, mutta etsii omat funktiot.
     * @param lauseke
     * @return välittää lopullisen arvon
     * @throws Exception 
     */
    private double lueArvoFunktiot(String lauseke) throws Exception{
        char[] etsittavat = {'F','G','H','J'};
        for(int i = 0; i < lauseke.length(); i++){
            for(char c : etsittavat){ 
                if(c == lauseke.charAt(i)){
                    String luku = etsiLuku(lauseke.substring(i));
                    String laskettu = luku;
            
                    if(lauseke.charAt(i)=='F'){
                        laskettu = String.valueOf(funktiohallinta.getFunktio(0).laskeY(laske(luku)));
                    } else if(lauseke.charAt(i)=='G'){                
                        laskettu = String.valueOf(funktiohallinta.getFunktio(1).laskeY(laske(luku)));
                    } else if(lauseke.charAt(i)=='H'){
                        laskettu = String.valueOf(funktiohallinta.getFunktio(2).laskeY(laske(luku))); 
                    } else if(lauseke.charAt(i)=='J'){
                        laskettu = String.valueOf(funktiohallinta.getFunktio(3).laskeY(laske(luku)));
                    }   
            
                    lauseke = lauseke.substring(0,i)+lauseke.substring(i).replaceFirst(luku, laskettu);
                }
            }        
        }
        if(lauseke.contains("NaN")){
            throw new NumberFormatException();
        }
        lauseke = poistaOperaattorit(lauseke, etsittavat);
        return  lueArvoKertoJako(lauseke);        
    }
    
    /**
     * Etsii kerto- ja jakomerkit, ja korvaa niitä edeltävän ja seuraavan luvun näiden tulolla tai osamäärällä.
     * @param lauseke luettava merkkijono
     * @return välittää lopullisen arvon
     * @throws Exception 
     */
    private double lueArvoKertoJako(String lauseke) throws Exception{
        for(int i = 1; i < lauseke.length()-1; i++){
            if(lauseke.charAt(i) == '*' ||  lauseke.charAt(i)== '/'){
                String a = etsiLukuTaaksepain(lauseke.substring(0, i));
                String b = etsiLuku(lauseke.substring(i));
                if(lauseke.charAt(i) == '*'){
                    lauseke = lauseke.replaceFirst(a+"[*]"+b, String.valueOf(Double.parseDouble(a)*Double.parseDouble(b))) ;
                    i = 0;
                }else if(lauseke.charAt(i) == '/'){
                    lauseke = lauseke.replaceFirst(a+"/"+b , String.valueOf(Double.parseDouble(a)/Double.parseDouble(b)));
                    i = 0;
                }    
            }
        }
        return lueArvoPlusMiinus(lauseke);
    }
      
    /**
     * Etsii plus- ja miinusmerkit ja korvaa niitä seuraavan ja edeltävän luvun näiden summalla tai erotuksella. Ensimmäistä ja viimeistä 
     * merkkiä ei huomioida.
     * @param lauseke luettavva merkkijono
     * @return lopullinen arvo
     * @throws Exception jos lopullista arvoa ei kyetä lukemaan.
     */
    private double lueArvoPlusMiinus(String lauseke) throws Exception{
        
        lauseke = lauseke.replace("--","+");
        for(int i = 1; i < lauseke.length()-1; i++){
            if(lauseke.charAt(i) == '+' ||  lauseke.charAt(i)== '-'){
                String a = etsiLukuTaaksepain(lauseke.substring(0,i));
                String b = etsiLuku(lauseke.substring(i+1));
                if(lauseke.charAt(i) == '+'){
                    lauseke = lauseke.replaceFirst(a+"[+]"+b, String.valueOf(Double.parseDouble(a)+Double.parseDouble(b))) ;
                    i = 0;
                }else if(lauseke.charAt(i) == '-' && lauseke.charAt(i-1)!='E') {
                    lauseke = lauseke.replaceFirst(a+"-"+b, String.valueOf(Double.parseDouble(a)-Double.parseDouble(b))) ;
                    i = 0;
                }
            }     
        }
        
        lauseke = lauseke.replace("+","");
        return Double.parseDouble(lauseke);       
    }
    

    /**
     * Poistaa annetut merkit.
     * @param merkkijono merkkijono, josta merkit poistetaan.
     * @param etsittavat etsittavat merkit.
     * @return merkkijono ilman poistettavia merkkejä
     */
    private String poistaOperaattorit(String merkkijono, char[] poistettavat) {       
        for(char s:poistettavat){
           merkkijono = merkkijono.replace(String.valueOf(s),"");
        }
        return merkkijono;
    }

}
