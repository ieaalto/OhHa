
package kuvaajanpiirtaja.kayttoliittyma;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * FileFilter, joka sallii vain .png -tiedostot.
 * @author Iiro
 */
public class PngFilter extends FileFilter {

    @Override
    public boolean accept(File tiedosto) {
        if (tiedosto.isDirectory()){
            return true;
        } if (tiedosto.getName().endsWith(".png")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Kuvatiedosto (.png)";
    }
    
}
