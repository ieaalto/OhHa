package kuvaajanpiirtaja.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Laskee ja tallentaa pisteet, joiden mukaan kuvaaja piirretään.
 */
public class KuvaajanPisteet {
    /**
     * Laskee PisteitaSeuraavaKayra-luokan tarvitsemat funktion pisteet. 
     */
    public KuvaajanPisteet(){        
    }
    
    /**
     * Laskee funktion pisteet välillä minX-maxX. Mikäli funktio ei ole jatkuva, palauttaa useamman listan. 
     * @param funktio
     * @param minX
     * @param maxX
     * @param kerroinY x:n arvot kerrotaan tällä.
     * @param kerroinX y:n arvot kerrotaan tällä.
     * @param lisaysX x:n arvoihin lisattava kohdistusarvo, asetukset-olion laskema.
     * @param lisaysY  kuten lisaysX, y:n arvoille.
     */
    public ArrayList<ArrayList<Piste>> laskePisteet(Funktio funktio ,double minX, double maxX, double kerroinY, double kerroinX , double lisaysX,double lisaysY){
        int virheet = 0;
        ArrayList<ArrayList<Piste>> listat = new ArrayList<>();
        ArrayList<Piste> pisteet = new ArrayList<>();
        if(minX < maxX && kerroinX > 0 && kerroinY > 0){
            for(int x = -1000; x <= 1000; x += 10){
                if(virheet >= 2){
                    listat.add(pisteet);
                    pisteet = new ArrayList<>();
                    virheet = 0;
                }
                try{
                    int a = (int)(((double)(x)/100)*30+300);
                    int b = (int)(((-funktio.laskeY(((double)x*kerroinX/100)+lisaysX)+lisaysY)*kerroinY)*30+300);
                    pisteet.add(new Piste(a,b));
                } catch(Exception e){        
                    virheet++;
                    continue;
                }    
            }
            listat.add(pisteet);
            ArrayList<ArrayList<Piste>> palautus = poistaTurhat(listat);
            return palautus;
        }
        return null;
    }

    /**
     * Poistaa turhat, liian pienet tai tyhjät listat.
     * @param listat
     * @return lista hyväksytyistä listoista
     */
    private ArrayList<ArrayList<Piste>> poistaTurhat(ArrayList<ArrayList<Piste>> listat) {
        ArrayList<ArrayList<Piste>> palautus = new ArrayList<>();
        for(ArrayList<Piste> lista : listat){
            if(lista.size() > 3) {
                palautus.add(lista);
            }
        }
        return palautus;
    }

    
}
