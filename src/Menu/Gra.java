package Menu;

import javax.swing.*;
import java.awt.*;

public class Gra extends JFrame {
    private int liczbaWierszy;
    private int liczbaKolumn;
    private Dimension screenSize;

    Gra(JTextField poleWierszy, JTextField poleKolumn, JFrame oknoWyboruRozmiaru) {
        setName("Gra pacman");
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        liczbaWierszy = Integer.parseInt(poleWierszy.getText());
        liczbaKolumn = Integer.parseInt(poleKolumn.getText());

        if (liczbaWierszy >= 10 && liczbaWierszy <= 100 && liczbaKolumn >= 10 && liczbaKolumn <= 100) {
            oknoWyboruRozmiaru.dispose();

            Pacman pacman = new Pacman(50, 50, 10, 10);
            Plansza plansza = new Plansza(liczbaKolumn, liczbaWierszy);
            plansza.setValueAt(pacman, liczbaWierszy / 2, liczbaKolumn / 2);

            setLayout(null);
            setBounds(0, 0, liczbaWierszy*11, liczbaKolumn*11);
            getContentPane().setBackground(new Color(0, 0, 0));
            add(plansza);
//            oknoGry.addKeyListener(pacman);
            setVisible(true);


        } else {
            JOptionPane.showMessageDialog(oknoWyboruRozmiaru, "Wprowadź prawidłowe wymiary (10-100).", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
