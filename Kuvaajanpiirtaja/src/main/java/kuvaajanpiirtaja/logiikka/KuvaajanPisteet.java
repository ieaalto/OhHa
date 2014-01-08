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
     * Laskee funktion pisteet välillä minX-maxX. Mikäli funktio ei ole jatkuva, palauttaa useamman listan. Ääriarvot aproksimoidaan.
     * @param funktio
     * @param minX
     * @param maxX
     * @param kerroinY x:n arvot kerrotaan tällä.
     * @param kerroinX y:n arvot kerrotaan tällä.
     * @param askel laskettavien pisteiden x-arvon erotus. Esim. jos askel on 0.5, lasketaan väliltä 0...1 pisteet kohdista 0.0, 0.5 ja 1.0. 
     */
    public ArrayList<ArrayList<Piste>> laskePisteet(Funktio funktio ,double minX, double maxX, int kerroinY, int kerroinX ,double askel){
        int virheet = 1;
        ArrayList<ArrayList<Piste>> listat = new ArrayList<>();
        ArrayList<Piste> pisteet = new ArrayList<>();
        if(askel > 0 && minX < maxX && kerroinX > 0 && kerroinY > 0){
            for(int x = (int) minX*100; x <= maxX*100; x += askel*100){
                if(virheet >= 2){
                    listat.add(pisteet);
                    pisteet = new ArrayList<>();
                    virheet = 0;
                    lisaaPieninMaariteltyPiste(funktio, x, askel, kerroinX, kerroinY, pisteet);
                }
                try{
                    int a = (int)(((double)x/100)*kerroinX+300);
                    int b = (int)(-funktio.laskeY(((double)x/100))*kerroinY+300);
                    pisteet.add(new Piste(a,b));
                } catch(Exception e){        
                    lisaaSuurinMaariteltyPiste(pisteet, funktio, x, askel, kerroinX, kerroinY);
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

    private ArrayList<ArrayList<Piste>> poistaTurhat(ArrayList<ArrayList<Piste>> listat) {
        ArrayList<ArrayList<Piste>> palautus = new ArrayList<>();
        for(ArrayList<Piste> lista : listat){
            if(lista.size() > 3) {
                palautus.add(lista);
            }
        }
        return palautus;
    }
    
    private int haeMaariteltyArvo(Funktio funktio, int x,int askel, int paras, int suunta){
        int vahennys = askel/2;
        for(int i = 1; i < 10; i++){            
            try{                
                funktio.laskeY((double)x/100);
                paras = x;
                vahennys /= 2;
                x+= suunta*vahennys;
            } catch(Exception e){
                vahennys /= 2;
                x -= suunta*vahennys;
            } 
            
        }
        return paras;
    }
    

    private void lisaaSuurinMaariteltyPiste(ArrayList<Piste> pisteet, Funktio funktio, int x, double askel, int kerroinX, int kerroinY) throws NumberFormatException {
        if(!pisteet.isEmpty()){
            int suurinMaaritelty = haeMaariteltyArvo(funktio, x , (int)(askel*100), x - (int)(askel*100),1);
            if(suurinMaaritelty > x-askel*100){
                try{
                    int a = (int)(((double)suurinMaaritelty/100)*kerroinX+300);
                    int b = (int)(-funktio.laskeY(((double)suurinMaaritelty/100))*kerroinY+300);
                    pisteet.add(new Piste(a,b));
                }catch(Exception e){
                    return;
                }
            }
        }
    }

    private void lisaaPieninMaariteltyPiste(Funktio funktio, int x, double askel, int kerroinX, int kerroinY, ArrayList<Piste> pisteet) throws NumberFormatException {
        int pieninMaaritelty = haeMaariteltyArvo(funktio, x , (int)(askel*100),x,-1);
        if(pieninMaaritelty < x){
            try{
                int a = (int)(((double)pieninMaaritelty/100)*kerroinX+300);
                int b = (int)(-funktio.laskeY(((double)pieninMaaritelty/100))*kerroinY+300);
                pisteet.add(new Piste(a,b)); 
            } catch(Exception e){
                return;
            }    
        }
    }
    
    
}
