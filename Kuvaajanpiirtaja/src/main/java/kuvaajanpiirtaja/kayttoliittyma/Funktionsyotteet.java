/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuvaajanpiirtaja.kayttoliittyma;

import java.util.HashMap;
import javax.swing.JTextField;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;

/**
 * Lukee JTextFieldien sisällön ja tallentaa ne funktiohallintaan.
 */
public class Funktionsyotteet {
    private HashMap<Integer , JTextField> tekstikentat = new HashMap<>();
    private Funktiohallinta funktiohallinta;
    private JTextField virhekentta;
    
    public Funktionsyotteet(Funktiohallinta funktiohallinta, JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField virhekentta){
        this.funktiohallinta = funktiohallinta;
        tekstikentat.put(0, t1);
        tekstikentat.put(1, t2);
        tekstikentat.put(2, t3);
        tekstikentat.put(3, t4);
        this.virhekentta = virhekentta;
    }
    
    /**
     * Lukee syötteet tekstikentistä ja yrittää tallentaa ne funktiohallintaan. Päivittää myös virhekentän. 
     */
    public void lueSyotteet(){
        funktiohallinta.tyhjenna();
        virhekentta.setText("");
        for(int i = 0; i< 4; i++){
            String funktio = tekstikentat.get(i).getText();
            if(!funktio.isEmpty()){
                boolean onnistui = funktiohallinta.lisaaFunktio(funktio,i);
                if(onnistui){
                    virhekentta.setText(virhekentta.getText()+"f"+(i+1)+": OK!  ");
                } else{
                    virhekentta.setText(virhekentta.getText()+"f"+(i+1)+": Virhe!  ");
                }
            }
        }    
    }
    
}
