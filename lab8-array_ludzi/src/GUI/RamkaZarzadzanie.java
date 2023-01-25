package GUI;

import Ludzie.*;
import Serializacja.Serializacja;
import Snek.Start;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RamkaZarzadzanie extends JFrame implements ActionListener {

    private static JLayeredPane warstwowy_panel = new JLayeredPane();
    private static JPanel panel_glowny = new JPanel();
    private static JPanel panel_wyborow = new JPanel();
    private static JPanel panel_wyswietlen = new JPanel();
    private static JLabel To_jest_wyszukiwanie = new JLabel("Wyszukiwanie osób:");
    private static JList<Osoba> lista_osob_J = new JList<>();
    private static JScrollPane suwak_wyswietlen = new JScrollPane(lista_osob_J);
    private static JButton przycisk_wyszukaj,przyczisk_edytuj,przycisk_usun,potwierdz_usun, przycisk_anuluj,zmien_kolor,przycisk_snek;

    private static DefaultListModel<Osoba> przekonwertowana;
    private static JTextField podaj_atrybuty = new JTextField(30);
    private static JMenu menu_wybr_zbioru = new JMenu("WYBRANE ZBIORY OSÓB");
    private static JCheckBoxMenuItem prac_n_d,prac_admin,stud_dzien,stud_zaocz;
    private static JMenuBar menu_pasek= new JMenuBar();
    private static JFrame ramka_czy_usunac = new JFrame();
    private static JLabel label_czy_usunac = new JLabel();
    private static JPanel panel_na_combobox=new JPanel(),panel_do_tworzenia=new JPanel();
    private static JComboBox combo_wybor_os_do_stw = new JComboBox();
    private static PanelTworz panel_tw_stud_d, panel_tw_stud_z,panel_tw_prac_nd, panel_tw_prac_adm;
    private static PanelTworzKurs panel_tw_kurs;
    private static JTextField imie,nazwisko,wiek,stanowisko,semestr,kierunek,stypendium,wart_dor,zar_pm,nr_ind,czesne;
    private static JLabel Limie,Lnazwisko,Lwiek,Lstanowisko,Lsemestr,Lkierunek,Lstypendium,Lwart_dor,Lzar_pm,Lnr_ind,Lczesne;
    public static Color kolor1 = Color.decode("#0398fc");

    public static Color kolor2 = Color.decode("#f5cba7");
    public static Color kolorTel = Color.LIGHT_GRAY.brighter().brighter().brighter();
    private static RamkaWybierzKursy ramkaWybierzKursy;

    static {
        try {
            ramkaWybierzKursy = new RamkaWybierzKursy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public RamkaZarzadzanie() throws IOException, ClassNotFoundException {
        this.setBackground(kolor1);
        this.setTitle("Baza danych osob na uczelni");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        ImageIcon logo = new ImageIcon("pobrane.png");
        this.setIconImage(logo.getImage());
        this.setSize(900,700);

        this.setVisible(false);
        this.setLayout(null);


        warstwowy_panel.setBounds(0,0,600,700);
        this.add(warstwowy_panel);


        panel_glowny.setBounds(0,0,600,700);
        panel_glowny.setBackground(kolor1);
        panel_glowny.setOpaque(true);

//panel wyborow

        Border obramowanie1 = BorderFactory.createLineBorder(new Color(0,0,0,40),3,false);
        panel_wyborow.setBorder(obramowanie1);
        panel_wyborow.setBounds(5,5,590,150);
        panel_wyborow.setOpaque(true);
        panel_wyborow.setLayout(null);
        panel_wyborow.setBackground(kolorTel);

        BufferedImage obrazek_lupa = null;
        try {
            obrazek_lupa = ImageIO.read(new File("lupa.png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        przycisk_wyszukaj = new JButton(new ImageIcon(obrazek_lupa));
        przycisk_wyszukaj.setFocusable(false);
        przycisk_wyszukaj.addActionListener(this);
        przycisk_wyszukaj.setBounds(250,50,40,40);
        przycisk_wyszukaj.setBackground(new Color(255,255,255,255));
        panel_wyborow.add(przycisk_wyszukaj);

        To_jest_wyszukiwanie.setBounds(10,20,300,20);
        To_jest_wyszukiwanie.setFont(new Font(To_jest_wyszukiwanie.getName(),0,17));
        panel_wyborow.add(To_jest_wyszukiwanie);

        podaj_atrybuty.setBounds(5,50,240,40);
        podaj_atrybuty.setFont(new Font(podaj_atrybuty.getFont().getFontName(),0,20));
        panel_wyborow.add(podaj_atrybuty);


        prac_n_d = new JCheckBoxMenuItem("PRACOWNICY DYDAKT.NAUK.");
        prac_admin = new JCheckBoxMenuItem("PRACOWNICY ADMINISTRACYJNI");
        stud_dzien = new JCheckBoxMenuItem("STUDENCI DZIENNI");
        stud_zaocz = new JCheckBoxMenuItem("STUDENCI ZAOCZNI");

        prac_n_d.setSelected(true);
        prac_admin.setSelected(true);
        stud_zaocz.setSelected(true);
        stud_dzien.setSelected(true);


        menu_wybr_zbioru.setBounds(0,0,250,30);
        menu_pasek.add(menu_wybr_zbioru);
        menu_wybr_zbioru.add(prac_n_d);
        menu_wybr_zbioru.add(prac_admin);
        menu_wybr_zbioru.add(stud_dzien);
        menu_wybr_zbioru.add(stud_zaocz);
        menu_pasek.setBounds(5,100,160,30);
        menu_pasek.setBackground(new Color(255,255,255,255));
        Border obramowanie2 = BorderFactory.createLineBorder(new Color(0,0,0,40),1,true);
        menu_pasek.setBorder(obramowanie2);
        panel_wyborow.add(menu_pasek);


        przycisk_usun = new JButton();
        ImageIcon tylusun= new ImageIcon("usun.png");
        przycisk_usun.setIcon(tylusun);
        przycisk_usun.setLayout(null);
        przycisk_usun.setBounds(470,95,50,50);
        przycisk_usun.setFocusable(false);
        przycisk_usun.addActionListener(this);
        panel_wyborow.add(przycisk_usun);


        przyczisk_edytuj = new JButton();
        ImageIcon tyledytuj = new ImageIcon("edytuj.png");
        przyczisk_edytuj.setIcon(tyledytuj);
        przyczisk_edytuj.setBounds(530,95,50,50);
        panel_wyborow.add(przyczisk_edytuj);



        ramka_czy_usunac.setTitle("Baza danych osob na uczelni");
        potwierdz_usun = new JButton("Potwierdź");
        potwierdz_usun.setBounds(10,100,100,30);
        potwierdz_usun.setBackground(new Color(170,60,48,255));
        potwierdz_usun.setFocusable(false);
        potwierdz_usun.addActionListener(this);
        przycisk_anuluj = new JButton("Anuluj");
        przycisk_anuluj.setBounds(150,100,80,30);
        przycisk_anuluj.setFocusable(false);
        przycisk_anuluj.addActionListener(this);
        label_czy_usunac.setBounds(30,30,200,50);
        ramka_czy_usunac.setResizable(false);
        ramka_czy_usunac.setLayout(null);
        ramka_czy_usunac.add(potwierdz_usun);
        ramka_czy_usunac.add(przycisk_anuluj);
        ramka_czy_usunac.add(label_czy_usunac);
        ramka_czy_usunac.setIconImage(logo.getImage());

        przycisk_snek = new JButton();
        przycisk_snek.setIcon((Icon) new ImageIcon("snek.png"));
        przycisk_snek.setBounds(560,5,25,25);
        przycisk_snek.addActionListener(this);
        przycisk_snek.setFocusable(false);
        panel_wyborow.add(przycisk_snek);


//panel wyswietlen
        panel_wyswietlen.setBackground(kolorTel);
        panel_wyswietlen.setBorder(obramowanie1);
        panel_wyswietlen.setBounds(5,162,590,490);
        panel_wyswietlen.setOpaque(true);
        panel_wyswietlen.setLayout(new BorderLayout());
        lista_osob_J.setLayoutOrientation(JList.VERTICAL);
        lista_osob_J.setFixedCellWidth(540);
        lista_osob_J.setFixedCellHeight(130);
        lista_osob_J.setSelectionBackground(kolor1);
        lista_osob_J.setBackground(new Color(237,243,241,255));
        lista_osob_J.setFont(new Font(lista_osob_J.getFont().getFontName(),Font.ITALIC,5));
        lista_osob_J.setLayout(null);
        lista_osob_J.setBounds(0,0,581,490);
        lista_osob_J.setFont(new Font("Consolar",Font.PLAIN,17));
        lista_osob_J.setBackground(kolorTel);


        suwak_wyswietlen.setViewportView(lista_osob_J);
        panel_wyswietlen.add(suwak_wyswietlen);


        warstwowy_panel.add(panel_wyborow);
        warstwowy_panel.add(panel_wyswietlen);
        warstwowy_panel.add(panel_glowny);

//panel tworzenia
        panel_na_combobox.setBounds(600,0,300,30);
        panel_na_combobox.setBackground(kolor1);
        this.add(panel_na_combobox);

        combo_wybor_os_do_stw.setBounds(5,5,100,20);
        combo_wybor_os_do_stw.addItem("STUDENT DZIENNY");
        combo_wybor_os_do_stw.addItem("STUDENT ZAOCZNY");
        combo_wybor_os_do_stw.addItem("PRACOWNIK N.D.");
        combo_wybor_os_do_stw.addItem("PRACOWNIK ADM.");
        combo_wybor_os_do_stw.addItem("KURS");
        panel_na_combobox.add(combo_wybor_os_do_stw);
        combo_wybor_os_do_stw.addActionListener(this);

        //definicja labeli i textfieldow
        panel_tw_prac_adm =new PanelTworzPADM(lista_osob_J,lista_osob_J.getSelectedIndex());
        panel_tw_prac_nd = new PanelTworzPND(lista_osob_J,lista_osob_J.getSelectedIndex());
        panel_tw_stud_z =new PanelTworzStZ(lista_osob_J,lista_osob_J.getSelectedIndex());
        panel_tw_stud_d=new PanelTworzStD(lista_osob_J,lista_osob_J.getSelectedIndex());
        panel_tw_kurs = new PanelTworzKurs();

        panel_tw_kurs.setVisible(false);
        panel_tw_prac_adm.setVisible(false);
        panel_tw_prac_nd.setVisible(false);
        panel_tw_stud_z.setVisible(false);
        panel_tw_stud_d.setVisible(true);

        this.add(panel_tw_prac_adm);
        this.add(panel_tw_prac_nd);
        this.add(panel_tw_stud_z);
        this.add(panel_tw_stud_d);
        this.add(panel_tw_kurs);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == przycisk_wyszukaj) {
            wyszukaj();
        }
        if(e.getSource() == przycisk_usun && lista_osob_J.getSelectedIndex() != -1){
            label_czy_usunac.setText("Czy usunąć zaznaczone osoby?");
            label_czy_usunac.setAlignmentX(50);
            ramka_czy_usunac.setBounds(this.getX()+250,this.getY()+150,250,200);
            ramka_czy_usunac.setVisible(true);
            System.out.println(lista_osob_J.getSelectedIndex());
        }
        if(e.getSource() == przycisk_anuluj){
            ramka_czy_usunac.setVisible(false);
        }
        if(e.getSource() == potwierdz_usun){
            int[] lista_zazn = lista_osob_J.getSelectedIndices();
                for(int j=0;j<lista_zazn.length;j++){
                    przekonwertowana.setElementAt(null,lista_osob_J.getSelectedIndices()[j]);
                }

            ArrayList<Osoba> przejsciowa = new ArrayList<>();
            for (int i = 0; i < przekonwertowana.size(); i++)
                if (przekonwertowana.get(i) != null)
                    przejsciowa.add(przekonwertowana.getElementAt(i));
            try {
                Serializacja.zapis(przejsciowa,"PlikOsob.ser");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ramka_czy_usunac.setVisible(false);
            wyszukaj();
        }

        if(e.getSource() == combo_wybor_os_do_stw){
            if(combo_wybor_os_do_stw.getSelectedIndex() == 0){
                panel_tw_kurs.setVisible(false);
                panel_tw_stud_z.setVisible(false);
                panel_tw_prac_adm.setVisible(false);
                panel_tw_prac_nd.setVisible(false);
                panel_tw_stud_d.setVisible(true);
            } else if (combo_wybor_os_do_stw.getSelectedIndex() == 1) {
                panel_tw_kurs.setVisible(false);
                panel_tw_prac_adm.setVisible(false);
                panel_tw_prac_nd.setVisible(false);
                panel_tw_stud_z.setVisible(true);
                panel_tw_stud_d.setVisible(false);
            } else if (combo_wybor_os_do_stw.getSelectedIndex() == 2) {
                panel_tw_kurs.setVisible(false);
                panel_tw_prac_adm.setVisible(false);
                panel_tw_prac_nd.setVisible(true);
                panel_tw_stud_z.setVisible(false);
                panel_tw_stud_d.setVisible(false);
            } else if (combo_wybor_os_do_stw.getSelectedIndex() == 3) {
                panel_tw_kurs.setVisible(false);
                panel_tw_prac_adm.setVisible(true);
                panel_tw_prac_nd.setVisible(false);
                panel_tw_stud_z.setVisible(false);
                panel_tw_stud_d.setVisible(false);
            }else if (combo_wybor_os_do_stw.getSelectedIndex() == 4){
                panel_tw_kurs.setVisible(true);
                panel_tw_prac_adm.setVisible(false);
                panel_tw_prac_nd.setVisible(false);
                panel_tw_stud_z.setVisible(false);
                panel_tw_stud_d.setVisible(false);
            }
        }else if(e.getSource() == przycisk_snek){
            if(combo_wybor_os_do_stw.getSelectedIndex()<1 ||  combo_wybor_os_do_stw.getSelectedIndex()>4){
                new Start(1);
            }else
            new Start(combo_wybor_os_do_stw.getSelectedIndex());
        }

//        if(e.getSource() == zmien_kolor){
//            if(!kolor1.equals(Color.decode("#705b08"))) {
//                kolor1 = Color.decode("#705b08");
//                kolorTel = Color.decode("#c9bd95");
//                zmien_kolor.setBackground(Color.decode("#5468cf"));
//
//            }
//            else {
//                kolor1 = Color.decode("#5468cf");
//                kolorTel = Color.white;
//                zmien_kolor.setBackground(Color.decode("#705b08"));
//            }
//
//        }
    }
    public void wyszukaj(){
        ArrayList<Osoba> lista_osob = null;
        try {
            lista_osob = Serializacja.odczyt("PlikOsob.ser");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        przekonwertowana = new DefaultListModel<>();
        przekonwertowana.setSize(lista_osob.size());
        for (int i = 0; i < lista_osob.size(); i++)
            przekonwertowana.set(i, lista_osob.get(i));


        if (!stud_dzien.isSelected()) {
            for (int i = 0; i < przekonwertowana.size(); i++)
                if (przekonwertowana.get(i) instanceof Student_dzienny)
                    przekonwertowana.set(i, null);
        }
        if (!stud_zaocz.isSelected()) {
            for (int i = 0; i < przekonwertowana.size(); i++)
                if (przekonwertowana.get(i) instanceof Student_zaoczny)
                    przekonwertowana.set(i, null);
        }
        if (!prac_admin.isSelected()) {
            for (int i = 0; i < przekonwertowana.size(); i++)
                if (przekonwertowana.get(i) instanceof Pracownik_uczelni)
                    przekonwertowana.set(i, null);
        }
        if (!prac_n_d.isSelected()) {
            for (int i = 0; i < przekonwertowana.size(); i++)
                if (przekonwertowana.get(i) instanceof Pracownik_uczelni_naukowo_dydaktyczny)
                    przekonwertowana.set(i, null);
        }

        DefaultListModel<Osoba> przejsciowa = new DefaultListModel<>();
        for (int i = 0; i < przekonwertowana.size(); i++)
            if (przekonwertowana.get(i) != null)
                przejsciowa.addElement(przekonwertowana.getElementAt(i));

        DefaultListModel<Osoba> przejsicowa_od_polatxt = new DefaultListModel<>();

        if(!podaj_atrybuty.getText().isEmpty()) {
            for (int i = 0; i < przejsciowa.size(); i++)
                if (przejsciowa.get(i).toString().toUpperCase().contains(podaj_atrybuty.getText().toUpperCase()))
                    przejsicowa_od_polatxt.addElement(przejsciowa.getElementAt(i));
            lista_osob_J.setModel(przejsicowa_od_polatxt);
        }else
            lista_osob_J.setModel(przejsciowa);
    }

    public static RamkaWybierzKursy getRamkaWybierzKursy() {
        return ramkaWybierzKursy;
    }

    public static void setRamkaWybierzKursy(RamkaWybierzKursy ramkaWybierzKursy) {
        RamkaZarzadzanie.ramkaWybierzKursy = ramkaWybierzKursy;
    }
}
