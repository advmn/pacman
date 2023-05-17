package Test;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class GameTableRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int cellValue = (Integer) value;
        if (cellValue == 1) {
            setBackground(Color.YELLOW);
            setForeground(Color.YELLOW);
        } else if (cellValue == 2) {
            setBackground(Color.BLUE);
            setForeground(Color.BLUE);
        } else {
            setBackground(Color.BLACK);
            setForeground(Color.BLACK);
        }
        return this;
    }
}