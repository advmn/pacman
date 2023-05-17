package Test2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class OknoGry extends JFrame {

    MapaGry mapaGry;
    public OknoGry(){
        generateFrame();
        mapaGry = new MapaGry(this);
    }

    public void generateFrame(){
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(800,800));
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}