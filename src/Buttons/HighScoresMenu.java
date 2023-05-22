package Buttons;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HighScoresMenu extends JFrame {
    public HighScoresMenu() {
        setTitle("High Scores");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        ArrayList<String> highScores = loadHighScores();

        JTextArea highScoresArea = new JTextArea();
        highScoresArea.setFont(new Font("Arial", Font.BOLD, 24));
        highScoresArea.setEditable(false);
        highScoresArea.setForeground(Color.YELLOW);
        highScoresArea.setBackground(Color.BLACK);

        for (String score : highScores) {
            highScoresArea.append(score + "\n");
        }

        JButton backButton = createButton();

        backButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            dispose();
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(highScoresArea), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    private JButton createButton() {
        JButton button = new JButton("Back");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setFocusPainted(false);
        return button;
    }

    private ArrayList<String> loadHighScores() {
        ArrayList<String> highScores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                highScores.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return highScores;
    }
}
