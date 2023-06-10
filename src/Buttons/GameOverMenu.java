package Buttons;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class GameOverMenu extends JFrame {
    private int score;

    public GameOverMenu(int score) {
        this.score = score;

        setTitle("Game Over");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel scoreLabel = new JLabel("Your score: " + score);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(Color.YELLOW);

        JTextField nameField = new JTextField("Enter your name");
        nameField.setFont(new Font("Arial", Font.BOLD, 18));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setForeground(Color.YELLOW);
        nameField.setBackground(Color.BLACK);

        JButton saveScoreButton = new JButton("Save Score");
        saveScoreButton.setFont(new Font("Arial", Font.BOLD, 24));
        saveScoreButton.setFocusPainted(false);
        saveScoreButton.setBackground(Color.BLACK);
        saveScoreButton.setForeground(Color.YELLOW);
        saveScoreButton.addActionListener(e -> {
            saveScoreToFile(nameField.getText(), score);
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            dispose();
        });

        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        add(scoreLabel, BorderLayout.NORTH);
        add(nameField, BorderLayout.CENTER);
        add(saveScoreButton, BorderLayout.SOUTH);
    }

    private void saveScoreToFile(String playerName, int score) {
        try (FileWriter writer = new FileWriter("highscores.txt", true)) {
            writer.write(playerName + ": " + score + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
