package kuvaajanpiirtaja.kayttoliittyma;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import kuvaajanpiirtaja.logiikka.Piste;

/**
 * Piirtää annettuja pisteitä pitkin kulkevan jatkuvan käyrän. 
 * 
 */
public class PisteitaSeuraavaKayra {
    
    private ArrayList<Piste> pisteet;

    
    public PisteitaSeuraavaKayra(ArrayList<Piste> pisteet){
        this.pisteet = pisteet;
    }
    
    /**
     * Piirtää jatkuvan käyrän konstruktorin parametrina annettujen pisteiden läpi.
     * @param g Graphics-olio
     */
    public void piirra(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        if(pisteet.size() > 3){   
            pisteet.add(0, null);
            pisteet.add(null);
            for(int i = 1; i < pisteet.size()-2; i++){
                Piste kontrollipiste;
                try{
                    kontrollipiste = laskeKontrollipiste(pisteet.get(i-1), pisteet.get(i),pisteet.get(i+1),pisteet.get(i+2));
                } catch (Exception e){
                    continue;
                }                
                QuadCurve2D kayra = new QuadCurve2D.Double();
                Piste a = pisteet.get(i);
                Piste b = pisteet.get(i+1);
                kayra.setCurve(a.x(),a.y(),kontrollipiste.x(),kontrollipiste.y(),b.x(),b.y());
                g2D.draw(kayra);            
            }
        }
    }
    
    
    private Piste laskeKontrollipiste(Piste a, Piste b, Piste c, Piste d) throws NullPointerException{
        double[] ab;
        double[]cd;
        if (a == null){
            ab = laskeTangentti(b, ((double)c.y()-(double)b.y())/((double)c.x()-(double)b.x()));
        } else { ab = laskeTangentti(b, laskeKasvunopeus(a,b,c));
        } if (d == null){
            cd = laskeTangentti(c, ((double)c.y()-(double)b.y())/((double)c.x()-(double)b.x()));
        } else { cd = laskeTangentti(c, laskeKasvunopeus(b,c,d)); }
        Piste kpiste = laskeTangenttienLeikkaus(cd, ab);
        if(kpiste == null){
            return new Piste((int)((b.x()+c.x())/2),(int)((b.y()+c.y())/2));
        }
        return kpiste;
    }
    
    
    private double  laskeKasvunopeus(Piste a, Piste b, Piste c){
        double nopeusAB = ((double)b.y()-(double)a.y())/((double)b.x()-(double)a.x());        
        double nopeusBC = ((double)c.y()-(double)b.y())/((double)c.x()-(double)b.x());
        return (double)(nopeusAB + nopeusBC)/2;
    }
    
    
    private double[] laskeTangentti(Piste a, double kerroin){
        double yynleikkaus = (double)a.y() - (double)a.x()*kerroin;
        return new double[]{kerroin,yynleikkaus};
    }
    
    
    private Piste laskeTangenttienLeikkaus(double[] a, double[] b){
        if(a[0] != b[0]){
            double leikkauksenX = (double)((double)b[1]-(double)a[1])/((double)a[0]-(double)b[0]);
            double leikkauksenY = ((double)b[0]*leikkauksenX+(double)b[1]);
        
            return new Piste((int)leikkauksenX,(int)leikkauksenY);
        } 
        return null;
    }
}
