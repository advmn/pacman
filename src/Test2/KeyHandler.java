package Test2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean up, down, left, right;

    @Override
    public void keyTyped(KeyEvent e) {
        //NIE MA POTRZEBY
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            up = true;
            down = false;
            left = false;
            right = false;
        } else if (code == KeyEvent.VK_S) {
            up = false;
            down = true;
            left = false;
            right = false;
        } else if (code == KeyEvent.VK_A) {
            up = false;
            down = false;
            left = true;
            right = false;
        } else if (code == KeyEvent.VK_D) {
            up = false;
            down = false;
            left = false;
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
