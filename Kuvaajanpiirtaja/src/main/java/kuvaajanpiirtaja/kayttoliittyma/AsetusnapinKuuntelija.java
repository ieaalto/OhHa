package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;

/**
 * ActionListener Käytä-napille. Lukee asetukset spinnereistä ja asettaa asetukset funktiohallinnan avulla.
 */

public class AsetusnapinKuuntelija implements ActionListener {
    private JSpinner minXSpinner;
    private JSpinner maxXSpinner;
    private JSpinner minYSpinner;
    private JSpinner maxYSpinner;
    private Funktiohallinta funktiohallinta;
    private JTextField virhekentta;

    public AsetusnapinKuuntelija(JSpinner minXSpinner, JSpinner maxXSpinner, JSpinner minYSpinner, JSpinner maxYSpinner, Funktiohallinta funktiohallinta,JTextField virhekentta) {
        this.minXSpinner = minXSpinner;
        this.maxXSpinner = maxXSpinner;
        this.minYSpinner = minYSpinner;
        this.maxYSpinner = maxYSpinner;
        this.funktiohallinta = funktiohallinta;
        this.virhekentta = virhekentta;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        double minX = (double)minXSpinner.getValue();
        double maxX = (double)maxXSpinner.getValue();
        double minY = (double)minYSpinner.getValue();
        double maxY = (double)maxYSpinner.getValue();
        
        boolean onnistui = funktiohallinta.setAsetukset(minX, maxX, minY, maxY);
        if(onnistui){
            virhekentta.setText("Asetukset OK!");
        } else{
            virhekentta.setText("Virheelliset asetukset!");
        } 
    }
    
}
