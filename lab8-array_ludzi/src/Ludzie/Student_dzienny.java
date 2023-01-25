package Ludzie;

import Strategia_przyznaj_stypendium.Sposob_przyzn_styp_dladziennego;

import java.io.Serializable;

public class Student_dzienny extends Student implements Serializable {


    public Student_dzienny(){
        przyznanie_stypendium = new Sposob_przyzn_styp_dladziennego();
    }
    public Student_dzienny(String kierunek, int semestr, String imie, int wiek,String nazwisko,int nr_ind,int stypendium, int czesne) {
        super(kierunek, semestr, imie, wiek, nazwisko, nr_ind, stypendium,czesne);

        przyznanie_stypendium = new Sposob_przyzn_styp_dladziennego();
    }

    public String toString(){
        return "<html>  STUDENT DZIENNY: <br>"+super.toString()+"</html>";
    }
}
