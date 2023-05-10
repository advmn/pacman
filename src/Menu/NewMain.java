package Menu;

import javax.swing.*;
import java.awt.*;


public class NewMain {
    public static void main(String[] args) {

        JFrame ramka = new JFrame("Pacman Gierka");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(400, 400);


        ramka.setLayout(new GridLayout(3, 1));


        JButton nowaGra = new JButton("Nowa Gra");
        JButton najlepszeWyniki = new JButton("Najlepsze Wyniki");
        JButton wyjscie = new JButton("Wyjście");


        Font czcionka = new Font("Courier", Font.BOLD, 14);
        Color kolorTla = Color.BLACK;
        Color kolorTekstu = Color.YELLOW;

        nowaGra.setFont(czcionka);
        nowaGra.setBackground(kolorTla);
        nowaGra.setForeground(kolorTekstu);
        najlepszeWyniki.setFont(czcionka);
        najlepszeWyniki.setBackground(kolorTla);
        najlepszeWyniki.setForeground(kolorTekstu);
        wyjscie.setFont(czcionka);
        wyjscie.setBackground(kolorTla);
        wyjscie.setForeground(kolorTekstu);
        ramka.getContentPane().setBackground(kolorTla);


        nowaGra.addActionListener(e -> {
            ramka.setVisible(false);
            JFrame oknoWyboruRozmiaru = new JFrame("Nowa Gra");
            oknoWyboruRozmiaru.setSize(300, 300);
            oknoWyboruRozmiaru.getContentPane().setBackground(kolorTla);


            oknoWyboruRozmiaru.setLayout(new GridLayout(3, 1));


            JLabel etykietaWierszy = new JLabel("Wiersze (10-100):");
            etykietaWierszy.setForeground(kolorTekstu);
            JTextField poleWierszy = new JTextField();
            JLabel etykietaKolumn = new JLabel("Kolumny (10-100):");
            etykietaKolumn.setForeground(kolorTekstu);
            JTextField poleKolumn = new JTextField();


            JButton przyciskStart = new JButton("Start");
            przyciskStart.setFont(czcionka);
            przyciskStart.setBackground(kolorTla);
            przyciskStart.setForeground(kolorTekstu);
            przyciskStart.addActionListener(e1 -> {
                int wiersze = Integer.parseInt(poleWierszy.getText());
                int kolumny = Integer.parseInt(poleKolumn.getText());
                if (wiersze >= 10 && wiersze <= 100 && kolumny >= 10 && kolumny <= 100) {
                    oknoWyboruRozmiaru.dispose();
                    JFrame oknoGry = new JFrame("Pacman");
                    oknoGry.setSize(500, 500);

                    oknoGry.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(oknoWyboruRozmiaru, "Wprowadź prawidłowe wymiary (10-100).", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            });




            oknoWyboruRozmiaru.add(etykietaWierszy);
            oknoWyboruRozmiaru.add(poleWierszy);
            oknoWyboruRozmiaru.add(etykietaKolumn);
            oknoWyboruRozmiaru.add(poleKolumn);
            oknoWyboruRozmiaru.add(przyciskStart);

            oknoWyboruRozmiaru.setVisible(true);
        });

        najlepszeWyniki.addActionListener(e -> {

        });

        wyjscie.addActionListener(e -> System.exit(0));


        ramka.add(nowaGra);
        ramka.add(najlepszeWyniki);
        ramka.add(wyjscie);


        ramka.setVisible(true);
    }
}


