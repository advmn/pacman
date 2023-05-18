package Test;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HighScoresMenu extends JFrame {

    public HighScoresMenu() {
        setLayout(new BorderLayout());
        setTitle("High Scores");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        ArrayList<Integer> scores = new ArrayList<>();


        try {
            BufferedReader reader = new BufferedReader(new FileReader("scores.txt"));
            String line = reader.readLine();
            while (line != null) {

                String scoreStr = line.split(": ")[1];

                scores.add(Integer.parseInt(scoreStr));

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading the scores file.");
            e.printStackTrace();
        }


        scores.sort(Collections.reverseOrder());


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Integer score : scores) {
            JLabel label = new JLabel("Score: " + score);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setForeground(Color.WHITE);
            panel.add(label);
        }


        panel.setBackground(Color.BLACK);


        add(panel, BorderLayout.CENTER);
    }
}
