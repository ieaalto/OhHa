
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
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
        frame.setPreferredSize(new Dimension(900, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(null);
        
        KuvaajanAlusta kuvaajanalusta = new KuvaajanAlusta(funktiohallinta);
        kuvaajanalusta.setBounds(0, 0, 600, 600);
        
        container.add(kuvaajanalusta);
        
        JPanel palkki = new JPanel();
        palkki.setLayout(null);
        palkki.setSize(300, 600);
        palkki.setBounds(600,0,300,600);
        
        JTextField funktiosyotto = new JTextField();
        funktiosyotto.setBounds(0,0,300,30);
        palkki.add(funktiosyotto);
        
        JTextField funktiosyotto2 = new JTextField();
        funktiosyotto2.setBounds(0,30,300,30);
        palkki.add(funktiosyotto2);

        JTextField funktiosyotto3 = new JTextField();
        funktiosyotto3.setBounds(0,60,300,30);
        palkki.add(funktiosyotto3);
        
        JTextField funktiosyotto4 = new JTextField();
        funktiosyotto4.setBounds(0,90,300,30);
        palkki.add(funktiosyotto4);
        
        JButton nappi = new JButton("Piirrä");
        nappi.setBounds(0,120,300,30);
        nappi.addActionListener(new PiirtonapinKuuntelija(funktiohallinta, funktiosyotto, funktiosyotto2, funktiosyotto3, funktiosyotto4, kuvaajanalusta));
        palkki.add(nappi);
        
        container.add(palkki);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}