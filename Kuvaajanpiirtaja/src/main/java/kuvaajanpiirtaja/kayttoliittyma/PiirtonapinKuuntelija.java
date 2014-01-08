
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
    private JTextField funktionsyotto1;
    private JTextField funktionsyotto2; 
    private JTextField funktionsyotto3;
    private JTextField funktionsyotto4;
    private KuvaajanAlusta kuvaajanalusta;

    public PiirtonapinKuuntelija(Funktiohallinta funktiohallinta, JTextField funktionsyotto1, JTextField funktionsyotto2, JTextField funktionsyotto3, JTextField funktionsyotto4, KuvaajanAlusta kuvaajanalusta) {
        this.funktiohallinta = funktiohallinta;
        this.funktionsyotto1 = funktionsyotto1;
        this.funktionsyotto2 = funktionsyotto2;
        this.funktionsyotto3 = funktionsyotto3;
        this.funktionsyotto4 = funktionsyotto4;
        this.kuvaajanalusta = kuvaajanalusta;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String funktio1 = funktionsyotto1.getText();
        String funktio2 = funktionsyotto2.getText();
        String funktio3 = funktionsyotto3.getText();
        String funktio4 = funktionsyotto4.getText();
        List<String> funktiot = Arrays.asList(funktio1, funktio2, funktio3, funktio4);
        
        funktiohallinta.tyhjenna();
        
        for (String s : funktiot){
            funktiohallinta.lisaaFunktio(s);
        }
        
        kuvaajanalusta.repaint();
    }
    
}
