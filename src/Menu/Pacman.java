package Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pacman extends JPanel implements KeyListener {

    private int x;
    private int y;
    private final int width;
    private final int height;

    private DefaultTableModel modelTabeli;

    public Pacman(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBounds(x, y, width, height);
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int step = 3;
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP -> y -= step;
            case KeyEvent.VK_DOWN -> y += step;
            case KeyEvent.VK_LEFT -> x -= step;
            case KeyEvent.VK_RIGHT -> x += step;
        }
        setBounds(x, y, width, height);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {


    }



    }

