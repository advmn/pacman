package Test2;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapaGry extends JTable implements TableCellRenderer{
    OknoGry oknoGry;
    JPanel mapPanel = new JPanel(new GridBagLayout());
    JPanel scoresPanel = new JPanel();
    JPanel leftSidePanel = new JPanel();
    JPanel rightSidePanel = new JPanel();
    JPanel wholeWindowPanel = new JPanel(new BorderLayout());
    KeyHandler keyHandler = new KeyHandler();
    MyMapaGryModel myMapaGryModel;
    BufferedImage sciana,sciana2, coin,wall; //pacMan;
    Thread pacMan;
    private ImageIcon WALL_ICON = new ImageIcon("D:\\MATMA CIEZKA\\STUDNIA MATERIALY ROK DRUGI\\Gui\\ZADANIA DANCZAK\\MAPAjTable\\src\\Obrazy\\Wall2.png");
    private ImageIcon PACMAN_ICON = new ImageIcon("D:\\MATMA CIEZKA\\STUDNIA MATERIALY ROK DRUGI\\Gui\\ZADANIA DANCZAK\\MAPAjTable\\src\\Obrazy\\PSM_DOWN.png");
    private ImageIcon COIN_ICON = new ImageIcon("D:\\MATMA CIEZKA\\STUDNIA MATERIALY ROK DRUGI\\Gui\\ZADANIA DANCZAK\\MAPAjTable\\src\\Obrazy\\Coin.png");
    public MapaGry(OknoGry oknoGry){
        this.oknoGry = oknoGry;
        myMapaGryModel = new MyMapaGryModel(20,20);
        generateMapa();
        generateMapFields();
        setDefaultRenderer(Object.class, this);
        addKeyListener(keyHandler);
        pacMan = new Thread(new PacMan(keyHandler, this));
        pacMan.start();
        mapPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                leftSidePanel.setPreferredSize(new Dimension(oknoGry.getWidth()/4, oknoGry.getHeight()));
                rightSidePanel.setPreferredSize(new Dimension(oknoGry.getWidth()/4, oknoGry.getHeight()));
                scale();
            }
        });
    }


    public void generateMapa(){

        setModel(myMapaGryModel);
        setOpaque(false);
        setFocusable(true);
        setRowSelectionAllowed(false);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        Dimension dimension = new Dimension(oknoGry.getWidth()/5, oknoGry.getHeight());
        leftSidePanel.setBackground(Color.yellow);
        leftSidePanel.setPreferredSize(dimension);
        rightSidePanel.setBackground(Color.GREEN);
        rightSidePanel.setPreferredSize(dimension);
        mapPanel.setBackground(Color.BLACK);
        scoresPanel.setBackground(Color.PINK);
        mapPanel.add(this, new GridBagConstraints());
        wholeWindowPanel.add(scoresPanel, BorderLayout.PAGE_START);
        wholeWindowPanel.add(mapPanel, BorderLayout.CENTER);
        wholeWindowPanel.add(leftSidePanel, BorderLayout.LINE_START);
        wholeWindowPanel.add(rightSidePanel, BorderLayout.LINE_END);
        oknoGry.getContentPane().add(wholeWindowPanel, BorderLayout.CENTER);
    }

    private void generateMapFields(){
        for(int i = 0; i<getRowCount(); i++){
            for(int j = 0; j<getColumnCount(); j++){
                if((((i%2==0 && i!=getRowCount()-2) || i==getRowCount()-1) && j<getColumnCount()) || (i<getRowCount() && (j==0 || j==getColumnCount()-1))) {
                    setValueAt(1, i, j);
                }
            }
        }
        double czyWstawiamyBlok = 0;
        int wallCounter = 0;
        for (int wiersz = 1; wiersz < getRowCount() - 1; wiersz++) {
            for (int kolumna = 2; kolumna < getColumnCount() - 2 && wallCounter < getColumnCount() / 3; kolumna++) {
                if (wiersz % 2 == 1 && wiersz < getRowCount() - 2) {
                    czyWstawiamyBlok = Math.random();
                    if (czyWstawiamyBlok < 0.5 && (int) getValueAt(wiersz, kolumna + 1) != 1 && (int) getValueAt(wiersz, kolumna - 1) != 1) {
                        setValueAt(1, wiersz, kolumna);
                        setValueAt(0, wiersz + 1, kolumna - 1);
                        setValueAt(0, wiersz + 1, kolumna + 1);
                        wallCounter++;
                        if (wiersz != 1 && kolumna + 1 < getColumnCount() - 1 && (int) getValueAt(wiersz - 1, kolumna - 1) == 1 && (int) getValueAt(wiersz - 1, kolumna + 1) == 1 && (int) getValueAt(wiersz, kolumna) == 1 && (int) getValueAt(wiersz - 1, kolumna) == 0) {
                            setValueAt(0, wiersz, kolumna);
                            setValueAt(0, wiersz - 1, kolumna - 1);
                            setValueAt(0, wiersz - 1, kolumna + 1);
                            setValueAt(1, wiersz + 1, kolumna - 1);
                            setValueAt(1, wiersz + 1, kolumna + 1);
                        }
                        kolumna+=2;
                    }
                }
                if (kolumna >= getColumnCount() - 2 && wallCounter>1){
                    kolumna = 2;
                }
            }
            wallCounter = 0;
        }
        for(int i = 1; i<getRowCount()-1; i++){
            for(int j = 1; j<getColumnCount()-1; j++){
                if((i==1 || i==getRowCount()-2) && j<=getColumnCount()-1 || (j==1 || j==getColumnCount()-2) && i<=getRowCount()-1){
                    setValueAt(0, i, j);
                }
            }
        }
        uploadCoinFields();
    }

    public void uploadCoinFields(){
        for(int i = 0; i<getRowCount(); i++) {
            for (int j = 0; j < getColumnCount(); j++) {
                if ((int) getValueAt(i, j) == 0) {
                    setValueAt(2, i, j);
                }
            }
        }
    }
    public void uploadImages(){
        try {
            sciana = ImageIO.read(getClass().getResourceAsStream(""));
            sciana2 = ImageIO.read(getClass().getResourceAsStream(""));
            wall = ImageIO.read(getClass().getResourceAsStream(""));
            coin = ImageIO.read(getClass().getResourceAsStream(""));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void scale(){
        System.out.println("SCALE");
        int width = mapPanel.getWidth();
        int height = mapPanel.getHeight();
        int numRows = myMapaGryModel.getRowCount();
        int numCols = myMapaGryModel.getColumnCount();
        int tileSize = Math.min(width / numCols, height / numRows);
        for (int i = 0; i < numCols; i++) {
            getColumnModel().getColumn(i).setMinWidth(1);
            getColumnModel().getColumn(i).setPreferredWidth(tileSize);
        }
        setRowHeight(tileSize);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int intValue = (int) value;
        switch (intValue) {
            case 1:
                Image wimg = WALL_ICON.getImage().getScaledInstance(tileSize(),tileSize(),Image.SCALE_SMOOTH);
                return new JLabel(new ImageIcon(wimg));
            case 5:
                Image pimg = PACMAN_ICON.getImage().getScaledInstance(tileSize(),tileSize(),Image.SCALE_SMOOTH);
                return new JLabel(new ImageIcon(pimg));
            case 2:
                Image cimg = COIN_ICON.getImage().getScaledInstance(tileSize() * 3 / 4, tileSize() * 3 / 4, Image.SCALE_SMOOTH);
                return new JLabel(new ImageIcon(cimg));
            default:
                return new JLabel();
        }
    }

    private int tileSize(){
        int width = getWidth();
        int height = getHeight();
        int min = width > height ? height : width;
        int max = myMapaGryModel.getRowCount()<myMapaGryModel.getColumnCount()? myMapaGryModel.getRowCount():myMapaGryModel.getColumnCount();
        if( min/max>=2)
            return min/max;
        else return 2;
    }

}