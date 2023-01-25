package Ludzie;

import Strategia_przydziel_place.Sposob_przydz_plac_dlaadmin;

import java.io.Serializable;
import java.util.Random;

public class Pracownik_uczelni extends Pracownik implements Serializable {


    public Pracownik_uczelni(String imie, int wiek, String nazwisko, String praca, int zarobki_pm) {
        super(imie, wiek, nazwisko, praca, zarobki_pm);

        przydzielenie_placy = new Sposob_przydz_plac_dlaadmin();
    }

    public Pracownik_uczelni(){
        Random random = new Random();
        String[] prace = {"Sekretarz","Księgowy","Kucharz","Sprzątacz","Pan z dziekanatu"};
        this.praca = prace[random.nextInt(0, prace.length)];
        wiek = random.nextInt(20,100);
        przydzielenie_placy = new Sposob_przydz_plac_dlaadmin();
    }

    public Pracownik_uczelni(String stanowisko){
        this.praca=stanowisko;
        przydzielenie_placy = new Sposob_przydz_plac_dlaadmin();

    }

    public String toString(){
        return "<html>  PRACOWNIK ADMINISTR.: <Br>"+super.toString()+"</html>";
    }
}
