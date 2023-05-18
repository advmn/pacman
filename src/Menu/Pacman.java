package Menu;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;

public class Pacman extends ImageIcon {

    private int wiersz;
    private int kolumna;

    public Pacman(File image, int wiersz, int kolumna) throws MalformedURLException {
        super(image.toURL());
        this.wiersz = wiersz;
        this.kolumna = kolumna;
    }

    public int getWiersz() {
        return wiersz;
    }

    public int getKolumna() {
        return kolumna;
    }

    public void setWiersz(int wiersz) {
        this.wiersz = wiersz;
    }

    public void setKolumna(int kolumna) {
        this.kolumna = kolumna;
    }
}

