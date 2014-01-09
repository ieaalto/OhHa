/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuvaajanpiirtaja.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class LaskinTest {
    
    Funktiohallinta funktiohallinta = new Funktiohallinta();
    Laskin laskin = new Laskin(funktiohallinta);
    
    public LaskinTest() {                
    }
    
    @Before
    public void setUp() {
        funktiohallinta.lisaaFunktio("x-1");
        funktiohallinta.lisaaFunktio("x-2");
        funktiohallinta.lisaaFunktio("x-3");
        funktiohallinta.lisaaFunktio("x-4");
    }

    @Test
    public void laskinToimiiIlmanFunktioita() {
        try{
            assertTrue(String.valueOf(laskin.laskeLauseke("2+2")),laskin.laskeLauseke("2+2") == 4.0);
        } catch(Exception e){ fail(); 
        } try{
            assertTrue(String.valueOf(laskin.laskeLauseke("2*3.1/sin(1)")),laskin.laskeLauseke("2+2") == 4.0);
        } catch(Exception e){ fail(); }
        
    }
    
    @Test 
    public void laskinToimiiFunktioilla(){
        try{
            assertTrue(String.valueOf(laskin.laskeLauseke("f1(2.0*2.0)")),laskin.laskeLauseke("f1(2.0*2.0)") == 3.0);
        } catch(Exception e){ fail(); 
        } try{
            assertTrue(String.valueOf(laskin.laskeLauseke("f2(1.0+2.0)")),laskin.laskeLauseke("f2(3.0)") == 1.0);
        } catch(Exception e){ fail(); 
        } try{
           assertTrue(String.valueOf(laskin.laskeLauseke("f3(2.0*2.0)")),laskin.laskeLauseke("f3(2.0*2.0)") == 1.0);
        } catch(Exception e){ fail(); 
        } try{
            assertTrue(String.valueOf(laskin.laskeLauseke("f4((sqt(5))^2)")),Math.floor(laskin.laskeLauseke("f4((sqt(5))^2)")) == 1.0);
        } catch(Exception e){ fail(); 
        }
    }
    
}
