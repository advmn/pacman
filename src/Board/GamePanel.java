package Board;

import Board.GameModel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GameModel gameModel;
    private JTable gameTable;
    private JLabel scoreLabel;

    public GamePanel() {
        gameModel = new GameModel(10, 10);
        gameTable = new JTable(gameModel);
        scoreLabel = new JLabel("Points: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(scoreLabel, BorderLayout.NORTH);
        add(new JScrollPane(gameTable), BorderLayout.CENTER);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Points: " + score);
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}
