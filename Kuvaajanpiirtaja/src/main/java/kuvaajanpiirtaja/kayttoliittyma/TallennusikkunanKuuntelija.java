/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 * Tallennusikkunan ActionListener. Tallentaa parametrina annetun kuvan valittuun tiedostoon. 
 * @author Iiro
 */
public class TallennusikkunanKuuntelija implements ActionListener{

    private JFileChooser tallennusikkuna;
    private BufferedImage kuva;
    private JTextField virhekentta;
    
    public TallennusikkunanKuuntelija(JFileChooser tallennusikkuna, BufferedImage kuva, JTextField virhekentta){
        this.kuva = kuva;
        this.tallennusikkuna = tallennusikkuna;
        this.virhekentta = virhekentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        File tiedosto = tallennusikkuna.getSelectedFile();
        try{
            ImageIO.write(kuva, "png", tiedosto);
            virhekentta.setText("Kuva tallennettu!");
        } catch (Exception ex){
            virhekentta.setText("Kuvaa ei tallennettu!");
        }
    }
    
}
