package GUI;

import Ludzie.*;

import javax.swing.*;
import java.awt.*;


    public class LudzieCellRenderer extends JPanel implements ListCellRenderer<Osoba> {

        private JLabel Linformacje = new JLabel();
        private JLabel Limie_nazwisko = new JLabel();
        private JLabel Lkursy = new JLabel();
        private JLabel Lpasek = new JLabel();

        public LudzieCellRenderer() {
            setLayout(null);
            Limie_nazwisko.setBounds(10,5,200,20);
            Limie_nazwisko.setFont(new Font(Limie_nazwisko.getFont().getFontName(),Font.BOLD,15));

            Lkursy.setBounds(15,100,500,15);
            Lkursy.setFont(new Font(Limie_nazwisko.getFont().getFontName(),Font.BOLD,10));

            Linformacje.setBounds(15,35,500,60);
            Linformacje.setFont(new Font(Limie_nazwisko.getFont().getFontName(),Font.BOLD,10));

            Lpasek.setBackground(Color.GRAY);
            Lpasek.setBounds(0,0,3,200);
            add(Limie_nazwisko);
            add(Lkursy);
            add(Linformacje);
            add(Lpasek);

        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Osoba> list,
                                                      Osoba osoba, int index, boolean isSelected, boolean cellHasFocus) {

            Linformacje.setText(osoba.toString());
            Limie_nazwisko.setText(osoba.getImie());
            if(osoba instanceof Student)
                Lkursy.setText(((Student) osoba).getNazwyKursow());
            Lkursy.setForeground(Color.blue.darker());

            if(osoba instanceof Student_dzienny)
                Lpasek.setBackground(Color.orange);
            if(osoba instanceof Student_zaoczny)
                Lpasek.setBackground(Color.GREEN.darker().darker());
            if(osoba instanceof Pracownik_uczelni)
                Lpasek.setBackground(Color.blue.darker());
            if(osoba instanceof Pracownik_uczelni_naukowo_dydaktyczny)
                Lpasek.setBackground(Color.MAGENTA.darker().darker());

            return this;
        }
}
