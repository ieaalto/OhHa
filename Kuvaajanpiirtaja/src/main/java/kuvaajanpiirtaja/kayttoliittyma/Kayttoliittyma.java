
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
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
        frame.setPreferredSize(new Dimension(900, 640));

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
        
        JTextField virhekentta = new JTextField("");
        virhekentta.setBounds(0, 570, 300, 30);
        virhekentta.setEditable(false);
        palkki.add(virhekentta);
        
        Funktionsyotteet syotteet = new Funktionsyotteet(funktiohallinta, funktiosyotto, funktiosyotto2, funktiosyotto3, funktiosyotto4, virhekentta);
        
        JLabel f4 = new JLabel("  f4:", JLabel.LEADING);
        f4.setBounds(0, 120, 300, 30);
        palkki.add(f4);
        
        JButton nappiPiirra = new JButton("Piirrä");
        nappiPiirra.setBounds(0,150,300,30);
        nappiPiirra.addActionListener(new PiirtonapinKuuntelija(funktiohallinta, syotteet, kuvaajanalusta));
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
        nappiLaske.addActionListener(new LaskunapinKuuntelija(funktiohallinta, laskimenSyotto, laskimenPalautus, syotteet));
        palkki.add(nappiLaske);
        
        JLabel asetuksetLabel = new JLabel(" Asetukset");
        asetuksetLabel.setBounds(0,360,300,30);
        palkki.add(asetuksetLabel);
        
        JLabel minXLabel = new JLabel("MinX");
        minXLabel.setBounds(12,390,75,30);
        palkki.add(minXLabel);
        
        JSpinner minX = new JSpinner(new SpinnerNumberModel(-10.0,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0));
        minX.setBounds(60, 390, 75, 30);
        palkki.add(minX);
        
        
        JLabel maxXLabel = new JLabel("MaxX");
        maxXLabel.setBounds(147,390,75,30);
        palkki.add(maxXLabel);
        
        JSpinner maxX = new JSpinner(new SpinnerNumberModel(10.0,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0));
        maxX.setBounds(195, 390, 75, 30);
        palkki.add(maxX);
        
        JLabel minYLabel = new JLabel("MinY");
        minYLabel.setBounds(12,422,75,30);
        palkki.add(minYLabel);
        
        JSpinner minY = new JSpinner(new SpinnerNumberModel(-10.0,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0));
        minY.setBounds(60, 422, 75, 30);
        palkki.add(minY);
        
        
        JLabel maxYLabel = new JLabel("MaxY");
        maxYLabel.setBounds(147,422,75,30);
        palkki.add(maxYLabel);
        
        JSpinner maxY = new JSpinner(new SpinnerNumberModel(10.0,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0));
        maxY.setBounds(195, 422, 75, 30);
        palkki.add(maxY);
        
        JButton kaytaNappi = new JButton("Käytä");
        kaytaNappi.setBounds(0,455,300,30);
        kaytaNappi.addActionListener(new AsetusnapinKuuntelija(minX, maxX, minY, maxY, funktiohallinta, virhekentta));
        palkki.add(kaytaNappi);
        
        JButton tallennaKuvaaja = new JButton("Tallena kuvatiedostoon");
        tallennaKuvaaja.setBounds(0, 515, 300, 30);
        tallennaKuvaaja.addActionListener(new TallennaKuvaajaKuuntelija(kuvaajanalusta, virhekentta));
        palkki.add(tallennaKuvaaja);
        

        
        container.add(palkki);
        
    }

}