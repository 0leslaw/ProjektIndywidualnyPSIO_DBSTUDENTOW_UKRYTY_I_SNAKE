package Snek;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Snek {
    private ArrayList<Punkt> lista_punktow = new ArrayList<>();
    private Color kolor;
    private int kierunek;
    private int nowy_kier;
    private int rog_startu;
    private boolean martwy;
    private Color kolorPierwszy;
    private int iloscJablek;
    public Snek(int SZEROKOSC,int rog_startu,boolean czy_duzy,int rozmiar,Color kolor,boolean martwy) throws IOException {
        this.kolor = kolor;
        this.rog_startu = rog_startu;
        this.martwy = martwy;
        this.kolorPierwszy = kolor;

        iloscJablek = 0;
        int x,y;
        switch (rog_startu) {
            case 1:
                x = (SZEROKOSC/4)*3;
                y = (SZEROKOSC/4);
                for(int i=0;i<17;i++) {
                    lista_punktow.add(new Punkt(x + i*rozmiar, y, rozmiar));
                }
                kierunek = 3;
                break;
            case 2:
                x = (SZEROKOSC/4)-rozmiar;
                y = (SZEROKOSC/4);
                for(int i=0;i<17;i++) {
                    lista_punktow.add(new Punkt(x - i*rozmiar, y, rozmiar));
                }
                kierunek = 4;
                break;
            case 3:
                x = (SZEROKOSC/4)-rozmiar;
                y = (SZEROKOSC/4)*3-rozmiar;
                for(int i=0;i<17;i++) {
                    lista_punktow.add(new Punkt(x - i*rozmiar, y, rozmiar));
                }
                kierunek = 4;
                break;
            case 4:
                x = (SZEROKOSC/4)*3;
                y = (SZEROKOSC/4)*3-rozmiar;
                for(int i=0;i<17;i++) {
                    lista_punktow.add(new Punkt(x + i*rozmiar, y, rozmiar));
                }
                kierunek = 3;
                break;
            default:
                x = 2;
                y = 2;
                lista_punktow.add(new Punkt(x,y,rozmiar));
                lista_punktow.add(new Punkt(x+rozmiar,y,rozmiar));
                lista_punktow.add(new Punkt(x+2*rozmiar,y,rozmiar));

        }

        nowy_kier = kierunek;
    }

    public ArrayList<Punkt> getLista_punktow() {
        return lista_punktow;
    }

    public void setLista_punktow(ArrayList<Punkt> lista_punktow) {
        this.lista_punktow = lista_punktow;
    }

    public void przejecieWspolrzednychNastepnego(){
        for(int i=lista_punktow.size()-1;i>0;i--){
            lista_punktow.get(i).setX(lista_punktow.get(i-1).getX());
            lista_punktow.get(i).setY(lista_punktow.get(i-1).getY());
        }
    }
    public void ruch() {
        int kier = 0;
        int tempx = lista_punktow.get(1).getX();
        int tempy = lista_punktow.get(1).getY();

        przejecieWspolrzednychNastepnego();

        if (kierunek == nowy_kier) {
            if (lista_punktow.get(0).getX() == tempx) {
                if (lista_punktow.get(0).getY() < tempy) {
                    //gora
                    lista_punktow.get(0).decY();
                    kier = 1;
                }
                if (lista_punktow.get(0).getY() > tempy) {
                    //dol
                    lista_punktow.get(0).incY();
                    kier = 2;
                }
            } else if (lista_punktow.get(0).getY() == tempy) {
                if (lista_punktow.get(0).getX() < tempx) {
                    //lewo
                    lista_punktow.get(0).decX();
                    kier = 3;
                }
                if (lista_punktow.get(0).getX() > tempx) {
                    //prawo
                    lista_punktow.get(0).incX();
                    kier = 4;
                }
            }
        } else {
            if (kierunek == 1 || kierunek == 2) {
                if (nowy_kier == 3) {
                    lista_punktow.get(0).decX();
                }
                if (nowy_kier == 4) {
                    lista_punktow.get(0).incX();
                }
            }

            if (kierunek == 3 || kierunek == 4) {
                if (nowy_kier == 1) {
                    lista_punktow.get(0).decY();
                }
                if (nowy_kier == 2) {
                    lista_punktow.get(0).incY();
                }
            }

        }

        this.kierunek = nowy_kier;
    }
    public void zmieniaUstawienieGlowy(int lewo_prawo){
        int kierunek_nowy = 0;
        przejecieWspolrzednychNastepnego();
        switch (lewo_prawo){
            case 1:
                switch (kierunek){
                    case 1:
                        lista_punktow.get(0).decX();
//                        lista_punktow.get(0).incY();
                        kierunek_nowy = 3;
                        break;
                    case 2:
                        lista_punktow.get(0).incX();
//                        lista_punktow.get(0).decY();
                        kierunek_nowy = 4;
                        break;
                    case 3:
//                        lista_punktow.get(0).incX();
                        lista_punktow.get(0).incY();
                        kierunek_nowy = 2;
                        break;
                    case 4:
//                        lista_punktow.get(0).decX();
                        lista_punktow.get(0).decY();
                        kierunek_nowy = 1;
                        break;
                }
                break;
            case 2:
                switch (kierunek){
                    case 1:
                        lista_punktow.get(0).incX();
//                        lista_punktow.get(0).incY();
                        kierunek_nowy = 4;
                        break;
                    case 2:
                        lista_punktow.get(0).decX();
//                        lista_punktow.get(0).decY();
                        kierunek_nowy = 3;
                        break;
                    case 3:
//                        lista_punktow.get(0).incX();
                        lista_punktow.get(0).decY();
                        kierunek_nowy = 1;
                        break;
                    case 4:
//                        lista_punktow.get(0).decX();
                        lista_punktow.get(0).incY();
                        kierunek_nowy = 2;
                        break;
                }
        }
        this.kierunek = kierunek_nowy;
//        smieszny pattern
//        switch (lewo_prawo){
//            case 1:
//                switch (kierunek){
//                    case 1:
//                        lista_punktow.get(0).decX();
//                        lista_punktow.get(0).incY();
//                        kierunek_nowy = 3;
//                        break;
//                    case 2:
//                        lista_punktow.get(0).incX();
//                        lista_punktow.get(0).decY();
//                        kierunek_nowy = 4;
//                        break;
//                    case 3:
//                        lista_punktow.get(0).incX();
//                        lista_punktow.get(0).incY();
//                        kierunek_nowy = 2;
//                        break;
//                    case 4:
//                        lista_punktow.get(0).decX();
//                        lista_punktow.get(0).decY();
//                        kierunek_nowy = 1;
//                        break;
//                }
//            case 2:
//                switch (kierunek){
//                    case 1:
//                        kierunek_nowy = 4;
//                        lista_punktow.get(0).incX();
//                        lista_punktow.get(0).incY();
//                        break;
//                    case 2:
//                        lista_punktow.get(0).decX();
//                        lista_punktow.get(0).decY();
//                        kierunek_nowy = 3;
//                        break;
//                    case 3:
//                        lista_punktow.get(0).incX();
//                        lista_punktow.get(0).decY();
//                        kierunek_nowy = 1;
//                        break;
//                    case 4:
//                        lista_punktow.get(0).decX();
//                        lista_punktow.get(0).incY();
//                        kierunek_nowy = 2;
//                        break;
//                }
//        }
//        this.kierunek = kierunek_nowy;
    }


    public Color getKolor() {
        return kolor;
    }

    public void setKolor(Color kolor) {
        this.kolor = kolor;
    }
    public int getKierunek() {
        return kierunek;
    }

    public void setKierunek(int kierunek) {
        this.kierunek = kierunek;
    }

    public int getRog_startu() {
        return rog_startu;
    }

    public void setRog_startu(int rog_startu) {
        this.rog_startu = rog_startu;
    }

    public boolean isMartwy() {
        return martwy;
    }

    public void setMartwy(boolean martwy) {
        this.martwy = martwy;
    }

    public Color getKolorPierwszy() {
        return kolorPierwszy;
    }

    public void setKolorPierwszy(Color kolorPierwszy) {
        this.kolorPierwszy = kolorPierwszy;
    }

    public int getIloscJablek() {
        return iloscJablek;
    }

    public void setIloscJablek(int iloscJablek) {
        this.iloscJablek = iloscJablek;
    }

    public int getNowy_kier() {
        return nowy_kier;
    }

    public void setNowy_kier(int nowy_kier) {
        this.nowy_kier = nowy_kier;
    }
}
