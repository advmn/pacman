package Menu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pacman extends JPanel implements KeyListener {

    private int x;
    private int y;

    private int step = 3;

    private final int width;

    private final int height;

    public Pacman(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBounds(x, y, width, height);
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
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                y-=step;
                break;
            case KeyEvent.VK_DOWN:
                y+=step;
                break;
            case KeyEvent.VK_LEFT:
                x-=step;
                break;
            case KeyEvent.VK_RIGHT:
                x+=step;
                break;
        }
        setBounds(x, y, width, height);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
