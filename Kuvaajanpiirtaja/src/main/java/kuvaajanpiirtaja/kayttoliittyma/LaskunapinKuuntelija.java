/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import kuvaajanpiirtaja.logiikka.Funktiohallinta;
import kuvaajanpiirtaja.logiikka.Laskin;

/**
 * ActionListener laske-painikkeelle. Laskee syotteen arvon Laskin-luokan avulla.
 * @author Iiro
 */
public class LaskunapinKuuntelija implements ActionListener {
    private Laskin laskin;
    private JTextField syotto;
    private JTextField palautus;
    private Funktionsyotteet syotteet;

    public LaskunapinKuuntelija(Funktiohallinta funktiohallinta, JTextField syotto, JTextField palautus, Funktionsyotteet syotteet) {
        this.syotto = syotto;
        this.palautus = palautus;
        laskin = new Laskin(funktiohallinta);
        this.syotteet = syotteet;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        syotteet.lueSyotteet();
        try{
            double laskettu = laskin.laskeLauseke(syotto.getText());
            palautus.setText(String.valueOf(laskettu));
        }catch(Exception ex){
            palautus.setText("-");
        }
    }
    
}
