package Test2;

import javax.swing.table.AbstractTableModel;


public class MyMapaGryModel extends AbstractTableModel {
    private int[][] data;
    public MyMapaGryModel(int hight, int width) {
        data = new int[hight][width];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = (int)aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}