package GUI;

import Kursy.Kurs;
import Serializacja.Serializacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PanelTworzKurs extends JPanel implements ActionListener {
    private static JLabel Lnazwa,LECTs,Lsem,label_co_to_za_panel;
    private static JTextField nazwa,ECTs,sem;
    private static JButton przycisk_dodaj;
    private static JLabel Lniepoprawnedane = new JLabel("Podano niepoprawne dane");

    public PanelTworzKurs(){
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3,true));
        this.setBackground(RamkaZarzadzanie.kolorTel);
        this.setBounds(600,30,300,700);
        this.setLayout(null);

        label_co_to_za_panel = new JLabel("<html>To jest panel tworzenia Kursu,<br> upewnij się że" +
                " wprowadzone dane są prawidłowe</html>");
        label_co_to_za_panel.setBounds(5,5,290,100);
        this.add(label_co_to_za_panel);

        Lnazwa = new JLabel("Nazwa: ");
        Lsem = new JLabel("Semestr: ");
        LECTs = new JLabel("ECTs: ");
        nazwa = new JTextField(10);
        sem = new JTextField(10);
        ECTs = new JTextField(10);

        Lniepoprawnedane.setBounds(80,510,200,50);
        Lniepoprawnedane.setFont(new Font(Lniepoprawnedane.getFont().getFontName(),0,10));
        Lniepoprawnedane.setForeground(Color.red);
        Lniepoprawnedane.setVisible(false);
        this.add(Lniepoprawnedane);
        int przesuniecie_tektow = 120;
        int wys_tekstow = 25;
        sem.setBounds(przesuniecie_tektow,100,150,wys_tekstow);
        Lsem.setBounds(przesuniecie_tektow-80,100,100,wys_tekstow);
        nazwa.setBounds(przesuniecie_tektow,150,150,wys_tekstow);
        Lnazwa.setBounds(przesuniecie_tektow-70,150,80,wys_tekstow);
        ECTs.setBounds(przesuniecie_tektow,200,150,wys_tekstow);
        LECTs.setBounds(przesuniecie_tektow-60,200,40,wys_tekstow);

        przycisk_dodaj = new JButton("Dodaj");
        przycisk_dodaj.setBounds(100,550,100,30);
        przycisk_dodaj.setFocusable(false);
        przycisk_dodaj.addActionListener(this);
        this.add(przycisk_dodaj);

        this.add(sem);
        this.add(Lsem);
        this.add(ECTs);
        this.add(LECTs);
        this.add(nazwa);
        this.add(Lnazwa);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Kurs k;

        if(PomocniczeFunkcjeGUI.czyjestSamint(ECTs.getText(),0,40) &&
                PomocniczeFunkcjeGUI.czyjestSamint(sem.getText(),0,20) &&
                PomocniczeFunkcjeGUI.czyjestSamString(nazwa.getText())){
                k = new Kurs(nazwa.getText(), PomocniczeFunkcjeGUI.dajIntaOdStringa(ECTs.getText()), PomocniczeFunkcjeGUI.dajIntaOdStringa(sem.getText()));

            System.out.println("stworzylo kurs");
            try {
                Serializacja.dopiszDoDowolnejArraylistyTypuTYLKOT(k,"PlikKursow.ser");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            Lniepoprawnedane.setVisible(false);
        }else {
            Lniepoprawnedane.setVisible(true);
            System.out.println("dovdofm");
        }
    }
}
