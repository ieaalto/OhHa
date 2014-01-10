
package kuvaajanpiirtaja.logiikka.funktionlogiikka;

import kuvaajanpiirtaja.logiikka.Funktiohallinta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class LaskijaTest {
    Laskija laskija;
    
    public LaskijaTest() {
    }

    @Before
    public void setUp() {
        laskija = new Arvonlaskija(new Funktiohallinta());
    }
    
    @Test
    public void etsiLukuToimii() throws Exception{
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
    public void etsiLukuToimii2() throws Exception{
        String merkkijono = "2E2+3.2";
        assertTrue(laskija.etsiLuku(merkkijono).equals("2E2"));
        merkkijono = "-43E32*3.2";
        assertTrue(laskija.etsiLuku(merkkijono).equals("-43E32"));
        merkkijono = "7.245E2/3";
        assertTrue(laskija.etsiLuku(merkkijono).equals("7.245E2"));
        merkkijono = "56E-3-5";
        assertTrue(laskija.etsiLuku(merkkijono).equals("56E-3"));
    
    }
    
    @Test 
    public void etsiLukuTaaksepainToimii() throws Exception{
        String merkkijono = "2+3";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("3"));
        merkkijono = "5.2*3-2.8";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("2.8"));
        merkkijono = "-5.2*3+7.1";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("7.1"));
        merkkijono = "526/34";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("34"));
        merkkijono = "-2";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("-2"));   
    
    }     
    @Test
    public void etsiLukuTaaksepainToimii2() throws Exception{
        String merkkijono = "3+3E4";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("3E4"));
        merkkijono = "6^5.33E423";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("5.33E423"));
        merkkijono = "52*53E-322";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("53E-322"));
    }
    
    @Test
    public void etsiLukuLoytaaAarettoman() throws Exception{
        String merkkijono = "Infinity";
        assertTrue(laskija.etsiLuku(merkkijono).equals("Infinity"));
        merkkijono = "Infinity*3";
        assertTrue(laskija.etsiLuku(merkkijono).equals("Infinity"));
        merkkijono = "-Infinity*3";
        assertTrue(laskija.etsiLuku(merkkijono).equals("-Infinity"));
    }
    
    @Test
    public void etsiLukuTaaksepainLoytaaAarettoman() throws Exception{
        String merkkijono = "Infinity";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("Infinity"));
        merkkijono = "4-Infinity";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("Infinity"));
        merkkijono = "4*-Infinity";
        assertTrue(laskija.etsiLukuTaaksepain(merkkijono).equals("-Infinity"));
    }
    
    
    
    @Test
    public void etsiSulutToimii() throws Exception{
        String merkkijono = "(2+3)";
        assertTrue(laskija.etsiSulut(merkkijono).equals("2+3"));
        merkkijono = "(aef)+2";
        assertTrue(laskija.etsiSulut(merkkijono).equals("aef"));
    }
    @Test
    public void etsiSulutToimiiSisakkaisetSulut() throws Exception{        
       String merkkijono = "((3-4)+2)";
       assertTrue(laskija.etsiSulut(merkkijono).equals("(3-4)+2"));
       merkkijono = "((3+2) - (2+(3-2)))";
       assertTrue(laskija.etsiSulut(merkkijono).equals("(3+2) - (2+(3-2))"));       
       
    }
     
    @Test 
    public void etsiSulutEiSulkuja() throws Exception{
        String merkkijono = "aef";
        assertTrue(laskija.etsiSulut(merkkijono).equals("aef"));
    }



}
