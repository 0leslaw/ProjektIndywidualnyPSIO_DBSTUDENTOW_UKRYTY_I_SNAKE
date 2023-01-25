package Strategia_przyznaj_stypendium;

import Ludzie.Student;

public class Sposob_przyzn_styp_dladziennego implements Przyznanie_stypendium {

    @Override
    public void przyznajStypendium(Student student) {
        int stypendium = 0;
        int temp = 0;

        if (student.getLista_kursow().size() != 0) {
            int i = 0;
            while (student.getLista_kursow().size() > i) {
                temp += student.getLista_kursow().get(i).getOcenazkursu();
                i++;
            }
            temp = temp / student.getLista_kursow().size();
            if (temp > 4) {
                stypendium = 500;
            }
            if (temp == 5) {
                stypendium = 1000;
            }
            student.setStypendium(stypendium);
        }else student.setStypendium(400);
    }
}
