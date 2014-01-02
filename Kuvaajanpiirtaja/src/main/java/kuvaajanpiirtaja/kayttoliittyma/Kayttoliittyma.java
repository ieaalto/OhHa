
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import kuvaajanpiirtaja.domain.KuvaajanPisteet;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Funktiohallinta funktiohallinta;
    
    public Kayttoliittyma(Funktiohallinta funktiohallinta) {
        this.funktiohallinta = funktiohallinta;
    }

    @Override
    public void run() {
        frame = new JFrame("Kuvaajanpiirtaja");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        KuvaajanAlusta k = new KuvaajanAlusta();
        for(KuvaajanPisteet kp: funktiohallinta.laskePisteet()){
            k.lisaaKayra(kp);
        }
        container.add(k);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}