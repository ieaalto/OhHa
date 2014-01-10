
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTextField;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;

/**
 *ActionListener piirtonapille. Lisaa tekstikenttien sisällöt funktiohallintaan ja päivittää kuvaajanalustan.
 */
public class PiirtonapinKuuntelija implements ActionListener{
    
    private Funktiohallinta funktiohallinta;
    private Funktionsyotteet syotteet;
    private KuvaajanAlusta kuvaajanalusta;

    public PiirtonapinKuuntelija(Funktiohallinta funktiohallinta, Funktionsyotteet syotteet, KuvaajanAlusta kuvaajanalusta) {
        this.funktiohallinta = funktiohallinta;
        this.syotteet = syotteet;
        this.kuvaajanalusta = kuvaajanalusta;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        syotteet.lueSyotteet();
        
        kuvaajanalusta.repaint();
    }
    
}
