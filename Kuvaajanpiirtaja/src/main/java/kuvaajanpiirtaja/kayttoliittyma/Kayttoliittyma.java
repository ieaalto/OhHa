
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        frame = new JFrame("Kuvaajanpiirtäjä");
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
        
        JLabel funktiotLabel = new JLabel(" Funktiot", JLabel.LEADING);
        funktiotLabel.setBounds(0, 0, 300, 30);
        palkki.add(funktiotLabel);
        
        JTextField funktiosyotto = new JTextField("x^3");
        funktiosyotto.setBounds(25,30,300,30);
        palkki.add(funktiosyotto);
        
        JLabel f1 = new JLabel("  f1:", JLabel.LEADING);
        f1.setBounds(0, 30, 300, 30);
        palkki.add(f1);
        
        JTextField funktiosyotto2 = new JTextField();
        funktiosyotto2.setBounds(25,60,300,30);
        palkki.add(funktiosyotto2);
        
        JLabel f2 = new JLabel("  f2:", JLabel.LEADING);
        f2.setBounds(0, 60, 300, 30);
        palkki.add(f2);

        JTextField funktiosyotto3 = new JTextField();
        funktiosyotto3.setBounds(25,90,300,30);
        palkki.add(funktiosyotto3);
        
        JLabel f3 = new JLabel("  f3:", JLabel.LEADING);
        f3.setBounds(0, 90, 300, 30);
        palkki.add(f3);
        
        JTextField funktiosyotto4 = new JTextField();
        funktiosyotto4.setBounds(25,120,300,30);
        palkki.add(funktiosyotto4);
        
        JLabel f4 = new JLabel("  f4:", JLabel.LEADING);
        f4.setBounds(0, 120, 300, 30);
        palkki.add(f4);
        
        JButton nappiPiirra = new JButton("Piirrä");
        nappiPiirra.setBounds(0,150,300,30);
        nappiPiirra.addActionListener(new PiirtonapinKuuntelija(funktiohallinta, funktiosyotto, funktiosyotto2, funktiosyotto3, funktiosyotto4, kuvaajanalusta));
        palkki.add(nappiPiirra);
        
        JLabel laskinLabel = new JLabel(" Laskin",JLabel.LEADING);
        laskinLabel.setBounds(0,210,300,30);
        palkki.add(laskinLabel);
        
        JTextField laskimenSyotto = new JTextField();
        laskimenSyotto.setBounds(0,240,300,30);
        palkki.add(laskimenSyotto);
        
        
        JTextField laskimenPalautus = new JTextField();
        laskimenPalautus.setBounds(0,270,300,30);
        laskimenPalautus.setEditable(false);
        palkki.add(laskimenPalautus);
        
        JButton nappiLaske = new JButton("Laske");
        nappiLaske.setBounds(0,300,300,30);
        nappiLaske.addActionListener(new LaskunapinKuuntelija(funktiohallinta, laskimenSyotto, laskimenPalautus));
        palkki.add(nappiLaske);
        
        container.add(palkki);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}