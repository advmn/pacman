package Menu;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MenuRozmiaru {
    private JFrame oknoWyboruRozmiaru;
    private JLabel etykietaWierszy;
    private JTextField poleWierszy;
    private JLabel etykietaKolumn;
    private JTextField poleKolumn;
    private JButton przyciskStart;
    private Dimension screenSize;

    MenuRozmiaru(JFrame ramka, Color kolorTla, Color kolorTekstu, Font czcionka){
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ramka.setVisible(false);
        this.oknoWyboruRozmiaru = new JFrame("Nowa Gra");
        oknoWyboruRozmiaru.setSize(300, 300);
        oknoWyboruRozmiaru.setBounds((screenSize.width - oknoWyboruRozmiaru.getWidth()) / 2, (screenSize.height - oknoWyboruRozmiaru.getHeight()) / 2, oknoWyboruRozmiaru.getWidth(), oknoWyboruRozmiaru.getHeight());
        oknoWyboruRozmiaru.getContentPane().setBackground(kolorTla);
        oknoWyboruRozmiaru.setLayout(new GridLayout(3, 1));

        this.etykietaWierszy = new JLabel("\tWierszy:");
        etykietaWierszy.setFont(czcionka);
        etykietaWierszy.setForeground(kolorTekstu);

        this.poleWierszy = new JTextField();
        poleWierszy.setFont(czcionka);

        this.etykietaKolumn = new JLabel("\tKolumn:");
        etykietaKolumn.setFont(czcionka);
        etykietaKolumn.setForeground(kolorTekstu);

        this.poleKolumn = new JTextField();
        poleKolumn.setFont(czcionka);

        this.przyciskStart = new JButton("\tStart\t");
        przyciskStart.setFont(czcionka);
        przyciskStart.setBackground(kolorTla);
        przyciskStart.setForeground(kolorTekstu);

        oknoWyboruRozmiaru.add(etykietaWierszy);
        oknoWyboruRozmiaru.add(poleWierszy);
        oknoWyboruRozmiaru.add(etykietaKolumn);
        oknoWyboruRozmiaru.add(poleKolumn);
        oknoWyboruRozmiaru.add(przyciskStart);

        oknoWyboruRozmiaru.setVisible(true);

        przyciskStart.addActionListener(e1 -> {
            try {
                Gra gra = new Gra(poleWierszy, poleKolumn, oknoWyboruRozmiaru);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
