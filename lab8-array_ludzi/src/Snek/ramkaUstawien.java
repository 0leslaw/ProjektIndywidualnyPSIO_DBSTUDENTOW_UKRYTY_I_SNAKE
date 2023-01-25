package Snek;

import javax.swing.*;
import java.awt.*;

public class ramkaUstawien extends JFrame {
    private JButton przycisk;
    private JLabel Lilosc_g = new JLabel("Ilosc graczy: ");
    private JTextField ilosc_g = new JTextField(10);
//    private Start start;
    public ramkaUstawien(){
//        this.start = start;
        this.setTitle("snek");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        ImageIcon logo = new ImageIcon("snek.png");
        this.setIconImage(logo.getImage());
        Point punkt = new Point(700,300);
        this.setLocation(punkt);
        this.setVisible(true);
        this.setSize(200,200);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        przycisk = new JButton();
//        przycisk.addActionListener(this);
        przycisk.setBounds(150,5,50,30);
        this.add(przycisk);
        Lilosc_g.setBounds(5,5,75,30);
        this.add(Lilosc_g);
        ilosc_g.setBounds(100,5,50,30);
        this.add(ilosc_g);

    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == przycisk){
//            try {
//                start.restart(Integer.parseInt(ilosc_g.getText()));
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            } catch (InterruptedException ex) {
//                throw new RuntimeException(ex);
//            }
//        this.setVisible(false);
//        }
//    }
}
