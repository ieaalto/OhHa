
package kuvaajanpiirtaja.domain.funktionlogiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class LaskijaTest {
    Laskija laskija = new Arvonlaskija();
    
    public LaskijaTest() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void etsiLukuToimii(){
        String merkkijono = "2+3";
        assertTrue(laskija.etsiLuku(merkkijono).equals("2"));
        merkkijono = "5.2*3-2";
        assertTrue(laskija.etsiLuku(merkkijono).equals("5.2"));
        merkkijono = "-5.2*3-2";
        assertTrue(laskija.etsiLuku(merkkijono).equals("-5.2"));
        merkkijono = "526/34";
        assertTrue(laskija.etsiLuku(merkkijono).equals("526"));
        merkkijono = "2";
        assertTrue(laskija.etsiLuku(merkkijono).equals("2"));       
    }
    
    @Test 
    public void etsiLukuTaaksepainToimii(){
        String merkkijono = "2+3";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("3"));
        merkkijono = "5.2*3-2.8";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("-2.8"));
        merkkijono = "-5.2*3+7.1";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("7.1"));
        merkkijono = "526/34";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("34"));
        merkkijono = "2";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("2"));   
    
    }     
    
    @Test
    public void etsiSulutToimii(){
        String merkkijono = "(2+3)";
        assertTrue(laskija.etsiSulut(merkkijono).equals("2+3"));
        merkkijono = "(aef)+2";
        assertTrue(laskija.etsiSulut(merkkijono).equals("aef"));
    }
    @Test
    public void etsiSulutToimiiSisakkaisetSulut(){        
       String merkkijono = "((3-4)+2)";
       assertTrue(laskija.etsiSulut(merkkijono).equals("(3-4)+2"));
       merkkijono = "((3+2) - (2+(3-2)))";
       assertTrue(laskija.etsiSulut(merkkijono).equals("(3+2) - (2+(3-2))"));       
       
    }
     
    @Test 
    public void etsiSulutEiSulkuja(){
        String merkkijono = "aef";
        assertTrue(laskija.etsiSulut(merkkijono).equals("aef"));
    }

}
