package Buttons;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JButton highScoresButton;
    private JButton exitButton;

    public MainMenu() {
        setTitle("Pacman Game");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton startGameButton = createButton("Start Game");
        highScoresButton = createButton("High Scores");
        exitButton = createButton("Exit");

        startGameButton.addActionListener(e -> {
            GameConfigMenu configMenu = new GameConfigMenu();
            configMenu.setVisible(true);
            dispose();
        });

        highScoresButton.addActionListener(e -> {
            HighScoresMenu highScoresMenu = new HighScoresMenu();
            highScoresMenu.setVisible(true);
        });

        exitButton.addActionListener(e -> System.exit(0));

        setLayout(new BorderLayout());

        add(startGameButton, BorderLayout.NORTH);
        add(highScoresButton, BorderLayout.CENTER);
        add(exitButton, BorderLayout.SOUTH);
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

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        });
    }
}
