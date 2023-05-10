package Menu;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Pacman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);


        frame.setLayout(new GridLayout(3, 1));


        JButton newGameButton = new JButton("New Game");
        JButton highScoresButton = new JButton("High Scores");
        JButton exitButton = new JButton("Exit");


        newGameButton.addActionListener(e -> {
            JFrame newGameFrame = new JFrame("New Game");
            newGameFrame.setSize(300, 300);
            newGameFrame.setVisible(true);
        });

        highScoresButton.addActionListener(e -> {
            JFrame highScoresFrame = new JFrame("High Scores");
            highScoresFrame.setSize(300, 300);
            highScoresFrame.setVisible(true);
        });

        exitButton.addActionListener(e -> System.exit(0));


        frame.add(newGameButton);
        frame.add(highScoresButton);
        frame.add(exitButton);


        frame.setVisible(true);
    }
}
