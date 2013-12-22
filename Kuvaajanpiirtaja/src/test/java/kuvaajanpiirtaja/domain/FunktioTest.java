
package kuvaajanpiirtaja.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FunktioTest {
    
    public FunktioTest() {
    }
    
    @Before
    public void setUp() {
    }
    

    @Test
    public void laskeYPalauttaaOikeanLuvunPerusoperaattorit() {
        Funktio f = new Funktio("x + 2");
        assertTrue(f.laskeY(2)==4.0);
        f = new Funktio("3.3 - x");
        assertTrue(f.laskeY(3.3) == 0.0);
        f = new Funktio("x * 2");
        assertTrue(f.laskeY(3) == (double)3*2);
        f = new Funktio("3 / x");
        assertTrue(f.laskeY(6) == 0.5);
        f = new Funktio("x^5");
        assertTrue(f.laskeY(3) == Math.pow(3, 5));
    }
    
    @Test
    public void LaskeYPalauttaaOikeanLuvunPerusoperaattorit2(){
        Funktio f = new Funktio("-x + 2^3");
        assertTrue(f.laskeY(2)== (double)-2 + Math.pow(2,3));
        f = new Funktio("3.3 - x + 2*3.3 - 3.3 - 3.3/3.3");
        assertTrue(f.laskeY(3.3) == 2.3);
        f = new Funktio("x*2 / 2 - 4.5/ 1.2");
        assertTrue(f.laskeY(3) == (double)3*2/2- 4.5/ 1.2);
    }
    @Test
    public void laskeYPalauttaaOikeanLuvunSulut(){
        Funktio f = new Funktio("(-x + 2)");
        assertTrue(f.laskeY(2)== (double) -2 +2);
        f = new Funktio("(x-3)*(3/3)");
        assertTrue(f.laskeY(2)== -1);
        f = new Funktio("(1 + (2 -(x + 1))/(2-1))");
        assertTrue(f.laskeY(6)== (1 + (2 -(6+1)/(2-1))));    
    }
    
    @Test
    public void LaskeYPalauttaaOikeanLuvunErikoisoperaattorit(){
        Funktio f = new Funktio("log(x) + 2");
        assertTrue(f.laskeY(5) ==  Math.log10(5)+2);
        f = new Funktio("ln(7.2) - x");
        assertTrue(f.laskeY(5) ==  Math.log(7.2) - 5);
        f = new Funktio("sqt(3)*x");
        assertTrue(f.laskeY(4) ==  Math.sqrt(3)*4);
        f = new Funktio("abs(x - 3)");
        assertTrue(f.laskeY(1) == (double) Math.abs(1- 3));        
    }
    
    @Test
    public void LaskeYPalauttaaOikeanLuvunErikoisoperaattorit2(){
        Funktio f = new Funktio("sin(x) - asin(0.5)");
        assertTrue(f.laskeY(25) == (double) Math.sin(25) - Math.asin(0.5));
        f = new Funktio("acos(x) * cos(2)");
        assertTrue(f.laskeY(0.2) == (double) Math.acos(0.2)*Math.cos(2));
        f = new Funktio("tan(atan(x))");
        assertTrue(f.laskeY(0.5) == (double) Math.tan(Math.atan(0.5)));        
    }
}
