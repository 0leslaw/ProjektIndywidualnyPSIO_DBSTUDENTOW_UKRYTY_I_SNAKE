package GUI;

import Ludzie.Student_zaoczny;
import Ludzie.Osoba;
import Serializacja.Serializacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static GUI.PomocniczeFunkcjeGUI.*;
import static GUI.RamkaZarzadzanie.kolor1;
import static GUI.RamkaZarzadzanie.kolorTel;


public class PanelTworzStZ extends PanelTworz implements ActionListener {
    private static JTextField semestr,kierunek,stypendium,nr_ind,czesne;
    private static JLabel Lsemestr,Lkierunek,Lstypendium,Lnr_ind,Lczesne;
    protected JButton przycisk_dodaj,przycisk_dodaj_kurs;
    protected JLabel Lniepoprawnedane = new JLabel("podano nieprawidłowe dane");


    public PanelTworzStZ(JList<Osoba> lista_J, int indeks_zaznaczony) throws IOException, ClassNotFoundException {
        super();
        label_co_to_za_panel = new JLabel("<html>To jest panel tworzenia studenta Zaocznego,<br> upewnij się że" +
                " wprowadzone dane są prawidłowe</html>");
        label_co_to_za_panel.setBounds(5,5,290,100);
        this.add(label_co_to_za_panel);
        Lniepoprawnedane.setBounds(80,510,200,50);
        Lniepoprawnedane.setFont(new Font(Lniepoprawnedane.getFont().getFontName(),0,10));
        Lniepoprawnedane.setForeground(Color.red);
        Lniepoprawnedane.setVisible(false);
        this.add(Lniepoprawnedane);
        semestr=new JTextField(10);
        kierunek=new JTextField(10);
        stypendium=new JTextField(10);
        nr_ind=new JTextField(10);
        czesne=new JTextField(10);
        Lsemestr=new JLabel();
        Lkierunek=new JLabel();
        Lstypendium=new JLabel();
        Lnr_ind=new JLabel();
        Lczesne=new JLabel();

        nr_ind.setBounds(przesuniecie_tektow,250,150,wys_tekstow);
        nr_ind.setText(String.valueOf(Serializacja.dajNowyIndeks("PlikOsob.ser")));
        Lnr_ind.setBounds(5,250,100,wys_tekstow);
        Lnr_ind.setText("Numer indeksu: ");
        stypendium.setBounds(przesuniecie_tektow,300,150,wys_tekstow);
        Lstypendium.setBounds(20,300,110,wys_tekstow);
        Lstypendium.setText("Stypendium: ");
        czesne.setBounds(przesuniecie_tektow,350,150,wys_tekstow);
        Lczesne.setBounds(50,350,50,wys_tekstow);
        Lczesne.setText("Czesne: ");
        semestr.setBounds(przesuniecie_tektow,400,150,wys_tekstow);
        Lsemestr.setBounds(45,400,60,wys_tekstow);
        Lsemestr.setText("Semestr: ");
        kierunek.setBounds(przesuniecie_tektow,450,150,wys_tekstow);
        Lkierunek.setBounds(40,450,70,wys_tekstow);
        Lkierunek.setText("Kierunek: ");

        przycisk_dodaj = new JButton("Dodaj");
        przycisk_dodaj.setBounds(100,550,100,30);
        przycisk_dodaj.setFocusable(false);
        przycisk_dodaj.addActionListener(this);
        this.add(przycisk_dodaj);

        przycisk_dodaj_kurs = new JButton("Dodaj kurs");
        przycisk_dodaj_kurs.setBounds(120,480,130,30);
        przycisk_dodaj_kurs.addActionListener(this);
        przycisk_dodaj_kurs.setBackground(kolor1);
        przycisk_dodaj_kurs.setForeground(kolorTel);
        przycisk_dodaj_kurs.setFocusable(false);
        this.add(przycisk_dodaj_kurs);

        this.add(nr_ind);
        this.add(Lnr_ind);
        this.add(stypendium);
        this.add(Lstypendium);
        this.add(czesne);
        this.add(Lczesne);
        this.add(semestr);
        this.add(Lsemestr);
        this.add(kierunek);
        this.add(Lkierunek);

//        this.setBackground(Color.YELLOW);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == przycisk_dodaj) {
            Student_zaoczny s;
            System.out.println(kierunek.getText());
            System.out.println(kierunek.getText() + imie.getText()
                    + nazwisko.getText());
            if (czyjestSamint(semestr.getText(), 0, 15) &&
                    czyjestSamint(wiek.getText(), 3, 130) &&
                    czyjestSamint(nr_ind.getText(), 100000, 1000000) &&
                    (czyjestSamint(stypendium.getText(), -1, 10000) || stypendium.getText().isEmpty()) &&
                    czyjestSamint(czesne.getText(), -1, 3000) &&
                    czyjestSamString(kierunek.getText()) && czyjestSamString(imie.getText()) &&
                    czyjestSamString(nazwisko.getText())) {

                if (stypendium.getText().isEmpty()) {
                    s = new Student_zaoczny(kierunek.getText(), dajIntaOdStringa(semestr.getText()), imie.getText()
                            , dajIntaOdStringa(wiek.getText()), nazwisko.getText(), dajIntaOdStringa(nr_ind.getText()),
                            412, dajIntaOdStringa(czesne.getText()));
                    s.przyznanieStypendium();
                } else {
                    s = new Student_zaoczny(kierunek.getText(), dajIntaOdStringa(semestr.getText()), imie.getText()
                            , dajIntaOdStringa(wiek.getText()), nazwisko.getText(), dajIntaOdStringa(nr_ind.getText()),
                            dajIntaOdStringa(stypendium.getText()), dajIntaOdStringa(czesne.getText()));
                }
                System.out.println("stworzylo studa");
                try {
                    Serializacja.dopisz(s, "PlikOsob.ser");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Lniepoprawnedane.setVisible(false);
                this.repaint();
            } else {
                Lniepoprawnedane.setVisible(true);
                System.out.println("dovdofm");
            }
        }else if(e.getSource() == przycisk_dodaj_kurs){
            RamkaStartowa.getRamkaZarzadzanie().setLocation(80,100);
            RamkaZarzadzanie.getRamkaWybierzKursy().setLocation( RamkaStartowa.getRamkaZarzadzanie().getX()+RamkaStartowa.getRamkaZarzadzanie().getWidth(),
                    RamkaStartowa.getRamkaZarzadzanie().getY());
            RamkaZarzadzanie.getRamkaWybierzKursy().setVisible(true);
        }
    }

}
