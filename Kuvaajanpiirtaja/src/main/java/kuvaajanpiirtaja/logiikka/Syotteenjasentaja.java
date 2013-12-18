
package kuvaajanpiirtaja.logiikka;


public class Syotteenjasentaja {
    
    private String[] sallitutMerkit = {"x"," ","1","2","3","4","5","6","7","8","9","0","^","log","ln(","cos","tan","sin","sqt","(",")","/","*","-","+","abs","e","pi","arc"};
    
    public Syotteenjasentaja(){};
    
    public boolean syoteKelpaa(String syote) {
        if(!syote.contains("x")){
            return false;
        }
        for(int i = 0; i < syote.length(); i++){
            int osumat = 0;
            for(String s : sallitutMerkit){
                if((s.equals(syote.substring(i,i+1)))||
                  (i < syote.length()-2 && s.equals(syote.substring(i, i+3)))||
                  (i < syote.length()-1 && s.equals(syote.substring(i, i+2)))){
                    osumat++;
                }                
            } if (osumat == 0 ){
                return false;
            }
        }
        return true;
    }
    
}
