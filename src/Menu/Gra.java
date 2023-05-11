package Menu;

import javax.swing.*;
import java.awt.*;

public class Gra extends JTable{
    private int liczbaWierszy;
    private int liczbaKolumn;
    private Dimension screenSize;
    private JFrame oknoGry;

    Gra(JTextField poleWierszy, JTextField poleKolumn, JFrame oknoWyboruRozmiaru){
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        liczbaWierszy = Integer.parseInt(poleWierszy.getText());
        liczbaKolumn = Integer.parseInt(poleKolumn.getText());

        if (liczbaWierszy >= 10 && liczbaWierszy <= 100 && liczbaKolumn >= 10 && liczbaKolumn <= 100) {
            oknoWyboruRozmiaru.dispose();

            Pacman pacman = new Pacman(liczbaWierszy / 2, liczbaKolumn / 2, 20, 20);
            Plansza plansza = new Plansza(liczbaKolumn, liczbaWierszy);
            add(plansza);


            this.oknoGry = new JFrame("Gra Pacman");
            oknoGry.setLayout(null);
            oknoGry.setSize(liczbaKolumn * 10, liczbaWierszy * 10);
            oknoGry.setBounds((screenSize.width - oknoGry.getWidth()) / 2, (screenSize.height - oknoGry.getHeight()) / 2, oknoGry.getWidth(), oknoGry.getHeight());
            oknoGry.getContentPane().setBackground(new Color(0, 0, 0));
            oknoGry.add(pacman);
            oknoGry.addKeyListener(pacman);
            oknoGry.setVisible(true);





        } else {
            JOptionPane.showMessageDialog(oknoWyboruRozmiaru, "Wprowadź prawidłowe wymiary (10-100).", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
