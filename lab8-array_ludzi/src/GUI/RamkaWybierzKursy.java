package GUI;

import Kursy.Kurs;
import Serializacja.Serializacja;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static GUI.RamkaZarzadzanie.kolor1;
import static GUI.RamkaZarzadzanie.kolorTel;

public class RamkaWybierzKursy extends JFrame {
    private static JList<Kurs> lista_kursow_J = new JList<>();
    private static DefaultListModel<Kurs> przekonwertowana = new DefaultListModel<>();
    private static ArrayList<Kurs> lista_kursow;
    private static JPanel panel = new JPanel(null);
    private static JScrollPane suwak_wyswietlen = new JScrollPane(lista_kursow_J);
    private JLabel label = new JLabel("Wybrane kursy zostaną przydzielone studentowi");

    public RamkaWybierzKursy() throws IOException, ClassNotFoundException {
        this.setTitle("Baza danych osob na uczelni");
        this.setBounds(960,60,500,400);
        this.setVisible(false);
        this.setLayout(null);
        this.add(panel);
        this.add(label);
        this.getContentPane().setBackground(kolor1);
        ImageIcon logo = new ImageIcon("pobrane.png");
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        label.setBounds(5,10,300,40);
        label.setForeground(Color.WHITE);

        panel.setBounds(0,50,500,350);
        suwak_wyswietlen.setBounds(0,0,490,350);
        panel.add(suwak_wyswietlen);

        lista_kursow_J.setLayoutOrientation(JList.VERTICAL);
        lista_kursow_J.setFixedCellWidth(485);
        lista_kursow_J.setFixedCellHeight(30);
        lista_kursow_J.setSelectionBackground(kolor1);
        lista_kursow_J.setBackground(new Color(237,243,241,255));
        lista_kursow_J.setFont(new Font(lista_kursow_J.getFont().getFontName(),Font.ITALIC,10));
        lista_kursow_J.setLayout(null);
        lista_kursow_J.setBounds(0,0,200,150);
        lista_kursow_J.setFont(new Font("Consolar",Font.PLAIN,17));
        lista_kursow_J.setBackground(kolorTel);

        lista_kursow = Serializacja.odczytDowolnejArrayListy("PlikKursow.ser");
        for(Kurs kurs:lista_kursow)
            przekonwertowana.addElement(kurs);

        lista_kursow_J.setModel(przekonwertowana);

        suwak_wyswietlen.setViewportView(lista_kursow_J);

    }

    public static JList<Kurs> getLista_kursow_J() {
        return lista_kursow_J;
    }

    public static void setLista_kursow_J(JList<Kurs> lista_kursow_J) {
        RamkaWybierzKursy.lista_kursow_J = lista_kursow_J;
    }

    public static DefaultListModel<Kurs> getPrzekonwertowana() {
        return przekonwertowana;
    }

    public static void setPrzekonwertowana(DefaultListModel<Kurs> przekonwertowana) {
        RamkaWybierzKursy.przekonwertowana = przekonwertowana;
    }

    public static ArrayList<Kurs> getLista_kursow() {
        return lista_kursow;
    }

    public static void setLista_kursow(ArrayList<Kurs> lista_kursow) {
        RamkaWybierzKursy.lista_kursow = lista_kursow;
    }
}
