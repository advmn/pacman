package Menu;

import model.ModelPlanszy;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.stream.IntStream;

public class Plansza extends JTable implements KeyListener {

    private ModelPlanszy modelPlanszy;

    private Pacman pacman;

    private final int wiersze;
    private final int kolumny;
    private static final int CELL_SIZE = 20;

    public Plansza(int szerokosc, int wysokosc, Pacman pacman) {
        this.wiersze = wysokosc;
        this.kolumny = szerokosc;
        this.pacman = pacman;
        modelPlanszy = new ModelPlanszy(szerokosc, wysokosc);
        setModel(modelPlanszy);

//        setShowGrid(true);
//        setGridColor(Color.BLUE);
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
        setRowHeight(CELL_SIZE);
        ustawSzerokoscKolumn();
        setBounds(0, 0, kolumny * CELL_SIZE, wiersze * CELL_SIZE);
        addKeyListener(this);
        setVisible(true);
    }

    private void ustawSzerokoscKolumn() {
        IntStream.of(kolumny - 1).forEach(indeks -> {
            getColumnModel().getColumn(indeks).setMaxWidth(CELL_SIZE);
        });
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int currentRow = pacman.getWiersz();
        int currentColumn = pacman.getKolumna();
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP -> pacman.setWiersz(pacman.getWiersz() - 1);
            case KeyEvent.VK_DOWN -> pacman.setWiersz(pacman.getWiersz() + 1);
            case KeyEvent.VK_LEFT -> pacman.setKolumna(pacman.getKolumna() - 1);
            case KeyEvent.VK_RIGHT -> pacman.setKolumna(pacman.getKolumna() + 1);
        }
        modelPlanszy.setValueAt(null, currentRow, currentColumn);
        modelPlanszy.setValueAt(pacman, pacman.getWiersz(), pacman.getKolumna());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

