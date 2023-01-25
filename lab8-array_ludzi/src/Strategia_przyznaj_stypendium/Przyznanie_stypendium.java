package Strategia_przyznaj_stypendium;

import Ludzie.Student;

import java.io.Serializable;

public interface Przyznanie_stypendium extends Serializable {
    void przyznajStypendium(Student student);
}
