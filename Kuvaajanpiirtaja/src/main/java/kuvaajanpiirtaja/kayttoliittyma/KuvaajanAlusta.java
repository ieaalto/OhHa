
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;
import kuvaajanpiirtaja.logiikka.Piste;

/**
 *  Pohja, jolle kuvaajat piirretään.
 */

public class KuvaajanAlusta extends JPanel{
    
    private Funktiohallinta funktiohallinta;
    
    public KuvaajanAlusta(Funktiohallinta funktiohallinta){
        super.setBackground(Color.WHITE);    
        this.funktiohallinta = funktiohallinta;
    }

    
    @Override
    protected void paintComponent(Graphics graphics) {      
       
        super.paintComponent(graphics);
        
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.drawLine(0, 300, 600, 300);
        graphics.drawLine(300, 0, 300, 600);
           
        graphics.setColor(Color.BLACK);
        
        ArrayList<ArrayList<Piste>> pistelistat= funktiohallinta.laskePisteet();
        if(pistelistat != null) {
            for(ArrayList<Piste> pisteet : pistelistat){
                PisteitaSeuraavaKayra kayra = new PisteitaSeuraavaKayra(pisteet);
                kayra.piirra(graphics);
            }
        } 
        
    }
}
