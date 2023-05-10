package Menu;

import javax.swing.*;
import java.awt.*;


public class NewMain2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Color kolorTla = new Color(0, 0, 0);
            Color kolorTekstu = new Color(255, 255, 255);
            Font czcionka = new Font("Arial", Font.BOLD, 24);


            JFrame ramka = new JFrame("Gra Pacman");
            ramka.setSize(300, 300);
            ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ramka.getContentPane().setBackground(kolorTla);
            ramka.setLayout(new BorderLayout());


            JPanel panelPrzyciskow = new JPanel();
            panelPrzyciskow.setLayout(new GridLayout(3, 1));
            panelPrzyciskow.setBackground(kolorTla);


            JButton nowaGra = new JButton("Nowa Gra");
            nowaGra.setFont(czcionka);
            nowaGra.setBackground(kolorTla);
            nowaGra.setForeground(kolorTekstu);
            JButton najlepszeWyniki = new JButton("Najlepsze Wyniki");
            najlepszeWyniki.setFont(czcionka);
            najlepszeWyniki.setBackground(kolorTla);
            najlepszeWyniki.setForeground(kolorTekstu);
            JButton wyjscie = new JButton("Wyjście");
            wyjscie.setFont(czcionka);
            wyjscie.setBackground(kolorTla);
            wyjscie.setForeground(kolorTekstu);


            panelPrzyciskow.add(nowaGra);
            panelPrzyciskow.add(najlepszeWyniki);
            panelPrzyciskow.add(wyjscie);


            ramka.add(panelPrzyciskow, BorderLayout.CENTER);


            ramka.setVisible(true);


            nowaGra.addActionListener(e -> {
                ramka.setVisible(false);
                JFrame oknoWyboruRozmiaru = new JFrame("Nowa Gra");
                oknoWyboruRozmiaru.setSize(300, 300);
                oknoWyboruRozmiaru.getContentPane().setBackground(kolorTla);


                oknoWyboruRozmiaru.setLayout(new GridLayout(3, 1));


                JLabel etykietaWierszy = new JLabel("Wierszy:");
                etykietaWierszy.setFont(czcionka);
                etykietaWierszy.setForeground(kolorTekstu);
                JTextField poleWierszy = new JTextField();
                poleWierszy.setFont(czcionka);
                JLabel etykietaKolumn = new JLabel("Kolumn:");
                etykietaKolumn.setFont(czcionka);
                etykietaKolumn.setForeground(kolorTekstu);
                JTextField poleKolumn = new JTextField();
                poleKolumn.setFont(czcionka);


                JButton przyciskStart = new JButton("Start");
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
                    int liczbaWierszy = 0;
                    int liczbaKolumn = 0;
                    try {
                        liczbaWierszy = Integer.parseInt(poleWierszy.getText());
                        liczbaKolumn = Integer.parseInt(poleKolumn.getText());
                    } catch (NumberFormatException ignored) {

                    }

                    if (liczbaWierszy >= 10 && liczbaWierszy <= 100 && liczbaKolumn >= 10 && liczbaKolumn <= 100) {
                        oknoWyboruRozmiaru.dispose();


                        JFrame oknoGry = new JFrame("Gra Pacman");
                        oknoGry.setSize(liczbaKolumn * 10, liczbaWierszy * 10);
                        oknoGry.getContentPane().setBackground(kolorTla);

                        oknoGry.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(oknoWyboruRozmiaru, "Wprowadź prawidłowe wymiary (10-100).", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                });
            });

            najlepszeWyniki.addActionListener(e -> {

            });

            wyjscie.addActionListener(e -> System.exit(0));
        });
    }
}

