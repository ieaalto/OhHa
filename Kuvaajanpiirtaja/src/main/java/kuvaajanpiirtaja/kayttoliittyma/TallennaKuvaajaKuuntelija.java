/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 * Tallentaa kuvaajan kuvatiedostoon.
 * @author Iiro
 */
public class TallennaKuvaajaKuuntelija implements ActionListener{
    
    private KuvaajanAlusta kuvaajanalusta;
    private JTextField virhekentta;
    
    public TallennaKuvaajaKuuntelija(KuvaajanAlusta kuvaajanalusta, JTextField virhekentta){
        this.kuvaajanalusta = kuvaajanalusta;
        this.virhekentta = virhekentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BufferedImage kuva = luoKuva();
        JFileChooser tallennusikkuna = new JFileChooser();
        tallennusikkuna.addActionListener(new TallennusikkunanKuuntelija(tallennusikkuna, kuva, virhekentta));
        tallennusikkuna.addChoosableFileFilter(new PngFilter());
        tallennusikkuna.showSaveDialog(kuvaajanalusta);

    }
    
    /**
     * Luo BufferedImage-olion ja piirtää kuvaajanalusta sisällön siihen.
     * @return Piirretty kuva.
     */
    private BufferedImage luoKuva(){
        BufferedImage kuva = new BufferedImage(600,600,BufferedImage.TYPE_INT_RGB);
        Graphics g = kuva.createGraphics();
        kuvaajanalusta.paintComponent(g);       
        return kuva;
    }
    
    
}
