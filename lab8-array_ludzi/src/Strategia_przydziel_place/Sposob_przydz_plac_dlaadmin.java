package Strategia_przydziel_place;

import Ludzie.Pracownik;

public class Sposob_przydz_plac_dlaadmin implements Przydzielenie_placy{
    public void przydzielPlace(Pracownik pracownik){
        int placa =3000;
        if(pracownik.getWiek()>40){
            placa = 4000;
        }

        pracownik.setZarobki_pm(placa);
    }
}
