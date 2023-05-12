package Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pacman extends JPanel implements KeyListener {

    private int wiersz;
    private int kolumna;
    private final int width;
    private final int height;

    private DefaultTableModel modelTabeli;

    public Pacman(int wiersz, int kolumna, int width, int height) {
        this.wiersz = wiersz;
        this.kolumna = kolumna;
        this.width = width;
        this.height = height;
        setBackground(Color.YELLOW);
        setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(wiersz, kolumna, width, height);
    }

    public int getX() {
        return wiersz;
    }

    public int getY() {
        return kolumna;
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int step = 3;
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP -> kolumna -= step;
            case KeyEvent.VK_DOWN -> kolumna += step;
            case KeyEvent.VK_LEFT -> wiersz -= step;
            case KeyEvent.VK_RIGHT -> wiersz += step;
        }
        setBounds(wiersz, kolumna, width, height);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {


    }



    }

