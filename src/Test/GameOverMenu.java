package Test;

import javax.swing.*;
import java.awt.*;

public class GameOverMenu extends JFrame {
    private JButton retryButton;
    private JLabel gameOverLabel;
    private JLabel scoreLabel;

    public GameOverMenu(int points) {
        setTitle("Pacman Game");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        gameOverLabel = createLabel("Game Over");
        scoreLabel = createLabel("Score: " + points);
        retryButton = createButton("Try Again");

        retryButton.addActionListener(e -> {
            Main main = new Main();
            main.run();
            dispose();
        });

        setLayout(new BorderLayout());

        add(gameOverLabel, BorderLayout.NORTH);
        add(scoreLabel, BorderLayout.CENTER);
        add(retryButton, BorderLayout.SOUTH);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setFocusPainted(false);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        return button;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Color.YELLOW);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        return label;
    }
}
