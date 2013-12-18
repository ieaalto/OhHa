
package kuvaajanpiirtaja.domain;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuvaajanPisteetTest {
    KuvaajanPisteet pisteet;
    
    public KuvaajanPisteetTest() {
    }
    
    @Before
    public void setUp() {
        pisteet =new KuvaajanPisteet(new Funktio("x + 2"),-1,1,10,0.5);
    }
    
    @Test
    public void PisteetEiOleTyhja(){
        assertTrue( pisteet.getPisteet().size() > 0 );        
    }
    
    @Test
    public void oikeatPisteetLoytyy(){
        List<Piste> lista = pisteet.getPisteet();
        for(int i = 0; i < lista.size();i++){
            assertTrue(lista.get(i).x() == (int)(-1 + i*0.5)*10 );
        }
    }
    @Test
    public void negatiivistaAskeltaEiKelpuuteta(){
        try{
            pisteet = new KuvaajanPisteet(new Funktio("x + 2"), -1, 1,10,-0.5);
        }catch(Exception e){
            return;
        }
        fail();
    }
    @Test
    public void maksimiaSuurempaaMinimiaEiKelpuuteta(){
        try{
            pisteet = new KuvaajanPisteet(new Funktio("x + 2"), 2, 1,10,0.5);
        }catch(Exception e){
            return;
        }
        fail();
    }
    @Test
    public void epapositiivistaResoluutiotaEiKelpuuteta(){
        try{
            pisteet = new KuvaajanPisteet(new Funktio("x + 2"), -1, 1,-10,0.5);
        }catch(Exception e){
            return;
        } try{
            pisteet = new KuvaajanPisteet(new Funktio("x + 2"), -1, 1, 0,0.5);
        }catch(Exception e){
            return;
        }
        fail();
    }
    
}