package Strategia_przydziel_place;

import Ludzie.Pracownik;

public class Sposob_przydz_plac_dladyd implements Przydzielenie_placy{

    public void przydzielPlace(Pracownik pracownik){
        int placa =5000;
        if(pracownik.getWiek()>50){
            placa = 8000;
        }

        pracownik.setZarobki_pm(placa);
    }
}
