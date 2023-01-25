package Ludzie;

import Strategia_przyznaj_stypendium.Sposob_przyzn_styp_dlazaocznego;

import java.io.Serializable;
import java.util.Random;

public class Student_zaoczny extends Student implements Serializable {

    public Student_zaoczny(){
        Random random = new Random();
        czesne = random.nextInt(1200,2000);
        przyznanie_stypendium = new Sposob_przyzn_styp_dlazaocznego();
    }

    public Student_zaoczny(String kierunek, int semestr, String imie, int wiek,String nazwisko,int nr_ind,int stypendium,int czesne) {
        super(kierunek, semestr, imie, wiek, nazwisko, nr_ind,stypendium,czesne);
        przyznanie_stypendium = new Sposob_przyzn_styp_dlazaocznego();
    }

    public String toString(){
        return "<html>  STUDENT ZAOCZNY: <br>"+super.toString()+"</html>";
    }
}
