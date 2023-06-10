package Aesthetics;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class GameCellRenderer extends DefaultTableCellRenderer {
    private static final Color EMPTY_SPACE_COLOR = Color.WHITE;
    private static final Color WALL_COLOR = Color.BLACK;
    private static final Color PACMAN_COLOR = Color.YELLOW;
    private static final Color VISITED_COLOR = Color.PINK;
    private static final Color GHOST1_COLOR = Color.GREEN;
    private static final Color GHOST2_COLOR = Color.RED;
    private static final Color POWERUP_COLOR = Color.ORANGE;
    private static final Color DEFAULT_COLOR = Color.GRAY;

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        Integer content = (Integer) value;

        switch (content) {
            case 0 -> cell.setBackground(EMPTY_SPACE_COLOR);
            case 1 -> cell.setBackground(WALL_COLOR);
            case 2 -> cell.setBackground(PACMAN_COLOR);
            case 3 -> cell.setBackground(VISITED_COLOR);
            case 4 -> cell.setBackground(GHOST1_COLOR);
            case 5 -> cell.setBackground(GHOST2_COLOR);
            case 6 -> cell.setBackground(POWERUP_COLOR);
            default -> cell.setBackground(DEFAULT_COLOR);
        }
        return cell;
    }
}
