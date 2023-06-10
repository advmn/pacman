package Buttons;

import Main.Main;

import javax.swing.*;
import java.awt.*;

public class GameConfigMenu extends JFrame {
    private static final String FONT_NAME = "Arial";
    private static final int FONT_SIZE = 24;
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color FOREGROUND_COLOR = Color.YELLOW;

    private JTextField widthField;
    private JTextField heightField;

    public GameConfigMenu() {
        setupFrameSettings();
        createAndAddComponents();
    }

    private void setupFrameSettings() {
        setTitle("Game Config");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void createAndAddComponents() {
        JPanel inputPanel = createInputPanel();
        JButton startGameButton = createButton();
        startGameButton.addActionListener(e -> startGame());

        add(inputPanel, BorderLayout.CENTER);
        add(startGameButton, BorderLayout.SOUTH);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.setBackground(BACKGROUND_COLOR);

        inputPanel.add(createLabel("Width:"));
        widthField = createTextField();
        inputPanel.add(widthField);

        inputPanel.add(createLabel("Height:"));
        heightField = createTextField();
        inputPanel.add(heightField);

        return inputPanel;
    }

    private void startGame() {
        Main main = new Main();
        main.run();
        dispose();
    }

    private JButton createButton() {
        JButton button = new JButton("Start Game");
        button.setBackground(BACKGROUND_COLOR);
        button.setForeground(FOREGROUND_COLOR);
        button.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
        button.setFocusPainted(false);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        return button;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setBackground(BACKGROUND_COLOR);
        textField.setForeground(FOREGROUND_COLOR);
        textField.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
        return textField;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(FOREGROUND_COLOR);
        label.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
        return label;
    }
}
