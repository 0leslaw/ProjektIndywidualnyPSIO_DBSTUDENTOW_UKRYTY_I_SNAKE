package GUI;

//import Test_1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class RamkaStartowa implements ActionListener {

    private static JFrame ramka;
    private static JPanel panel_logowania;
    private static JButton przycisk_zaloguj;
    private static JPasswordField podaj_kod_dostepu;
    private static JLabel label_zaloguj;
    private static JLabel czy_poprawny_kod;
    private static JLabel wyswietla_obrazek_logotyp;
    private static RamkaZarzadzanie ramkaZarzadzanie;

    static {
        try {
            ramkaZarzadzanie = new RamkaZarzadzanie();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void start(){

        ramka = new JFrame();
        ramka.setTitle("Baza danych osob na uczelni");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setResizable(false);
        ImageIcon logo = new ImageIcon("pobrane.png");
        ramka.setIconImage(logo.getImage());
        Point punkt = new Point(540,260);
        ramka.setLocation(punkt);
        ramka.getContentPane().setBackground(new Color(237,243,241,255));


        panel_logowania = new JPanel();
        panel_logowania.setSize(50,50);
        panel_logowania.setLayout(null);
        panel_logowania.setBackground(new Color(237,243,241,255));
        ramka.add(panel_logowania);


        przycisk_zaloguj = new JButton("Zaloguj");
        przycisk_zaloguj.setBounds(150,150,100,30);
        przycisk_zaloguj.addActionListener(new RamkaStartowa());
        przycisk_zaloguj.setBackground(new Color(45,164,204,255));
        przycisk_zaloguj.setForeground(new Color(255,255,255));
        przycisk_zaloguj.setFocusable(false);


        podaj_kod_dostepu = new JPasswordField(8);
        podaj_kod_dostepu.setBounds(150,120,100,25);
        podaj_kod_dostepu.setFont(new Font(podaj_kod_dostepu.getFont().getFontName(),(podaj_kod_dostepu.getFont()).getStyle(),25));


        label_zaloguj = new JLabel("Kod dostępu:");
        label_zaloguj.setBounds(80,120,70,30);
        label_zaloguj.setFont(new Font(label_zaloguj.getFont().getFontName(),label_zaloguj.getFont().getStyle(),10));

        czy_poprawny_kod = new JLabel(" ");
        czy_poprawny_kod.setBounds(155,175,130,30);
        czy_poprawny_kod.setFont(new Font(czy_poprawny_kod.getFont().getFontName(),czy_poprawny_kod.getFont().getStyle(),10));


        BufferedImage obrazek_logotyp = null;
        try {
            obrazek_logotyp = ImageIO.read(new File("zmyslonelogo.png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Image obrazek_logotypScaledInstance = obrazek_logotyp.getScaledInstance(250, 70, Image.SCALE_DEFAULT);
        wyswietla_obrazek_logotyp = new JLabel(new ImageIcon(obrazek_logotypScaledInstance));
        wyswietla_obrazek_logotyp.setBounds(50,50,270,80);



        panel_logowania.add(podaj_kod_dostepu);
        panel_logowania.add(przycisk_zaloguj);
        panel_logowania.add(wyswietla_obrazek_logotyp);
        panel_logowania.add(label_zaloguj);
        panel_logowania.add(czy_poprawny_kod);

        ramka.setSize(400,350);

        ramka.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(podaj_kod_dostepu.getText().equals("")) {

            ramkaZarzadzanie.setLocation(400,70);
            ramkaZarzadzanie.setVisible(true);
            ramka.setVisible(false);

        }else czy_poprawny_kod.setText("niepoprawny kod");


    }

    public static RamkaZarzadzanie getRamkaZarzadzanie() {
        return ramkaZarzadzanie;
    }

    public static void setRamkaZarzadzanie(RamkaZarzadzanie ramkaZarzadzanie) {
        RamkaStartowa.ramkaZarzadzanie = ramkaZarzadzanie;
    }
}
//public class java.GUI {
//    public static void main(String[] args) {
//        JPanel panel = new JPanel(new BorderLayout());
//        List<String> myList = new ArrayList<>(10);
//        for (int index = 0; index < 20; index++) {
//            myList.add("List Item " + index);
//        }
//        final JList<String> list = new JList<String>(myList.toArray(new String[myList.size()]));
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setViewportView(list);
//        list.setLayoutOrientation(JList.VERTICAL);
//        panel.add(scrollPane);
//        panel.setBounds(0,0,300,200);
//        JFrame frame = new JFrame("Demo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(panel);
//        frame.setSize(500, 250);
//        frame.setLayout(null);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//}

