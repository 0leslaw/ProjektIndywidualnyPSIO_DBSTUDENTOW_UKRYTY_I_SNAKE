package GUI;

import javax.swing.*;
import java.awt.*;

import static GUI.RamkaZarzadzanie.kolorTel;

public abstract class PanelTworz extends JPanel {
    protected static JLabel Limie,Lnazwisko,Lwiek;
    protected JTextField imie,nazwisko,wiek;
    protected int przesuniecie_tektow = 120;
    protected int wys_tekstow = 25;
    protected JLabel label_co_to_za_panel;



    public PanelTworz(){
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3,true));
        this.setBackground(kolorTel);
        imie=new JTextField(10);
        nazwisko=new JTextField(10);
        wiek=new JTextField(10);
        Limie=new JLabel();
        Lnazwisko=new JLabel();
        Lwiek=new JLabel();
        this.setBounds(600,30,300,700);
        this.setLayout(null);
        this.add(imie);
        this.add(Limie);
        this.add(nazwisko);
        this.add(Lnazwisko);
        this.add(wiek);
        this.add(Lwiek);

        int przesuniecie_tektow = 120;
        int wys_tekstow = 25;
        imie.setBounds(przesuniecie_tektow,100,150,wys_tekstow);
        Limie.setBounds(60,100,50,25);
        Limie.setText("Imię: ");
        nazwisko.setBounds(przesuniecie_tektow,150,150,wys_tekstow);
        Lnazwisko.setBounds(30,150,150,25);
        Lnazwisko.setText("Nazwisko: ");
        wiek.setBounds(przesuniecie_tektow,200,150,wys_tekstow);
        Lwiek.setBounds(60,200,150,25);
        Lwiek.setText("Wiek: ");

    }
}
