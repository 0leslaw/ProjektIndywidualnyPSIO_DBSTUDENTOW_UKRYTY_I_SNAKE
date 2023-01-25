package Strategia_przyznaj_stypendium;

import Ludzie.Student;

public class Sposob_przyzn_styp_dlazaocznego implements Przyznanie_stypendium{


    public void przyznajStypendium(Student student) {
        int mnoznikczesnego = student.getCzesne() / 500;
        if(student.getCzesne() == 0){
            mnoznikczesnego = 1;
        }
        int stypendium =0;
        int temp =0;

        if(student.getLista_kursow().size()!=0) {
            int i = 0;
            while (student.getLista_kursow().size() > i) {
                temp += student.getLista_kursow().get(i).getOcenazkursu();
                i++;
            }
            temp = temp / student.getLista_kursow().size();
            if (temp > 4) {
                stypendium = 500 * mnoznikczesnego;
            }
            if (temp == 5) {
                stypendium = 1000 * mnoznikczesnego;
            }
            student.setStypendium(stypendium);
        }else student.setStypendium(500);
    }
}
