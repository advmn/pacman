package Test;


import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public void run() {
        SwingUtilities.invokeLater(() -> {
            int rows = 20;
            int cols = 20;

            GameModel model = new GameModel(rows, cols);
            GameView view = new GameView(model);

            JFrame frame = new JFrame("Pacman");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(view);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            model.movePacman(0, -1);
                            break;
                        case KeyEvent.VK_DOWN:
                            model.movePacman(0, 1);
                            break;
                        case KeyEvent.VK_LEFT:
                            model.movePacman(-1, 0);
                            break;
                        case KeyEvent.VK_RIGHT:
                            model.movePacman(1, 0);
                            break;
                    }
                    if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
                        System.exit(0);
                    }
                }
            });
            frame.setFocusable(true);
        });
    }
}
