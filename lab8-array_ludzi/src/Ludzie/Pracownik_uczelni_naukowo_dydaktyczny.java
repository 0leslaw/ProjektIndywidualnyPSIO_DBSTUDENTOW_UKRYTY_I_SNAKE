package Ludzie;

import Strategia_przydziel_place.Sposob_przydz_plac_dladyd;

import java.io.Serializable;
import java.util.Random;

public class Pracownik_uczelni_naukowo_dydaktyczny extends Pracownik implements Serializable {

    private int wartosc_dorobku;

    public Pracownik_uczelni_naukowo_dydaktyczny(String imie, int wiek, String nazwisko, String praca, int zarobki_pm,
                                                 int wartosc_dorobku) {
        super(imie, wiek, nazwisko, praca, zarobki_pm);
        this.wartosc_dorobku = wartosc_dorobku;

        przydzielenie_placy = new Sposob_przydz_plac_dladyd();
    }

    public Pracownik_uczelni_naukowo_dydaktyczny(int wartosc_dorobku){
        Random random = new Random();
        String[] prace = {"Wykładowca","Prowadzący ćwiczenia","Dziekan","Rektor"};
        this.praca = prace[random.nextInt(0, prace.length)];
        this.wartosc_dorobku=wartosc_dorobku;

        przydzielenie_placy = new Sposob_przydz_plac_dladyd();
    }

    public Pracownik_uczelni_naukowo_dydaktyczny(){
        Random random = new Random();
        wartosc_dorobku = random.nextInt(0,100);
        String[] prace = {"Wykładowca","Prowadzący ćwiczenia","Dziekan","Rektor"};
        this.praca = prace[random.nextInt(0, prace.length)];
        wiek = random.nextInt(25,100);

        przydzielenie_placy = new Sposob_przydz_plac_dladyd();
    }


    public int getWartosc_dorobku() {
        return wartosc_dorobku;
    }

    public void setWartosc_dorobku(int wartosc_dorobku) {
        this.wartosc_dorobku = wartosc_dorobku;
    }

    public String toString(){
        return "<html>  PRACOWNIK N.D.: <br>"+super.toString()+ "\n | WART. DOROBKU: "+wartosc_dorobku+"</html>";
    }

}
