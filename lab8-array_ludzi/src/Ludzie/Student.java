package Ludzie;

import Kursy.Kurs;
import Strategia_przyznaj_stypendium.Przyznanie_stypendium;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Student extends Osoba implements Serializable{

    protected String kierunek;
    protected int semestr;
    protected int nr_ind;
    protected int stypendium;
    protected List<Kurs> lista_kursow = new ArrayList<>();
    protected int czesne;
    protected Przyznanie_stypendium przyznanie_stypendium;






    public Student(String kierunek, int semestr, String imie, int wiek,String nazwisko,int nr_ind,int stypendium,int czesne) {
        super(imie, wiek,nazwisko);
        this.kierunek=kierunek;
        this.semestr=semestr;
        this.nr_ind=nr_ind;
        this.stypendium = stypendium;
        this.czesne = czesne;

    }


    public Student() {
        Random random = new Random();
        String[] kierunki = {"IST","TIN","CBE","INA","ISA"};
        this.kierunek=kierunki[random.nextInt(0, kierunki.length)];
        this.semestr= random.nextInt(1,11);
        this.wiek = random.nextInt(19,27);
        this.nr_ind = random.nextInt(392200,392300);
        stypendium = 0;
        int sem = semestr;
        lista_kursow.add(new Kurs(sem));
        lista_kursow.add(new Kurs(sem));
        lista_kursow.add(new Kurs(sem));


        while(lista_kursow.get(0).getNazwa() == lista_kursow.get(1).getNazwa() ||
                lista_kursow.get(1).getNazwa() == lista_kursow.get(2).getNazwa() ||
                lista_kursow.get(0).getNazwa() == lista_kursow.get(2).getNazwa()){
            lista_kursow.remove(0);
            lista_kursow.remove(0);
            lista_kursow.remove(0);

            lista_kursow.add(new Kurs(sem));
            lista_kursow.add(new Kurs(sem));
            lista_kursow.add(new Kurs(sem));

        }

    }

    public void przyznanieStypendium(){
        przyznanie_stypendium.przyznajStypendium(this);
    }



    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public int getSemestr() {
        return semestr;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }
    public int getNr_ind() {
        return nr_ind;
    }

    public void setNr_ind(int nr_ind) {
        this.nr_ind = nr_ind;
    }

    public int getStypendium() {
        return stypendium;
    }
    public List<Kurs> getLista_kursow() {
        return lista_kursow;
    }

    public void setLista_kursow(Kurs kurs) {
        this.lista_kursow.add(kurs);
    }

    public void setStypendium(int stypendium) {
        this.stypendium = stypendium;
    }

    public void setLista_kursow(List<Kurs> lista_kursow) {
        this.lista_kursow = lista_kursow;
    }

    public int getCzesne() {
        return czesne;
    }

    public void setCzesne(int czesne) {
        this.czesne = czesne;
    }
    public String toString(){
        String styp = Integer.toString(stypendium);
        if(stypendium == 0)
            styp = "Brak stypendium";


        return imie+" "+nazwisko+"\n | SEM: "+semestr+"\n | KIER.: "
                +kierunek+"\n | NR IND.: "+nr_ind+"\n | STYPENDIUM: "+styp;
    }
    public String getNazwyKursow(){
        String kursy = "  |  KURSY: ";
        for(Kurs kurs:lista_kursow){
            kursy = kursy+kurs.getNazwa()+", ";
        }
        return kursy;
    }
}
