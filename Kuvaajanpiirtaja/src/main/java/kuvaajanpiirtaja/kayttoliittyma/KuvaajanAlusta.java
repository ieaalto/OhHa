
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import kuvaajanpiirtaja.domain.KuvaajanPisteet;

/**
 *  Pohja, jolle kuvaajat piirretään.
 * @author Iiro
 */

public class KuvaajanAlusta extends JPanel{
    
    private ArrayList<PisteitaSeuraavaKayra> kayrat = new ArrayList<>();
    
    public KuvaajanAlusta(){
        super.setBackground(Color.WHITE);        
    }
    
    public void lisaaKayra(KuvaajanPisteet pisteet){
        kayrat.add(new PisteitaSeuraavaKayra(pisteet.getPisteet()));
    }
    
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for(PisteitaSeuraavaKayra k : kayrat){
              k.piirra(graphics);
        }

    }
}
