package Menu;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Gra extends JFrame {
    private int liczbaWierszy;
    private int liczbaKolumn;
    private Dimension screenSize;

    Gra(JTextField poleWierszy, JTextField poleKolumn, JFrame oknoWyboruRozmiaru) throws MalformedURLException, URISyntaxException {
        setName("Gra pacman");
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        liczbaWierszy = Integer.parseInt(poleWierszy.getText());
        liczbaKolumn = Integer.parseInt(poleKolumn.getText());

        if (liczbaWierszy >= 10 && liczbaWierszy <= 100 && liczbaKolumn >= 10 && liczbaKolumn <= 100) {
            oknoWyboruRozmiaru.dispose();

            File pacmanIcon = new File(getClass().getResource("1.gif").getFile());
            Pacman pacman = new Pacman(pacmanIcon, 25, 25);
            Plansza plansza = new Plansza(liczbaKolumn, liczbaWierszy, pacman);
            plansza.setValueAt(pacman, liczbaKolumn/2, liczbaWierszy/2);

            setLayout(null);
            setBounds(0, 0, liczbaWierszy * 11, liczbaKolumn * 11);
            getContentPane().setBackground(new Color(0, 0, 0));
            add(plansza);
            setVisible(true);


        } else {
            JOptionPane.showMessageDialog(oknoWyboruRozmiaru, "Wprowadź prawidłowe wymiary (10-100).", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
