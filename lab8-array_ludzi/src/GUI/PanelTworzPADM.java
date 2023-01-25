package GUI;

import Ludzie.Osoba;
import Ludzie.Pracownik_uczelni;
import Serializacja.Serializacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static GUI.PomocniczeFunkcjeGUI.*;

public class PanelTworzPADM extends PanelTworz implements ActionListener {
    private static JTextField stanowisko,zar_pm;
    private static JLabel Lstanowisko,Lzar_pm;
    protected JButton przycisk_dodaj;
    protected JLabel Lniepoprawnedane = new JLabel("podano nieprawidłowe dane");


    public PanelTworzPADM(JList<Osoba> lista_J, int indeks_zaznaczony){
        super();



        label_co_to_za_panel = new JLabel("<html>To jest panel tworzenia pracownika Administracji,<br> upewnij się że" +
                " wprowadzone dane są prawidłowe</html>");
        label_co_to_za_panel.setBounds(5,5,290,100);
        this.add(label_co_to_za_panel);


        Lniepoprawnedane.setBounds(80,510,200,50);
        Lniepoprawnedane.setFont(new Font(Lniepoprawnedane.getFont().getFontName(),0,10));
        Lniepoprawnedane.setForeground(Color.red);
        Lniepoprawnedane.setVisible(false);
        this.add(Lniepoprawnedane);
        stanowisko = new JTextField(10);
        zar_pm = new JTextField(10);
        Lstanowisko = new JLabel("Stanowisko: ");
        Lzar_pm = new JLabel("Zarobki (PM): ");

        stanowisko.setBounds(przesuniecie_tektow,250,150,wys_tekstow);
        Lstanowisko.setBounds(20,250,90,wys_tekstow);
        zar_pm.setBounds(przesuniecie_tektow,300,150,wys_tekstow);
        Lzar_pm.setBounds(20,300,80,wys_tekstow);

        przycisk_dodaj = new JButton("Dodaj");
        przycisk_dodaj.setBounds(100,550,100,30);
        przycisk_dodaj.setFocusable(false);
        przycisk_dodaj.addActionListener(this);
        this.add(przycisk_dodaj);

        this.add(stanowisko);
        this.add(zar_pm);
        this.add(Lstanowisko);
        this.add(Lzar_pm);
//        this.setBackground(Color.BLUE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pracownik_uczelni p;
        System.out.println(stanowisko.getText());
        System.out.println(stanowisko.getText()+  imie.getText()
                + nazwisko.getText());
        if(czyjestSamint(wiek.getText(),3,130) &&
                (czyjestSamint(zar_pm.getText(),-1,10000)||zar_pm.getText().isEmpty()) &&
                czyjestSamString(stanowisko.getText()) && czyjestSamString(imie.getText()) &&
                czyjestSamString(nazwisko.getText())) {

            if(zar_pm.getText().isEmpty()){
                p = new Pracownik_uczelni(imie.getText()
                        ,dajIntaOdStringa(wiek.getText()),nazwisko.getText(),
                        stanowisko.getText(),412);
                p.przydzielPlace();
            }else {
                p = new Pracownik_uczelni(imie.getText()
                        ,dajIntaOdStringa(wiek.getText()),nazwisko.getText(),
                        stanowisko.getText(),dajIntaOdStringa(zar_pm.getText()));
            }
            System.out.println("stworzylo praca");
            try {
                Serializacja.dopisz(p,"PlikOsob.ser");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            Lniepoprawnedane.setVisible(false);
            this.repaint();
        }else {
            Lniepoprawnedane.setVisible(true);
            System.out.println("dovdofm");
        }
    }
}
