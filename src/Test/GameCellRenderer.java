package Test;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

public class GameCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        Integer content = (Integer) value;

        switch (content) {
            case 0:
                cell.setBackground(Color.WHITE);
                break;
            case 1:
                cell.setBackground(Color.BLACK);
                break;
            case 2:
                cell.setBackground(Color.YELLOW);
                break;
            case 3:
                cell.setBackground(Color.PINK);
                break;
            case 4:
                cell.setBackground(Color.GREEN);
                break;
            case 5:
                cell.setBackground(Color.RED);
                break;
            case 6:
                cell.setBackground(Color.ORANGE);
                cell.setForeground(Color.ORANGE);
            default:
                cell.setBackground(Color.WHITE);
                break;
        }
        return cell;
    }
}
