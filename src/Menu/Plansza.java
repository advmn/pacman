package Menu;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Plansza extends JFrame {
    private JTable tabela;

    public Plansza(int szerokosc, int wysokosc) {
        tabela = new JTable(wysokosc, szerokosc);
        getContentPane().add(new JScrollPane(tabela), BorderLayout.CENTER);
        tabela.setShowGrid(true);
        tabela.setGridColor(Color.BLACK);
        tabela.setIntercellSpacing(new Dimension(0, 0));
        tabela.setTableHeader(null);


        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(Color.BLACK);
                return c;
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);

    }
}

