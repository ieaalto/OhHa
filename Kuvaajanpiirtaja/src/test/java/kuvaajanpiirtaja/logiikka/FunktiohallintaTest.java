
package kuvaajanpiirtaja.logiikka;

import java.util.ArrayList;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;
import kuvaajanpiirtaja.logiikka.KuvaajanPisteet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FunktiohallintaTest {
    Funktiohallinta hallinta;
    
    public FunktiohallintaTest() {
    }
    

    @Before
    public void setUp() {
        hallinta = new Funktiohallinta();
    }
    
    @Test
    public void funktiotaEiLisataVaarallaSyotteella(){
        assertTrue(!hallinta.lisaaFunktio("aeg3"));
        assertTrue(!hallinta.lisaaFunktio("x + asd + 3"));
        assertTrue(!hallinta.lisaaFunktio("2-+2++"));        
        
    }
    
    @Test
    public void funktioitaEiLisataVaarallaSyotteella2(){
        assertTrue(!hallinta.lisaaFunktio("x + L + 2"));
        assertTrue(!hallinta.lisaaFunktio("x++2"));
        assertTrue(!hallinta.lisaaFunktio("+x*/2"));
    }
    
    @Test
    public void funktioitaEiLisataVaarallaSyotteella3(){
        assertTrue(!hallinta.lisaaFunktio("3*/x"));
        assertTrue(!hallinta.lisaaFunktio("-x+2//3"));
        assertTrue(!hallinta.lisaaFunktio("*2+x/"));
    }
    
    @Test
    public void funktiotaEiLisataMuuttujattomallaSyotteella(){
        assertTrue(!hallinta.lisaaFunktio("2"));
        assertTrue(!hallinta.lisaaFunktio("15 * 3"));
        assertTrue(!hallinta.lisaaFunktio("log(12) - 2"));
                
    }
    @Test
    public void funktioLisataanOikeallaSyotteella(){
        assertTrue(hallinta.lisaaFunktio("x + 2"));
        assertTrue(hallinta.lisaaFunktio("2*x - 1"));
        assertTrue(hallinta.lisaaFunktio("x^2 + 2/3"));
    }
    @Test
    public void funktioLisataanOikeallaSyotteella2(){        
        assertTrue(hallinta.lisaaFunktio("log(x) + ln(x)"));
        assertTrue(hallinta.lisaaFunktio("abs(x - sin(1))"));
        assertTrue(hallinta.lisaaFunktio("sqt(x - cos(1))"));
        assertTrue(hallinta.lisaaFunktio("e + pi*x"));
    }
    
    @Test 
    public void laskePisteetPalauttaaNullJosEiFunktioitaLisatty(){
        assertTrue(hallinta.laskePisteet()==null);
    }
    
    @Test
    public void laskePisteetPalauttaaArrayListinJosFunktioitaLisatty(){
        hallinta.lisaaFunktio("x + 2");
        ArrayList<ArrayList<Piste>> lista = hallinta.laskePisteet();
        assertTrue(lista.size() > 0);
    }
    
    @Test
    public void laskePisteetPalauttaaYhtaPitkanListanKuinFunktioita(){
        ArrayList<ArrayList<Piste>> lista;
        for(int i = 0; i < 10; i++){
                    hallinta.lisaaFunktio("x + 2");
                    lista = hallinta.laskePisteet();
                    assertTrue(lista.size()==i+1);
        }
        
    }
    
    @Test
    public void tyhjennaTyhjentaaFunktiohallinnan(){
        hallinta.lisaaFunktio("x + 2");
        hallinta.lisaaFunktio("x^2");
        hallinta.lisaaFunktio("sin(x)");
        hallinta.tyhjenna();
        assertTrue(hallinta.laskePisteet() == null);
    }

}



