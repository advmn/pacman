package Test2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ImageRenderer extends JLabel implements TableCellRenderer {
    MapaGry mapaGry;
    private ImageIcon WALL_ICON = new ImageIcon("D:\\MATMA CIEZKA\\STUDNIA MATERIALY ROK DRUGI\\Gui\\ZADANIA DANCZAK\\MAPAjTable\\src\\Obrazy\\Wall2.png");
    private ImageIcon PACMAN_ICON = new ImageIcon("D:\\MATMA CIEZKA\\STUDNIA MATERIALY ROK DRUGI\\Gui\\ZADANIA DANCZAK\\MAPAjTable\\src\\Obrazy\\PSM_DOWN.png");
    private ImageIcon COIN_ICON = new ImageIcon("D:\\MATMA CIEZKA\\STUDNIA MATERIALY ROK DRUGI\\Gui\\ZADANIA DANCZAK\\MAPAjTable\\src\\Obrazy\\Coin.png");

    public ImageRenderer(MapaGry mapaGry) {
        this.mapaGry = mapaGry;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int intValue = (int) value;
        switch (intValue) {
            case 1:
                setIcon(WALL_ICON);
                break;
            case 5:
                setIcon(PACMAN_ICON);
                break;
            case 2:
                setIcon(COIN_ICON);
                break;
            default:
                setIcon(null);
                break;
        }
        return this;
    }

}