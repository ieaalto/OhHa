
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
        assertTrue(!hallinta.lisaaFunktio("aeg3",0));
        assertTrue(!hallinta.lisaaFunktio("x + asd + 3",0));
        assertTrue(!hallinta.lisaaFunktio("2-+2++",0));        
        
    }
    
    @Test
    public void funktioitaEiLisataVaarallaSyotteella2(){
        assertTrue(!hallinta.lisaaFunktio("x + L + 2",0));
        assertTrue(!hallinta.lisaaFunktio("x++2",0));
        assertTrue(!hallinta.lisaaFunktio("+x*/2",0));
    }
    
    @Test
    public void funktioitaEiLisataVaarallaSyotteella3(){
        assertTrue(!hallinta.lisaaFunktio("3*/x",0));
        assertTrue(!hallinta.lisaaFunktio("-x+2//3",0));
        assertTrue(!hallinta.lisaaFunktio("*2+x/",0));
    }
    
    @Test
    public void funktiotaEiLisataMuuttujattomallaSyotteella(){
        assertTrue(!hallinta.lisaaFunktio("2",0));
        assertTrue(!hallinta.lisaaFunktio("15 * 3",0));
        assertTrue(!hallinta.lisaaFunktio("log(12) - 2",0));
                
    }
    @Test
    public void funktioLisataanOikeallaSyotteella(){
        assertTrue(hallinta.lisaaFunktio("x + 2",0));
        assertTrue(hallinta.lisaaFunktio("2*x - 1",0));
        assertTrue(hallinta.lisaaFunktio("x^2 + 2/3",0));
    }
    @Test
    public void funktioLisataanOikeallaSyotteella2(){        
        assertTrue(hallinta.lisaaFunktio("log(x) + ln(x)",0));
        assertTrue(hallinta.lisaaFunktio("abs(x - sin(1))",0));
        assertTrue(hallinta.lisaaFunktio("sqt(x - cos(1))",0));
        assertTrue(hallinta.lisaaFunktio("e + pi*x",0));
    }
    
    @Test 
    public void laskePisteetPalauttaaNullJosEiFunktioitaLisatty(){
        assertTrue(hallinta.laskePisteet()==null);
    }
    
    @Test 
    public void funktioEiSaaViitataItseensa(){
        assertTrue(!hallinta.lisaaFunktio("f2(x)",1));
        assertTrue(!hallinta.lisaaFunktio("f3(x)",2));
        assertTrue(!hallinta.lisaaFunktio("f4(x)",3));
        hallinta.lisaaFunktio("x^2",0);
        assertTrue(!hallinta.lisaaFunktio("f1(x)",0));
    }
    
    @Test
    public void laskePisteetPalauttaaArrayListinJosFunktioitaLisatty(){
        hallinta.lisaaFunktio("x + 2",0);
        ArrayList<ArrayList<Piste>> lista = hallinta.laskePisteet();
        assertTrue(lista.size() > 0);
    }
    
    @Test
    public void laskePisteetPalauttaaYhtaPitkanListanKuinFunktioita(){
        ArrayList<ArrayList<Piste>> lista;
        for(int i = 0; i < 10; i++){
                    hallinta.lisaaFunktio("x + 2",i);
                    lista = hallinta.laskePisteet();
                    assertTrue(lista.size()==i+1);
        }
        
    }
    
    @Test
    public void tyhjennaTyhjentaaFunktiohallinnan(){
        hallinta.lisaaFunktio("x + 2",0);
        hallinta.lisaaFunktio("x^2",1);
        hallinta.lisaaFunktio("sin(x)",2);
        hallinta.tyhjenna();
        assertTrue(hallinta.laskePisteet() == null);
    }
    
    @Test 
    public void getFunktioPalauttaaOikeanFunktion() throws Exception{
        hallinta.lisaaFunktio("x^2", 0);
        assertTrue(hallinta.getFunktio(0).laskeY(2) == 4.0);
        hallinta.lisaaFunktio("x^3", 0);
        assertTrue(hallinta.getFunktio(0).laskeY(2) == 8.0);
        hallinta.tyhjenna();
        hallinta.lisaaFunktio("x^2",2);
        assertTrue(hallinta.getFunktio(2).laskeY(2) == 4.0);
    }

    @Test 
    public void kelvottomatAsetuksetHylataan(){
        assertTrue(!hallinta.setAsetukset(-1, -1, -1, 1));
        assertTrue(!hallinta.setAsetukset(-1, 1, -1, -1));
        assertTrue(!hallinta.setAsetukset(-1, -2, 1, -1));
        assertTrue(!hallinta.setAsetukset(-2, -1, -1, -2));
    }
}



