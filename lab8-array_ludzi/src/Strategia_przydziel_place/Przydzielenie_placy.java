package Strategia_przydziel_place;

import Ludzie.Pracownik;

import java.io.Serializable;

public interface Przydzielenie_placy extends Serializable {
    public void przydzielPlace(Pracownik pracownik);
}
