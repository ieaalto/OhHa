
package kuvaajanpiirtaja.domain;


public class Maarittelyjoukko {
    private double min;
    private double max;
    
    public Maarittelyjoukko(double min, double max){
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
    
    
}
