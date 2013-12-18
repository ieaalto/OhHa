package kuvaajanpiirtaja.domain;

import kuvaajanpiirtaja.logiikka.Syotteenjasentaja;


public class Funktio {
    
    private Syotteenjasentaja jasentaja = new Syotteenjasentaja();
    private String syote;
    
    public Funktio(String syote){
        if(jasentaja.syoteKelpaa(syote)){
            this.syote = syote;
        } else {
            throw new IllegalArgumentException();
      }
    }    
        
    public double laskeY(double x){
        return x;
    }
}
