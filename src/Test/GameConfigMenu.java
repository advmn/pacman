package Test;

import javax.swing.*;
import java.awt.*;

public class GameConfigMenu extends JFrame {
    private JTextField widthField;
    private JTextField heightField;
    private JButton startGameButton;

    public GameConfigMenu() {
        setTitle("Game Config");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        startGameButton = createButton("Start Game");
        startGameButton.addActionListener(e -> {
            Main main = new Main();
            main.run();
            dispose();
        });

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(createLabel("Width:"));
        widthField = createTextField();
        inputPanel.add(widthField);
        inputPanel.add(createLabel("Height:"));
        heightField = createTextField();
        inputPanel.add(heightField);
        inputPanel.setBackground(Color.BLACK);

        add(inputPanel, BorderLayout.CENTER);
        add(startGameButton, BorderLayout.SOUTH);
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

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.YELLOW);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        return textField;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.YELLOW);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        return label;
    }
}

