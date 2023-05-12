package Menu;

import model.ModelPlanszy;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.stream.IntStream;

public class Plansza extends JTable {

    private ModelPlanszy modelPlanszy;

    private final int wiersze;
    private final int kolumny;

    public Plansza(int szerokosc, int wysokosc) {
        this.wiersze = wysokosc;
        this.kolumny = szerokosc;
        modelPlanszy = new ModelPlanszy(szerokosc, wysokosc);
        setModel(modelPlanszy);

        setShowGrid(true);
        setGridColor(Color.BLUE);
//        setIntercellSpacing(new Dimension(0, 0));
        setTableHeader(null);


        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(Color.GREEN);
                return c;
            }
        });
        setRowHeight(10);
        ustawSzerokoscKolumn();
        setBounds(0,0, kolumny*10, wiersze*10);
        setVisible(true);
    }

    private void ustawSzerokoscKolumn() {
        IntStream.of(kolumny - 1).forEach(indeks -> {
            getColumnModel().getColumn(indeks).setMaxWidth(10);
        });
    }
}

