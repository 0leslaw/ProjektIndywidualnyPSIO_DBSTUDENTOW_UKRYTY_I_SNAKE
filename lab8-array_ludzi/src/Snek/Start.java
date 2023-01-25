package Snek;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Start extends JFrame {

        private Panel_gry panel_gry;



//        private ramkaUstawien ramkaUstawien = new ramkaUstawien(this);

    public Start(int ilosc_graczy) {
        {
            try {
                panel_gry = new Panel_gry(ilosc_graczy);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.setTitle("snek");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        ImageIcon logo = new ImageIcon("snek.png");
        this.setIconImage(logo.getImage());
        Point punkt = new Point(500,100);
        this.setLocation(punkt);
        this.setVisible(true);
        this.setSize(600,600);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
//        this.add(ramkaUstawien);
        this.add(panel_gry);


    }
//    public void restart(int ilosc_graczy) throws IOException, InterruptedException {
//        this.remove(panel_gry);
//        panel_gry = new Panel_gry(ilosc_graczy);
//        this.add(panel_gry);
//        panel_gry.startGame();
//    }



    }


