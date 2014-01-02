package kuvaajanpiirtaja.domain.funktionlogiikka;

import java.text.DecimalFormat;
/**
 * Laskee String-muotoisen lausekkeen Double-arvon.
 */

public class Arvonlaskija extends Laskija {   
    
    public Arvonlaskija(){
    }
    
    /**
     * Laskee syötteen double-arvon.
     * @param syote Laskettava lauseke.
     * @return Lausekkeen arvo.
     * @throws NumberFormatException Jos syötteen arvon laskeminen ei onnistunut. 
     */
    public double laske(String syote) throws NumberFormatException{
        try{
            return Double.parseDouble(syote);
        }catch(Exception e){
            return lueArvoSulut(syote);
        }        
    }
    
    
    private double lueArvoSulut(String funktio) throws NumberFormatException{

        for(int i = 0; i < funktio.length(); i++){
            if(funktio.charAt(i) == '('){
                String sulut = etsiSulut(funktio.substring(i));
                String laskettuOsa = String.valueOf((double) laske(sulut));
                funktio = funktio.replace("("+sulut+")", laskettuOsa);
                i = 0;
            }
        }
        
        funktio = poistaOperaattorit(funktio, new char[]{'(',')'});
        return lueArvoPotenssi(funktio);
    }
    
    
    private double lueArvoPotenssi(String funktio){
        for(int i = 1; i < funktio.length(); i++){
            if(funktio.charAt(i) == 'P'){
                String a = etsiLukuTaaksepain(funktio.substring(0, i));
                String b = etsiLuku(funktio.substring(i));
                funktio = funktio.replaceFirst(a+"P"+b,String.valueOf(Math.floor(Math.pow(Double.parseDouble(a),Double.parseDouble(b))*1000)/1000));
                i = 0;
            }     
        
        }
        return lueArvoErikoisoperaattorit(funktio);
    }
    
    
    private double lueArvoErikoisoperaattorit(String funktio) throws NumberFormatException{
        char[] korvattavat = {'L','N','S','C','T','Z','K','D','R','A'};
        for(int i = 0; i < funktio.length(); i++){
            for(char c : korvattavat){ 
                if(c == funktio.charAt(i)){
                    String osa = etsiLuku(funktio.substring(i));
                    String laskettuOsa = osa;
            
                    if(funktio.charAt(i)=='L'){
                        laskettuOsa = String.valueOf(Math.log10(laske(osa)));
                    } else if(funktio.charAt(i)=='N'){                
                        laskettuOsa = String.valueOf(Math.log(laske(osa)));
                    } else if(funktio.charAt(i)=='S'){
                        laskettuOsa = String.valueOf(Math.sin(laske(osa)));  
                    } else if(funktio.charAt(i)=='C'){
                        laskettuOsa = String.valueOf(Math.cos(laske(osa)));
                    } else if(funktio.charAt(i)=='T'){
                        laskettuOsa = String.valueOf(Math.tan(laske(osa)));
                    } else if(funktio.charAt(i)=='Z'){
                        laskettuOsa = String.valueOf(Math.asin(laske(osa)));
                    } else if(funktio.charAt(i)=='K'){
                        laskettuOsa = String.valueOf(Math.acos(laske(osa)));
                    } else if(funktio.charAt(i)=='D'){
                        laskettuOsa = String.valueOf(Math.atan(laske(osa)));
                    } else if(funktio.charAt(i)=='R'){
                        laskettuOsa = String.valueOf(Math.sqrt(laske(osa)));
                    } else if(funktio.charAt(i)=='A'){
                        laskettuOsa = String.valueOf(Math.abs(laske(osa)));
                    }   
            
                    funktio = funktio.replaceFirst("("+osa+")", laskettuOsa);
                }
            }        
        }
        funktio = poistaOperaattorit(funktio, korvattavat);
        return  lueArvoKertoJako(funktio);        
    }
        
    
    private double lueArvoKertoJako(String funktio) throws NumberFormatException{
        for(int i = 1; i < funktio.length(); i++){
            if(funktio.charAt(i) == '*' ||  funktio.charAt(i)== '/'){
                String a = etsiLukuTaaksepain(funktio.substring(0, i));
                String b = etsiLuku(funktio.substring(i));
                if(funktio.charAt(i) == '*'){
                    funktio = funktio.replaceFirst(a+"[*]"+b, String.valueOf(Double.parseDouble(a)*Double.parseDouble(b))) ;
                    i = 0;
                }else if(funktio.charAt(i) == '/'){
                    funktio = funktio.replaceFirst(a+"/"+b , String.valueOf(Double.parseDouble(a)/Double.parseDouble(b)));
                    i = 0;
                }    
            }
        }
        return lueArvoPlusMiinus(funktio);
    }
      
    
    private double lueArvoPlusMiinus(String funktio) throws NumberFormatException{
        
        for(int i = 1; i < funktio.length()-1; i++){
            if(funktio.charAt(i) == '+' ||  funktio.charAt(i)== '-'){
                String a = etsiLukuTaaksepain(funktio.substring(0,i));
                String b = etsiLuku(funktio.substring(i+1));
                if(funktio.charAt(i) == '+'){
                    funktio = funktio.replaceFirst(a+"[+]"+b, String.valueOf(Double.parseDouble(a)+Double.parseDouble(b))) ;
                    i = 0;
                }else if(funktio.charAt(i) == '-' && funktio.charAt(i-1)!='E') {
                    funktio = funktio.replaceFirst(a+"-"+b, String.valueOf(Double.parseDouble(a)-Double.parseDouble(b))) ;
                    i = 0;
                }
            }     
        }
        
        funktio = funktio.replace("+","");
        return Double.parseDouble(funktio);       
    }
    

    
    private String poistaOperaattorit(String merkkijono, char[] korvattavat) {       
        for(char s:korvattavat){
           merkkijono = merkkijono.replace(String.valueOf(s),"");
        }
        return merkkijono;
    }

}
