
package kuvaajanpiirtaja.logiikka;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuvaajanPisteetTest {
    KuvaajanPisteet pisteet;
    Funktiohallinta hallinta;
    
    public KuvaajanPisteetTest() {
    }
    
    @Before
    public void setUp() {
        pisteet = new KuvaajanPisteet();
        hallinta = new Funktiohallinta();
    }
    

    @Test
    public void maksimiaSuurempaaMinimiaEiKelpuuteta(){
        assertTrue(pisteet.laskePisteet(new Funktio("x^2",hallinta),10,-10,30,30,30,0) == null);
    }
    @Test
    public void epapositiivisaKeroimiaEiKelpuuteta(){
        assertTrue(pisteet.laskePisteet(new Funktio("x^2",hallinta),10,10,-30,30,30,0) == null);
        assertTrue(pisteet.laskePisteet(new Funktio("x^2",hallinta),10,-10,30,-30,30,0) == null);
        assertTrue(pisteet.laskePisteet(new Funktio("x^2",hallinta),10,-10,30,30,0,0) == null);
        assertTrue(pisteet.laskePisteet(new Funktio("x^2",hallinta),10,-10,0,30,30,0) == null);
    }
    
    @Test
    public void palauttaaOikeanMaaranListoja(){
        ArrayList<ArrayList<Piste>> lista = pisteet.laskePisteet(new Funktio("x^2",hallinta),-10,10,1,1,0,0);
        assertTrue(lista.size() == 1);
        lista = pisteet.laskePisteet(new Funktio("sqt(abs(x)-2)",hallinta), -10, 10, 1, 1,0,0);
        assertTrue(String.valueOf(lista.size()),lista.size() == 2);
    }
    @Test
    public void pisteitaOikeaMaara(){
        ArrayList<ArrayList<Piste>> lista = pisteet.laskePisteet(new Funktio("x^3+1",hallinta),-10,10,1,1,0,0);
        assertTrue(lista.get(0).size() == 201);
        lista = lista = pisteet.laskePisteet(new Funktio("sqt(abs(x)-1)",hallinta), -10, 10,1,1,0,0);
        assertTrue(lista.get(0).size() == 91);
        assertTrue(lista.get(1).size() == 91);
    }
}
