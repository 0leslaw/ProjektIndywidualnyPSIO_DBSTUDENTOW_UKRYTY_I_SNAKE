package Ludzie;

import Strategia_przydziel_place.Przydzielenie_placy;

import java.io.Serializable;
import java.util.Random;

public abstract class Pracownik extends Osoba implements Serializable {

    protected String praca;
    protected int zarobki_pm;
    protected Przydzielenie_placy przydzielenie_placy;



    public Pracownik(){
        Random random = new Random();
        praca = null;
        zarobki_pm = random.nextInt(3000,20000);
    }
    public Pracownik(String imie, int wiek, String nazwisko, String praca,int zarobki_pm) {
        super(imie, wiek, nazwisko);
        this.zarobki_pm=zarobki_pm;
        this.praca=praca;
    }

    public void przydzielPlace(){
        przydzielenie_placy.przydzielPlace(this);
    }

    public String getPraca() {
        return praca;
    }

    public void setPraca(String praca) {
        this.praca = praca;
    }

    public int getZarobki_pm() {
        return zarobki_pm;
    }

    public void setZarobki_pm(int zarobki_pm) {
        this.zarobki_pm = zarobki_pm;
    }

    public String toString(){
        return imie+" "+nazwisko+"\n | STANOWISKO: "+praca+"\n | ZAROBKI: " +zarobki_pm;
    }
}
