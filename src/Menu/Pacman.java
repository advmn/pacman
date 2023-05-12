package Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;

public class Pacman extends ImageIcon implements KeyListener {

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

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

//    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int step = 3;
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP -> kolumna -= step;
            case KeyEvent.VK_DOWN -> kolumna += step;
            case KeyEvent.VK_LEFT -> wiersz -= step;
            case KeyEvent.VK_RIGHT -> wiersz += step;
        }
//        setBounds(wiersz, kolumna, width, height);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {


    }



    }

