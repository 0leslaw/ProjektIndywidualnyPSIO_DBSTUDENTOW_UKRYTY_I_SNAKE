package Ludzie;

import java.io.Serializable;
import java.util.Random;

public abstract class Osoba implements Serializable {

    protected String imie;
    protected int wiek;
    protected String nazwisko;

    public Osoba(){
        Random random = new Random();
        String[] imiona = {"Arek","Aleksander","Piotr","Karol","Filip","Mateusz","Stefan","Żyrard","Amadeusz","Jan","Krzysiu","Robert"};
        String[] nazwiska = {"Nowak","Kowalski","Milik","Lewandowski","Świderski","Żyła","Stoch","Bednarek","Piątek","Mbappe","Szczęsny"};
        imie = imiona[random.nextInt(0,imiona.length)];
        nazwisko = nazwiska[random.nextInt(0, nazwiska.length)];
        wiek = random.nextInt(1,100);
    }


    public Osoba(String imie,int wiek, String nazwisko){
        this.imie = imie;
        this.wiek = wiek;
        this.nazwisko = nazwisko;
    }


    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public abstract String toString();
}
