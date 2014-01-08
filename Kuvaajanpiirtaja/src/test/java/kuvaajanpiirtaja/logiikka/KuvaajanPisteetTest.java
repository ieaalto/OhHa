
package kuvaajanpiirtaja.logiikka;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuvaajanPisteetTest {
    KuvaajanPisteet pisteet;
    
    public KuvaajanPisteetTest() {
    }
    
    @Before
    public void setUp() {
        pisteet = new KuvaajanPisteet();
    }
    

    
    @Test
    public void negatiivistaAskeltaEiKelpuuteta(){
        assertTrue(pisteet.laskePisteet(new Funktio("x^2"),-10,-10,30,30,-0.2) == null);
    }
    @Test
    public void maksimiaSuurempaaMinimiaEiKelpuuteta(){
        assertTrue(pisteet.laskePisteet(new Funktio("x^2"),10,-10,30,30,0.2) == null);
    }
    @Test
    public void epapositiivisaKeroimiaEiKelpuuteta(){
        assertTrue(pisteet.laskePisteet(new Funktio("x^2"),10,10,-30,30,0.2) == null);
        assertTrue(pisteet.laskePisteet(new Funktio("x^2"),10,-10,30,-30,0.2) == null);
        assertTrue(pisteet.laskePisteet(new Funktio("x^2"),10,-10,30,0,0.2) == null);
        assertTrue(pisteet.laskePisteet(new Funktio("x^2"),10,-10,0,30,0.2) == null);
    }
    
    @Test
    public void palauttaaOikeanMaaranListoja(){
        ArrayList<ArrayList<Piste>> lista = pisteet.laskePisteet(new Funktio("x^2"),-10,10,30,30,1.0);
        assertTrue(lista.size() == 1);
        lista = pisteet.laskePisteet(new Funktio("sqt(abs(x)-2)"), -10, 10, 30, 30, 1.0);
        assertTrue(lista.size() == 2);
    }
    @Test
    public void pisteitaOikeaMaara(){
        ArrayList<ArrayList<Piste>> lista = pisteet.laskePisteet(new Funktio("x^3+1"),-10,10,30,30,1.0);
        assertTrue(lista.get(0).size() == 21);
        lista = lista = pisteet.laskePisteet(new Funktio("sqt(abs(x)-1)"), -10, 10, 30, 30, 1.0);
        assertTrue("alkioita: "+lista.get(0).size(),lista.get(0).size() == 10);
        assertTrue("alkioita: "+lista.get(1).size(),lista.get(1).size() == 10);
    }
}
