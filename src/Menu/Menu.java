package Menu;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private final Color kolorTla = new Color(0, 0, 0);
    private final Color kolorTekstu = new Color(255, 255, 255);
    private final Font czcionka = new Font("Arial", Font.BOLD, 24);
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JFrame ramka;
    private JPanel panelPrzyciskow;
    private JButton nowaGra;
    private JButton najlepszeWyniki;
    private JButton wyjscie;

    Menu() {
        this.ramka = new JFrame("Gra Pacman");
        ramka.setSize(300, 300);
        ramka.setBounds((screenSize.width - ramka.getWidth()) / 2, (screenSize.height - ramka.getHeight()) / 2, ramka.getWidth(), ramka.getHeight());
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.getContentPane().setBackground(kolorTla);
        ramka.setLayout(new BorderLayout());

        this.panelPrzyciskow = new JPanel();
        panelPrzyciskow.setLayout(new GridLayout(3, 1));
        panelPrzyciskow.setBackground(kolorTla);

        this.nowaGra = new JButton("Nowa Gra");
        setButtons(nowaGra);

        this.najlepszeWyniki = new JButton("Najlepsze Wyniki");
        setButtons(najlepszeWyniki);

        this.wyjscie = new JButton("Wyjście");
        setButtons(wyjscie);

        panelPrzyciskow.add(nowaGra);
        panelPrzyciskow.add(najlepszeWyniki);
        panelPrzyciskow.add(wyjscie);

        ramka.add(panelPrzyciskow, BorderLayout.CENTER);
        ramka.setVisible(true);

        nowaGra.addActionListener(e -> {
            MenuRozmiaru menuRozmiaru = new MenuRozmiaru(ramka, kolorTla, kolorTekstu, czcionka);
        });

        najlepszeWyniki.addActionListener(e -> {

        });

        wyjscie.addActionListener(e -> System.exit(0));
    }

    private void setButtons(JButton button){
        button.setFont(czcionka);
        button.setBackground(kolorTla);
        button.setForeground(kolorTekstu);
    }
}
