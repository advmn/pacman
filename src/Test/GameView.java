package Test;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class GameView extends JPanel {
    private JTable table;
    private GameModel model;
    private JScrollPane scrollPane;

    public GameView(GameModel model) {
        this.model = model;
        setLayout(new BorderLayout());

        table = new JTable(model);
        int cellSize = 16;
        table.setRowHeight(cellSize);
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(cellSize);
        }
        table.setFillsViewportHeight(true);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setTableHeader(null);

        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Set the preferred size of scrollPane according to the total size of the table
        scrollPane.setPreferredSize(new Dimension(cellSize * model.getColumnCount(), cellSize * model.getRowCount()));

        // Custom cell rendering to display different colors for walls, Pacman, and empty cells
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                int cellValue = (int) model.getValueAt(row, col);
                switch (cellValue) {
                    case 0:
                        setBackground(Color.BLACK);
                        setForeground(Color.BLACK); // Set font color same as background
                        break;
                    case 1:
                        setBackground(Color.YELLOW);
                        setForeground(Color.YELLOW); // Set font color same as background
                        break;
                    case 2:
                        setBackground(Color.BLUE);
                        setForeground(Color.BLUE); // Set font color same as background
                        break;
                    case 3:
                        setBackground(Color.GREEN);
                        setForeground(Color.GREEN); // Set font color same as background
                        break;
                    case 4:
                        setBackground(Color.PINK);
                        setForeground(Color.PINK); // Set font color same as background
                        break;
                    case 5:
                        setBackground(Color.WHITE);
                        setForeground(Color.WHITE); // Set font color same as background
                        break;
                    case 6:
                        setBackground(Color.WHITE);
                        setForeground(Color.WHITE);

                    default:
                        setBackground(table.getBackground());
                        break;
                }
                return this;
            }
        });
    }

    public void updateView() {
        table.repaint();
    }
}



