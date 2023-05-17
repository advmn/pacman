package Test;

import Test.Main;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JButton startGameButton;
    private JButton highScoresButton;
    private JButton exitButton;

    public MainMenu() {
        setTitle("Pacman Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startGameButton = createButton("Start Game");
        highScoresButton = createButton("High Scores");
        exitButton = createButton("Exit");

        startGameButton.addActionListener(e -> {
            Main main = new Main();
            main.run();
            dispose();
        });

        highScoresButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "High Scores"));

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
        button.setFont(new Font("Arial", Font.BOLD, 18));
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

