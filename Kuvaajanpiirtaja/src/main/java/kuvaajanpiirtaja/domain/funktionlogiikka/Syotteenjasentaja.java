
package kuvaajanpiirtaja.domain.funktionlogiikka;


public class Syotteenjasentaja {
    
    private char[] sallitutMerkit = {'x','A','Z','D','K','.','1','2','3','4','5','6','7','8','9','0','P','L','N','C','T','S','R','(',')','/','*','-','+'};
    private String syote;
    
    public Syotteenjasentaja(String syote){
        this.syote = muotoileSyote(syote);
        if(!syoteKelpaa()){
            throw new IllegalArgumentException();
        }
        
    };
    
    public boolean syoteKelpaa() {
        if(!syote.contains("x")){
            return false;
        }
        for(int i = 0; i < syote.length(); i++){
            int osumat = 0;
            for(char c : sallitutMerkit){
                if(c == syote.charAt(i)){
                    osumat++;
                }                
            } if (osumat == 0 ){
                return false;
            }
        }
        return true;
    }
    
    public String getSyote(){
        return syote;
    }
    
    private String muotoileSyote(String syote){
        String muotoiltu = syote.toLowerCase(); 
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
        muotoiltu = muotoiltu.replace("pi", "3.14159");
        muotoiltu = muotoiltu.replace("e","2.71828");
        return muotoiltu;
    }
    
}
