package Snek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Panel_gry extends JPanel implements ActionListener {
    private ArrayList<Snek> snek_lista = new ArrayList<>();
    private static int ROZM_PLYTKI;
    private static int WYSOKOSC;
    private static int SZEROKOSC;
    private static int DELAY;
    private ArrayList<Punkt> jablka = new ArrayList<>();
    private Timer timer;
    private boolean running = false;
    Random random= new Random();
    private int[][] sterowanie;
    private int ilosc_graczy;
    int podzialczestotliwosci = 0;
    private Color[] kolory;
    private int zwyciezca;
    public Panel_gry(int ilosc_graczy) throws InterruptedException, IOException {
        ROZM_PLYTKI = 16;
        SZEROKOSC = ROZM_PLYTKI*32;
        WYSOKOSC = ROZM_PLYTKI*32;
        DELAY = 20;
        if(ilosc_graczy>2){
            ROZM_PLYTKI = 8;
            SZEROKOSC = ROZM_PLYTKI*64;
            WYSOKOSC = ROZM_PLYTKI*64;
            DELAY = 15;
        }

        this.ilosc_graczy = ilosc_graczy;
        this.setBounds(35,35,SZEROKOSC,WYSOKOSC);
        this.setBackground(Color.DARK_GRAY.darker().darker().darker());
        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(new mojKeyAdpter());
        kolory = new Color[]{Color.blue, Color.red, Color.CYAN, Color.MAGENTA};

        for(int i=0;i<ilosc_graczy;i++) {
            if(i==0 || i == 3)
            snek_lista.add(new Snek(SZEROKOSC, i+1, true, ROZM_PLYTKI, kolory[i],false));
            else if(i == 1)
                snek_lista.add(new Snek(SZEROKOSC, i+2, true, ROZM_PLYTKI, kolory[i],false));
            else if(i == 2)
                snek_lista.add(new Snek(SZEROKOSC, i, true, ROZM_PLYTKI, kolory[i],false));
        }
//        snek_lista.add(new Snek(SZEROKOSC,3,true,ROZM_PLYTKI,Color.red));
//
//        jablka.add(new Punkt(16*11,128,16));
//        jablka.add(new Punkt(16*20,128*3-ROZM_PLYTKI,16));
        for(int i = 0;i<ilosc_graczy*6;i++){
            noweJabko();
        }


        sterowanie = new int[4][4];
        sterowanie[0] = new int[]{KeyEvent.VK_W, KeyEvent.VK_P,KeyEvent.VK_NUMPAD8,KeyEvent.VK_Y};
        sterowanie[1] = new int[]{KeyEvent.VK_S, KeyEvent.VK_SEMICOLON, KeyEvent.VK_NUMPAD5, KeyEvent.VK_H};
        sterowanie[2] = new int[]{KeyEvent.VK_A,KeyEvent.VK_L,KeyEvent.VK_NUMPAD4,KeyEvent.VK_G};
        sterowanie[3] = new int[]{KeyEvent.VK_D,KeyEvent.VK_QUOTE,KeyEvent.VK_NUMPAD6,KeyEvent.VK_J};
        startGame();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void restart() throws IOException {
        snek_lista.removeAll(snek_lista);
        for(int i=0;i<ilosc_graczy;i++) {
            if(i==0 || i == 3)
                snek_lista.add(new Snek(SZEROKOSC, i+1, true, ROZM_PLYTKI, kolory[i],false));
            else if(i == 1)
                snek_lista.add(new Snek(SZEROKOSC, i+2, true, ROZM_PLYTKI, kolory[i],false));
            else if(i == 2)
                snek_lista.add(new Snek(SZEROKOSC, i, true, ROZM_PLYTKI, kolory[i],false));
        }
        zwyciezca = 0;
    }
    public void draw(Graphics g) {
        if(true) {
            g.setColor(Color.red);
            for (Punkt jabko : jablka)
                if(jablka.lastIndexOf(jabko)!=0)
                g.fillOval(jabko.getX(), jabko.getY(), ROZM_PLYTKI, ROZM_PLYTKI);

            g.setColor(Color.orange);
            g.fillOval(jablka.get(0).getX(),jablka.get(0).getY(),ROZM_PLYTKI,ROZM_PLYTKI);
            Color[] kolory = {Color.orange,Color.orange.brighter(),Color.orange.darker().darker(),Color.orange.brighter().brighter(),
                    Color.orange.darker().darker().darker()};
            for (Snek snek : snek_lista) {
                for (int i = 1; i < snek.getLista_punktow().size(); i++) {
                    if(snek.getKolor() == Color.ORANGE){
                        g.setColor(kolory[random.nextInt(0, kolory.length-1)]);
                        g.fillRect(snek.getLista_punktow().get(i).getX(), snek.getLista_punktow().get(i).getY(),
                                snek.getLista_punktow().get(i).getSkala(), snek.getLista_punktow().get(i).getSkala());
                    }else {
                        g.setColor(snek.getKolor());
                        g.fillRect(snek.getLista_punktow().get(i).getX(), snek.getLista_punktow().get(i).getY(),
                                snek.getLista_punktow().get(i).getSkala(), snek.getLista_punktow().get(i).getSkala());
                    }
                }
                g.setColor(new Color(Math.min(snek.getKolorPierwszy().getRed()+100,255),Math.min(snek.getKolorPierwszy().getGreen()+100,255),
                        Math.min(snek.getKolorPierwszy().getBlue()+100,255),Math.min(snek.getKolorPierwszy().getAlpha()+100,255)));
                g.fillRect(snek.getLista_punktow().get(0).getX(), snek.getLista_punktow().get(0).getY(),
                        snek.getLista_punktow().get(0).getSkala(), snek.getLista_punktow().get(0).getSkala());
            }
            for (Snek snek : snek_lista){
                g.setColor(snek.getKolorPierwszy());
                g.setFont(new Font("SansSerif",0,20));
                if(snek.getRog_startu() == 1)
                g.drawString("jabka: "+snek.getIloscJablek(),SZEROKOSC-80,20);
                else if(snek.getRog_startu() == 2)
                    g.drawString("jabka: "+snek.getIloscJablek(),5,20);
                else if(snek.getRog_startu() == 3)
                    g.drawString("jabka: "+snek.getIloscJablek(),5,WYSOKOSC-15);
                else if(snek.getRog_startu() == 4)
                    g.drawString("jabka: "+snek.getIloscJablek(),SZEROKOSC-80,WYSOKOSC -15);

            }
        if(!running)
            gameOver(g,snek_lista.get(zwyciezca));
        }
    }
    public void noweJabko(){
        jablka.add(new Punkt(random.nextInt(SZEROKOSC/ROZM_PLYTKI)*ROZM_PLYTKI,
                random.nextInt(WYSOKOSC/ROZM_PLYTKI)*ROZM_PLYTKI,ROZM_PLYTKI));
    }
    public void sprawdzenieIleGraczy(){
        int ilosc_zywych = 0;
        int maxscore = 0;
        int snekroboczy=-1;
        for (int i = 0;i<snek_lista.size();i++)
            if(!snek_lista.get(i).isMartwy()) {
                ilosc_zywych++;
                snekroboczy = i;
            }

        if(ilosc_zywych == 1){
            running = false;
            zwyciezca = snekroboczy;
            timer.stop();
        }
        if(ilosc_zywych == 0){
            for(Snek snek1:snek_lista)
                if(snek1.getIloscJablek()>maxscore)
                    maxscore = snek1.getIloscJablek();
            for (Snek snek1:snek_lista)
                if(snek1.getIloscJablek() == maxscore)
                    zwyciezca = snek_lista.lastIndexOf(snek1);
            running = false;
            timer.stop();
        }




    }
    public void ruch(){
        if(ilosc_graczy>1) {
            for (Snek snek : snek_lista) {
                if (!snek.isMartwy()) {
                    if(podzialczestotliwosci % 3 ==0 && snek.getKolor() != Color.orange) {
                        snek.ruch();
                    }
                    if(snek.getKolor() == Color.orange) {
                        if(podzialczestotliwosci % 2 ==0)
                            snek.ruch();

                        if(podzialczestotliwosci % 16 == 0)
                            skrocWeza(snek);

                    }
                }
            }
        }else if(ilosc_graczy==1 && snek_lista.get(0).isMartwy()){
            running = false;
            timer.stop();
            zwyciezca = 0;
        }else {
            if(snek_lista.get(0).getKolor() != Color.orange && podzialczestotliwosci % 3 == 0) {
                    snek_lista.get(0).ruch();

            }else
            if(snek_lista.get(0).getKolor() == Color.orange){
//                if(podzialczestotliwosci % 16 == 0){
//                    skrocWeza(snek_lista.get(0));
//                }
                if(podzialczestotliwosci % 2==0) {
                    snek_lista.get(0).ruch();
                }
            }
        }
    }
    public void skrocWeza(Snek snek){
        if(snek.getLista_punktow().size()>3)
        snek.getLista_punktow().remove(snek.getLista_punktow().size()-1);
        else snek.setKolor(snek.getKolorPierwszy());
    }
    public void sprawdzkolizje(){
        boolean zderzon = false;
        for (Snek snek : snek_lista) {
            zderzon = false;
            for (Snek snek1:snek_lista) {
                for (int i = 2; i < snek1.getLista_punktow().size() - 1; i++) {
                    if (snek1.getLista_punktow().get(i).getX() == snek.getLista_punktow().get(1).getX() &&
                            snek1.getLista_punktow().get(i).getY() == snek.getLista_punktow().get(1).getY())
                        zderzon = true;
                }
            }
            if (snek.getLista_punktow().get(1).getX() <= 0-ROZM_PLYTKI || snek.getLista_punktow().get(1).getX() >= SZEROKOSC ||
                    snek.getLista_punktow().get(1).getY() <= 0-ROZM_PLYTKI || snek.getLista_punktow().get(1).getY() >= WYSOKOSC || zderzon) {
                snek.setMartwy(true);
            }
        }
    }
    public void sprawdzjabka(){
        for (int i=0;i<jablka.size();i++){
            for (Snek snek : snek_lista){
                if(jablka.get(i).getY() == snek.getLista_punktow().get(0).getY() &&
                        jablka.get(i).getX() == snek.getLista_punktow().get(0).getX()){
                    if(i==0){
                        if(snek.getKolor() == Color.orange) {
                            for (int j = 0;j<8;j++){
                                snek.getLista_punktow().add(new Punkt(10000, 1000, ROZM_PLYTKI));
                            }
                        }
                        snek.setKolor(Color.orange);
                    }
                    snek.getLista_punktow().add(new Punkt(snek.getLista_punktow().get(snek.getLista_punktow().size()-1).getX()-ROZM_PLYTKI,
                            snek.getLista_punktow().get(snek.getLista_punktow().size()-1).getY()-ROZM_PLYTKI,ROZM_PLYTKI));
                    jablka.set(i,new Punkt(random.nextInt(SZEROKOSC/ROZM_PLYTKI)*ROZM_PLYTKI,
                            random.nextInt(WYSOKOSC/ROZM_PLYTKI)*ROZM_PLYTKI,ROZM_PLYTKI));
                    snek.setIloscJablek(snek.getIloscJablek()+1);
                }
            }

        }
    }
    public void gameOver(Graphics g,Snek snek){
        g.setColor(snek.getKolorPierwszy());
        g.setFont(new Font("SansSerif",0,40));
        FontMetrics fontMetrics = getFontMetrics(g.getFont());
        g.drawString("Wygrywa gracz: " + (snek_lista.lastIndexOf(snek)+1),(SZEROKOSC - fontMetrics.stringWidth("Wygrywa gracz: "))/2,WYSOKOSC/2);

    }
    public void startGame() {
        noweJabko();
        timer = new Timer(DELAY,this);
        running = true;
        timer.start();
    }

    public void reset() throws IOException, InterruptedException {
        if(!running) {
            for (Snek snek : snek_lista)
                snek = new Snek(SZEROKOSC, snek.getRog_startu(), true, ROZM_PLYTKI, snek.getKolor(),false);
            timer.start();
            running = true;

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            ruch();
            sprawdzjabka();
            sprawdzkolizje();
            podzialczestotliwosci++;
            if(ilosc_graczy>1)
                sprawdzenieIleGraczy();
        }
        repaint();

    }
    public class mojKeyAdpter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

//            for(Snek snek : snek_lista) {
//                if (e.getKeyCode() == sterowanie[0][snek_lista.indexOf(snek)]) {
//                    snek.zmieniaUstawienieGlowy(1);
//                }
//                if (e.getKeyCode() == sterowanie[1][snek_lista.indexOf(snek)]) {
//                    snek.zmieniaUstawienieGlowy(2);
//                }
//            }
            for(Snek snek : snek_lista) {
                if (e.getKeyCode() == sterowanie[0][snek_lista.indexOf(snek)]) {
                    if(snek.getKierunek() == 3)
                        snek.setNowy_kier(1);
                    else if(snek.getKierunek() == 4)
                        snek.setNowy_kier(1);
                }
                if (e.getKeyCode() == sterowanie[1][snek_lista.indexOf(snek)]) {
                    if(snek.getKierunek() == 4)
                        snek.setNowy_kier(2);
                    else if(snek.getKierunek() == 3)
                        snek.setNowy_kier(2);                }
                if (e.getKeyCode() == sterowanie[2][snek_lista.indexOf(snek)]) {
                    if(snek.getKierunek() == 2)
                        snek.setNowy_kier(3);
                    else if(snek.getKierunek() == 1)
                        snek.setNowy_kier(3);
                }
                if (e.getKeyCode() == sterowanie[3][snek_lista.indexOf(snek)]) {
                    if(snek.getKierunek() == 1)
                        snek.setNowy_kier(4);
                    else if(snek.getKierunek() == 2)
                        snek.setNowy_kier(4);
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){

                running = true;
                timer.start();
                try {
                    restart();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }

//            if(e.getKeyCode() == KeyEvent.VK_K){
//                snek_lista.get(1).zmieniaUstawienieGlowy(1);
//            }
//            if(e.getKeyCode() == KeyEvent.VK_L){
//                snek_lista.get(1).zmieniaUstawienieGlowy(2);
//            }
        }
    }
}
