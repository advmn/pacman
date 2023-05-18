package model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ModelPlanszy extends AbstractTableModel {

    ImageIcon[][] rows;
    private int wiersze;
    private int kolumny;

    public ModelPlanszy(int wiersze, int kolumny) {
        rows = new ImageIcon[wiersze][kolumny];
        this.wiersze = wiersze;
        this.kolumny = kolumny;
    }

    @Override
    public int getRowCount() {
        return wiersze;
    }

    @Override
    public int getColumnCount() {
        return kolumny;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return rows[i][i1];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        rows[rowIndex][columnIndex] = (ImageIcon) aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return ImageIcon.class;
    }
}
